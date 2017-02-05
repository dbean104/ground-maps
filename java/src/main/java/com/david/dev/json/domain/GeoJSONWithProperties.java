package com.david.dev.json.domain;

public class GeoJSONWithProperties {

	private final String type = "FeatureCollection";
	private final FootballGroundEntry[] features;
	
	public GeoJSONWithProperties(FootballGroundEntry[] groundEntries) {
		this.features = groundEntries;
	}
}
