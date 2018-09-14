package com.main.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStrings {
	private String[] randomNames = {"Arjun", "Robert", "Jenifer","Vilbert"};
	private String[] randomAges = {"18", "22", "26","29"};
	private List<TestData> dataList = null;
	private TestData data = null;

	public String getrandomNames() {
		int indx = new Random().nextInt(randomNames.length);
		return randomNames[indx];
	}
	
	public String getrandomAges() {
		int indx = new Random().nextInt(randomAges.length);
		return randomAges[indx];
	}
	
	public List<TestData> getGeneratedData() {
		dataList = new ArrayList<>();
		for(int i = 0; i < randomNames.length; i++) {
			data = new TestData(getrandomNames(), getrandomAges());
			dataList.add(data);
		}
		return dataList;
	}
}

