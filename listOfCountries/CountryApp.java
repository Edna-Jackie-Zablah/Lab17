package listOfCountries;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class CountryApp {

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		
		
		boolean notExit = true;
		do {
			System.out.println("MENU");
			System.out.println("1. Display list of countries");
			System.out.println("2. Add a Country");
			System.out.println("3. Exit.");
			int userOption = scnr.nextInt();
			if (userOption == 1) {
				// display the list
				List<Country> countries = CountriesFileUtil.readFile();
				for (Country c : countries) {
					System.out.println(c.toString());
				}
			} else if (userOption == 2) {
				// Write
				scnr.nextLine();
				System.out.println("Enter a Country to add?");
				String country = scnr.nextLine();
				System.out.println("Enter the population");
				int population = scnr.nextInt();
				Country newCountry = new Country(country, population);
				CountriesFileUtil.appendToFile(newCountry);
				System.out.println("This Country has been saved!");			
				
			

			}else if (userOption == 3) {
				System.out.println("Thank you, Good Bye");
				notExit = false;
			}

		}
		while(notExit == true);

		scnr.close();
	}//end of main

}// end CountryClass


