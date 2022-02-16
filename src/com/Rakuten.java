package com;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Rakuten {
	
	private Map<String, Long> printWordFreq(String[] ip) {

		Map<String, Long> freqMap = new HashMap<>();
		if(ip  == null) return freqMap;
		
		for (String str : ip) {
			
			if (str == null || "".equals(str.trim()))
				continue;
			
			str = str.toLowerCase();
			String[] words = str.split(" ");
			for (String word : words) {
				
				long count = freqMap.getOrDefault(word, 0l);
				freqMap.put(word, ++count);

			}
		}

		return freqMap;

	}

	private void printMap(Map<String, Long> freqMap) {
		
		for (Map.Entry<String, Long> stringFreq : freqMap.entrySet()) {
			System.out.println(stringFreq.getKey() + " " + stringFreq.getValue());
		}
	}

	@Test
	public void testPrint() {
		Map<String, Long> freqMap = printWordFreq(new String[] { "Hi Jerin Here", "Hi from Jerin","hi", "   ",  "", null });
		printMap(freqMap);
		
		
		freqMap = printWordFreq(new String[] {});
		printMap(freqMap);
		
		freqMap = printWordFreq(null);
		printMap(freqMap);

	}
	
	


}
