package main;

import java.io.*;
import java.util.ArrayList;

public class Csv {
	private ArrayList<String> csvFile = new ArrayList<String>();
	
	public Csv () {
	}
	
	public void updateRowValues(String csvFileName, String column, String oldValue, String newValue) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFileName));
			String line;
			String[] headers =  {"filename", "origin", "metadata", "hash"};
			String[] values = new String[5];
			int colNumber = 0;
			int i = 0;
			for(int index = 0;index < headers.length;index++) {
				if (headers[index].equals(column) ) {
					colNumber = index;
				} }
			
			while((line = br.readLine()) != null) {
				String value = "";
				System.out.println(line);
				String[] test = line.split(",");
					if (test[colNumber].contains(oldValue) ) {
						test[colNumber] = newValue;
					}
					value = value.join(",", test);
					value = value + "\n";
					values[i] = value;
					i++;
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(csvFileName));
			for(int index=0;index < values.length;index++) {
				System.out.println(values[index]);
				bw.append(values[index]);
			}
			bw.flush();
			bw.close();
			br.close();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

