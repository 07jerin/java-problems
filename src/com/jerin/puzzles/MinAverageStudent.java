package com.jerin.puzzles;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

/*
 *Find the min average student
 */

class MinAverageStudent {
	
	public static String data[][] = { { "jerry", "65" }, { "bob", "91" }, { "jerry", "200" }, { "Eric", "83" } };

	private static String findMinAverageStudent(String[][] data) {
		Map<String, Pair<Integer, Integer>> studentMarks = MinAverageStudent.createTotalMarkMap(data);
		String minAverageStudent = "";
		Integer minAverage = Integer.MAX_VALUE;
		for (Map.Entry<String, Pair<Integer, Integer>> studentMark : studentMarks.entrySet()) {
			Integer currentAverage = studentMark.getValue().getValue() / studentMark.getValue().getKey();
			if (currentAverage < minAverage) {
				minAverage = currentAverage;
				minAverageStudent = studentMark.getKey();
			}
		}
		return minAverageStudent;

	}

	private static Map<String, Pair<Integer, Integer>> createTotalMarkMap(String[][] data) {
		Map<String, Pair<Integer, Integer>> studentMarks = new HashMap<>();
		for (int i = 0; i < data.length; i++) {
			String studentName = data[i][0];
			Integer mark = Integer.parseInt(data[i][1]);
			Pair<Integer, Integer> markDetail = studentMarks.get(studentName);
			if (markDetail == null) {
				markDetail = new Pair<Integer, Integer>(1, mark);

			} else {
				Integer count = markDetail.getKey() + 1;
				Integer cumulativeMark = markDetail.getValue() + mark;
				markDetail = new Pair<Integer, Integer>(count, cumulativeMark);

			}
			studentMarks.put(studentName, markDetail);
		}
		return studentMarks;
	}

	public static void main(String[] args) {
		System.out.println(MinAverageStudent.findMinAverageStudent(MinAverageStudent.data));
	}
}
