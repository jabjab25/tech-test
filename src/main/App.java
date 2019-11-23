package main;
import main.Csv;

public class App {

	public static void main(String[] args) {
		Csv csv = new Csv();
		csv.updateRowValues("test.csv", "origin", "Londom", "London");

	}

}
