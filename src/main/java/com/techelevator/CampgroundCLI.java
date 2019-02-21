package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import com.techelevator.controller.CampgroundController;
import com.techelevator.model.CampgroundModel;
import com.techelevator.view.Menu;

public class CampgroundCLI {


	public static void main(String[] args) {
		//DEFINE CONNECTION TO DATABASE
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campgrounds");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		//INSTANTIATE DEPENDENCIES FOR CONTROLLER
		CampgroundModel model = new CampgroundModel(dataSource);
		Menu menu = new Menu();
		
		//INSTANTIATE CONTROLLER
		CampgroundController controller = new CampgroundController(model, menu);
		
		//EXECUTE PROGRAM
		controller.run();
	}

}
