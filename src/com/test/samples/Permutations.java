package com.test.samples;

import org.junit.Test;

public class Permutations {

	@Test
	public void permutationTest() {
//		printPermutations("AB");
//		printPermutations("ABC");
		printPermutations("ABCD");
	}

	public void printPermutations(String ip) {

		permutations("", ip);

	}

	private void permutations(String prefix, String suffix) {

		if (suffix.length() == 0) {
			System.out.println(prefix);
		} else {

			char[] arr = suffix.toCharArray();
			for (int i = 0; i < arr.length; i++) {

				String newSuffix = suffix.substring(0, i);
				if (i + 1 < arr.length) {
					newSuffix += suffix.substring(i + 1, arr.length);
				}

				permutations(prefix + arr[i], newSuffix);
			}

		}

	}
}

//	 "" ABCD
//	
//	A BCD 
//		AB CD 
//		AC BD
// 	
//	ABC D
//	ABCD --> 
//	perm(prefix, suffix){
//		
//		if(suffix.lenght == 0) {
//			sout -> prefix
//		}
//		
//		for(eachchar in suffix ) {
//			perm(prefix + char , suffix - char )
//		}
//		
//	}

//}
