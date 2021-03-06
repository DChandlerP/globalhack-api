package com.antipattrn.ambassador.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "POSTALCODE")
    private String postalCode;

    @Column(name = "CONTACTINFORMATION")
    private String contactInformation;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "agency_tags",
            joinColumns = { @JoinColumn(name = "agency_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Tag> tags = new HashSet<>();

    public Agency() {
        //No Arg Constructor
    }

    public Agency(String id, String name, String description, String postalCode, String contactInformation) {
        this(name, description, postalCode, contactInformation);
        this.id = id;
    }

    public Agency(String name, String description, String postalCode, String contactInformation) {
        this.name = name;
        this.description = description;
        this.postalCode = postalCode;
        this.contactInformation = contactInformation;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public String getPostalCode() {
        return postalCode;
    }

    public String getContactInformation() { return contactInformation; }

    public Set<Tag> getTags() {
        return tags;
    }
}
