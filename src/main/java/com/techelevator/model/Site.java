package com.techelevator.model;

public class Site {
	
	private long siteId;
	private long campgroundId;
	private int siteNumber;
	private int maxOccupancy;
	private boolean isHandicapAccessible;
	private int maxRvLength;
	private boolean hasUtilityHookup;
	
	public Site(long campgroundId, int siteNumber, int maxOccupancy, boolean isHandicapAccessible, int maxRvLength, boolean hasUtilityHookup) {
		this.campgroundId = campgroundId;
		this.siteNumber = siteNumber;
		this.maxOccupancy = maxOccupancy;
		this.isHandicapAccessible = isHandicapAccessible;
		this.maxRvLength = maxRvLength;
		this.hasUtilityHookup = hasUtilityHookup;
	}
	
	public long getSiteId() {
		return siteId;
	}
	
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
	
	public long getCampgroundId() {
		return campgroundId;
	}

	public int getSiteNumber() {
		return siteNumber;
	}

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

	public boolean isHandicapAccessible() {
		return isHandicapAccessible;
	}

	public int getMaxRvLength() {
		return maxRvLength;
	}

	public boolean isHasUtilityHookup() {
		return hasUtilityHookup;
	}

}
