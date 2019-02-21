package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import com.techelevator.controller.CampgroundController;
import com.techelevator.model.CampgroundModel;
import com.techelevator.view.Menu;

public class CampgroundCLI {


	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campgrounds");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		CampgroundModel model = new CampgroundModel(dataSource);
		Menu menu = new Menu();
		CampgroundController controller = new CampgroundController(model, menu);
		controller.run();
	}

}
