package com.techelevator.data;

import java.util.List;

import com.techelevator.model.Site;


public interface SiteDAO {

	public List<Site> getSitesByCampgroundId(long campgroundId);
	public List<Site> getSitesByParkId(long parkId);
}
