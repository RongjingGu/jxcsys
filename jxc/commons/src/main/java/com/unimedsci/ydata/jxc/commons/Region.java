package com.unimedsci.ydata.jxc.commons;

/**
 * 
 * @author wanglie
 *
 */
public class Region {
	private String regionId;
	private String parentId;
	private String regionName;

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

}
