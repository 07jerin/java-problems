package com.test.samples;

import java.util.HashMap;
import java.util.Map;

public class HashMapInitialCapacity {
	
	public static void main(String[] args) {
		Map<Integer, Integer> m = new HashMap<>(2);
		m.put(1, 1);
		m.put(2, 2);
//		m.put(3, 3);
	}

}

