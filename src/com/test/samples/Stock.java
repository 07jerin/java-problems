package com.test.samples;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Stock {

	String name;
	LocalDate date;
	int quantity;
	
	public Map<LocalDate, Map<String,Integer>> process(List<Stock> stocks) {
		
//		stocks.stream().collect(Collectors.groupingBy(e -> e.date, Collectors.mapping(e -> { }, null)))
		return null;
	}
}

