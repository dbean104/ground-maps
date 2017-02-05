package com.david.dev.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.david.dev.json.domain.FootballGroundEntry;
import com.david.dev.json.domain.GeoJSONWithProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONTranslator {

	private static final String FILE_PATH = "/Users/david/OneDrive/Tech/FootballGrounds.csv";
	
	public String createJSONObjects(List<FootballGroundEntry> groupEntries) {

		GeoJSONWithProperties finalJSON = new GeoJSONWithProperties(groupEntries.toArray(new FootballGroundEntry[0]));
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(finalJSON);
	}
	
	private static List<FootballGroundEntry> readGroundEntriesFromFile(String csvPath) {
		final List<FootballGroundEntry> retval = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(csvPath));) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] c = line.split(",");
				retval.add(new FootballGroundEntry(c[1], Double.valueOf(c[3]), Double.valueOf(c[2])));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retval;
	}
	
	public static void main(String[] args) {
		final List<FootballGroundEntry> data = readGroundEntriesFromFile(FILE_PATH);
		JSONTranslator translator = new JSONTranslator();
		String json = translator.createJSONObjects(data);
		System.out.println(json);
	}
}
