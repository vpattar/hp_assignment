package com.hp.assignment.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hp.assignment.entity.AssetEntity;

public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    
    @JsonManagedReference
    private Organization organization;
    
    @JsonBackReference
    private Set<AssetEntity> assets;

	public User() {
    }
 
    public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
    public Set<AssetEntity> getAssets() {
		return assets;
	}

	public void setAssets(Set<AssetEntity> assets) {
		this.assets = assets;
	}

}
