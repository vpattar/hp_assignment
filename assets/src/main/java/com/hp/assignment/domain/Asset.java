package com.hp.assignment.domain;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.hp.assignment.common.AssetType;

public class Asset {

    private Integer id;
    
	@NotNull(message = "Name cannot be null")
    private String name;
	
	@NotNull(message = "Brand cannot be null")
    private String brand;
	
	@NotNull(message = "Model cannot be null")
    private String model;
	
	@NotNull(message = "Serial Number cannot be null")
    private String serial_number;
	
	@NotNull(message = "Type cannot be null")
    private AssetType type;
	
	@NotNull(message = "Acquisition cannot be null")
    private Date acquisition;
	
	@NotNull(message = "Warranty Expiration cannot be null")
    private Date warranty_expiration;
	
    private Integer owner_id;
    private Integer user_id;
    private Integer asset_id;
    
    @NotNull(message = "Retired cannot be null")
    private Boolean retired;
    
    @NotNull(message = "Cost cannot be null")
    private Integer cost;

    public Asset() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public AssetType getType() {
		return type;
	}

	public void setType(AssetType type) {
		this.type = type;
	}

	public Date getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(Date acquisition) {
		this.acquisition = acquisition;
	}

	public Date getWarranty_expiration() {
		return warranty_expiration;
	}

	public void setWarranty_expiration(Date warranty_expiration) {
		this.warranty_expiration = warranty_expiration;
	}

	public Integer getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(Integer asset_id) {
		this.asset_id = asset_id;
	}

	public Boolean getRetired() {
		return retired;
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

}
