package com.techelevator.model;

public class Site {
	
	private long siteId;
	private long campgroundId;
	private int siteNumber;
	private int maxOccupancy;
	private boolean isHandicapAccessible;
	private int maxRvLength;
	private boolean hasUtilityHookup;
	
	public long getSiteId() {
		return siteId;
	}
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
	public long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public int getSiteNumber() {
		return siteNumber;
	}
	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}
	public int getMaxOccupancy() {
		return maxOccupancy;
	}
	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	public boolean isHandicapAccessible() {
		return isHandicapAccessible;
	}
	public void setHandicapAccessible(boolean isHandicapAccessible) {
		this.isHandicapAccessible = isHandicapAccessible;
	}
	public int getMaxRvLength() {
		return maxRvLength;
	}
	public void setMaxRvLength(int maxRvLength) {
		this.maxRvLength = maxRvLength;
	}
	public boolean isHasUtilityHookup() {
		return hasUtilityHookup;
	}
	public void setHasUtilityHookup(boolean hasUtilityHookup) {
		this.hasUtilityHookup = hasUtilityHookup;
	}
	
	

}
