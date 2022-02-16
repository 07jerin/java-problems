package com.test.samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement Mobile Application Prefix Based Search which suggests you the applications in your mobile based on the input text
 * @author jerijose
 *
 * f - facebook, fingerprint
 * g - google
 * book - ""
 * h - hdfc bank 
 * b - hdfc bank , bang
 * 
 */
public class ApplicationSearch {
	
	private static final Map<String, List<String>> applicationPrefixMap = new HashMap<String, List<String>>();

	
	// TRIE , isWord, [applicationName] , an 
	//  an * al2 
	
	
	protected void addApplication(String applicationName) {
		if(applicationName == null || applicationName.trim() == "") {
			return;
		}
		
		String [] words = applicationName.split(" ");
		String previousWord = "";
		for(String word : words) {
			StringBuilder prefix = new StringBuilder();
			for(char c : word.toCharArray()) {
				prefix.append(c);
				
				addApplicationNameToMap(prefix.toString().toLowerCase(), applicationName);
				if(previousWord != "") {
					addApplicationNameToMap((previousWord + prefix.toString()).toLowerCase(), applicationName);
				}
				
			}
			previousWord = previousWord + word + " ";
		}
		
	}
	
	
	protected List<String> getApplications(String prefix){
		if(prefix == null || prefix.trim() == "") {
			return Collections.EMPTY_LIST;
		}
		return applicationPrefixMap.getOrDefault(prefix.toLowerCase(),Collections.EMPTY_LIST );
	}
	
	private void addApplicationNameToMap(String prefix, String applicationName) {
		List<String> applicationNames =  applicationPrefixMap.get(prefix);
		if(applicationNames == null) {
			applicationNames = new ArrayList<String>();
		}
		applicationNames.add(applicationName);
		
		applicationPrefixMap.put(prefix, applicationNames);
	}

	

}
