package com.david.dev.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.david.dev.json.domain.FootballGroundEntry;
import com.david.dev.json.domain.GeoJSONWithProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONTranslator {

	private static final String FILE_PATH = "FootballGrounds.csv";
	
	private static final int GROUND_NAME_IDX = 1;
	private static final int GROUND_LAT_IDX = 3;
	private static final int GROUND_LONG_IDX = 2;
	
	public String createJSONObjects(List<FootballGroundEntry> groupEntries) {

		GeoJSONWithProperties finalJSON = new GeoJSONWithProperties(groupEntries.toArray(new FootballGroundEntry[0]));
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(finalJSON);
	}
	
	private static List<FootballGroundEntry> readGroundEntriesFromFile(String csvPath) {
		final List<FootballGroundEntry> retval = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(FILE_PATH)))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] c = line.split(",");
				retval.add(new FootballGroundEntry(c[GROUND_NAME_IDX], Double.valueOf(c[GROUND_LONG_IDX]), Double.valueOf(c[GROUND_LAT_IDX])));
			}
			
		} catch (IOException e) {
			throw new IllegalStateException(e);
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
