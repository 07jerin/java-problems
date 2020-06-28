package com.test.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class EmptyListIteration {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<>();
		//	ls.add("Jerin");
		for (String a : ls) { // No need of if check
			System.out.println(a);
		}

	}
}
