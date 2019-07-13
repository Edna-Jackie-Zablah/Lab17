package listOfCountries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CountriesFileUtil {

	private static FileLinesHelper linesHelper = new FileLinesHelper("src/countries.txt");

    //convert a line of text from the file to a new item instance
	private static Country convertLineToItem(String line) {
		String[] parts = line.split(", ");
		Country countries = new Country();
		countries.setName(parts[0]);
		countries.setPopulation(Long.parseLong(parts[1]));
		System.out.println(Arrays.toString(parts));
		return countries;

	}

	//convert an item instance to a line of text in the file
	private static String convertItemToLine(Country countries) {
		return String.format("%s, %d", countries.getName(), countries.getPopulation());
	}

	public static List<Country> readFile() {
		List<String> lines = linesHelper.readFile();
		List<Country> items = new ArrayList<>(lines.size());
		for (String line : lines) {
			items.add(convertLineToItem(line));
		}
		return items;
		}

	public static void rewriteFile(List<Country> items) throws IOException {
		List<String> lines = new ArrayList<>(items.size());
		for (Country item : items) {
			lines.add(convertItemToLine(item));
		}
		linesHelper.rewriteFile(lines);
	}

	public static void appendToFile(Country item) throws IOException {
		String line = convertItemToLine(item);
		linesHelper.appendToFile(line);
	}











}//end class
