package com.david.dev.json.domain;



public class FootballGroundEntry {
	
	private final String type = "Feature";
	private final Geometry geometry;
	private final GroundProperties properties;
	
	public FootballGroundEntry(String name, double longitude, double latitude) {
		this.geometry = new Geometry(longitude, latitude);
		this.properties = new GroundProperties(name);
	}


	private static class Geometry{
		private final String type = "Point";
		private final double[] coordinates;
		
		private Geometry(double longitude, double latitude) {
			this.coordinates = new double[2];
			coordinates[0] = longitude;
			coordinates[1] = latitude;
		}
		
	}
	
	private static class GroundProperties {
		private final String groundName;
		
		private GroundProperties(String name) {
			this.groundName = name;
		}
	}

}
