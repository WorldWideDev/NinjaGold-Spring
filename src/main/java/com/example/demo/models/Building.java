package com.example.demo.models;

import java.util.HashMap;
import java.util.Random;

public class Building {
	private String name;
	private int minGold;
	private int maxGold;
	public static HashMap<String, Building> GetDefaultBuildingsMap() {
		HashMap<String, Building> BuildingsMap = new HashMap<>();
		for(Building b : GetDefaultBuildingsArray()) {
			BuildingsMap.put(b.getName(), b);
		}
		return BuildingsMap;
	}
	
	public static Building[] GetDefaultBuildingsArray() {
		return new Building[] {
			new Building("House", 2, 5),
			new Building("Castle", 5, 8),
			new Building("Farm", 4, 7),
			new Building("Casino", -50, 50),
		};
	}
	
	public static GoldResult ProcessGold(Building building) {
		Random rand = new Random();
		int goldTurn = rand.nextInt((building.maxGold - building.minGold) + 1) + building.minGold;
		String message = String.format("You %s %d golds from the %s", 
				(goldTurn < 0) ? "lost" : "earned", 
				Math.abs(goldTurn), 
				building.name);
		return new GoldResult(message, goldTurn);
		
	}
	
	public Building(String name, int minGold, int maxGold) {
		
		this.name = name;
		this.minGold = minGold;
		this.maxGold = maxGold;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMinGold() {
		return minGold;
	}
	public void setMinGold(int minGold) {
		this.minGold = minGold;
	}
	public int getMaxGold() {
		return maxGold;
	}
	public void setMaxGold(int maxGold) {
		this.maxGold = maxGold;
	}
	
}
