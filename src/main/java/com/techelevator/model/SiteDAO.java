package com.techelevator.model;

import java.util.List;


public interface SiteDAO {

	public List<Site> getSitesByCampgroundId(long campgroundId);
	public List<Site> getSitesByParkId(long parkId);
}
