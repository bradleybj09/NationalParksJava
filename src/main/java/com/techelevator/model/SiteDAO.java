package com.techelevator.model;

import java.util.List;

public interface SiteDAO {

	public List<Site> getSitesByCampgroundId();
	public List<Site> getSitesByParkId();
}
