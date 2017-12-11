package com.unimedsci.ydata.jxz.commons.datas;

/**
 * 
 * @author wanglie
 * 
 */
public class Region {
	private String regionId;
	private String parentId;
	private String regionName;
	private Double longitude;
	private Double latitude;

	// public Integer level;

	/*
	 * public Integer getLevel() { return level; } public void setLevel(Integer
	 * level) { this.level = level; }
	 */
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
