package com.jerin.puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KruskalsAlgorithm {
	public static void main(String args[]) throws Exception {

		// Scanner
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		int vCount = Integer.parseInt(arr[0]);
		int eCount = Integer.parseInt(arr[1]);

		LinkedList<Edge> edges = new LinkedList<>();
		while (eCount > 0) {
			arr = sc.nextLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);
			edges.add(new KruskalsAlgorithm.Edge(a, b, w));
			eCount--;
		}

		Collections.sort(edges);

		Map<Integer, List<Integer>> groups = new HashMap<>();
		Map<Integer, Integer> edgeGroupMap = new HashMap<>();
		int counter = 0;
		int mstWeight = 0;
		while (edges.size() > 0) {

			Edge e = edges.remove(); // Cross check

			Integer g1 = edgeGroupMap.get(e.a);
			Integer g2 = edgeGroupMap.get(e.b);

			if (g1 != null && g2 != null) {

				// Merge g1 edges to g2 if they are not already in same group
				List<Integer> g1Edges = groups.get(g1);
				List<Integer> g2Edges = groups.get(g2);
				if (!g1.equals(g2)) {

					for (Integer g1Edge : g1Edges) {
						edgeGroupMap.put(g1Edge, g2);
					}
					g2Edges.addAll(g1Edges);
					groups.remove(g1);

					mstWeight += e.w;
					// if(g2Edges.size() == vCount){
					// break;
					// }
				}

			} else if (g1 != null) {
				// Add e.b to g1
				groups.get(g1).add(e.b);
				edgeGroupMap.put(e.b, g1);
				mstWeight += e.w;

				// if( groups.get(g1).size() == vCount){
				// break;
				// }
			} else if (g2 != null) {
				// Add e.a to g2
				groups.get(g2).add(e.a);
				edgeGroupMap.put(e.a, g2);
				mstWeight += e.w;
				// if( groups.get(g2).size() == vCount){
				// break;
				// }

			} else if (e.a != e.b) {
				// create new group
				int newGroup = e.a;
				edgeGroupMap.put(e.a, newGroup);
				edgeGroupMap.put(e.b, newGroup);
				List<Integer> ls = new ArrayList<Integer>();
				ls.add(e.a);
				ls.add(e.b);
				groups.put(newGroup, ls);
				mstWeight += e.w;
			}
		}

		System.out.println(mstWeight);

	}

	static class Edge implements Comparable<Edge> {
		public int a;
		public int b;
		public int w;

		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		public int compareTo(Edge other) {
			return this.w - other.w;
		}

	}
}
