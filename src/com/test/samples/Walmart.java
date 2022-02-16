package com.test.samples;

import java.util.Arrays;

import org.junit.Test;

public class Walmart {

//					{1, 0, 0, 0}
//	                {1, 1, 0, 1}
//	                {0, 1, 0, 0}
//	                {1, 1, 1, 1}
//	
//	
//					{1, 1, 1, 0}
//	                {1, 1, 0, 1}
//	                {1, 0, 0, 0}
//	                {1, 1, 1, 1}
//
//
//	
//	
//	for i = 0 -> m
//			for j = 0 -> n
//			 if(arr[i][j] = 1)
//			   dfs (i j )
//			   // break and return resultarr if path found
//			   
//			
//			   
//			   dfs(i, j, visited, arr, result)
//			   if( i == m and j == n) return true;
//				if(boundary) return false;
//					
//					if(arr[i][j] == 0) return false
//							
//					else 
//						bool found = dfs(i, j +1)
//							if(!found)
//								 dfs(i+1, j)
	
	
	
//		
	
	public static void main(String[] args) {
		

		int [][] ip1 = new int[4][4];
		ip1[0] = new int [] {1, 0, 0, 0};
		ip1[1] = new int [] {1, 1, 0, 1};
		ip1[2] = new int [] {0, 1, 0, 0};
		ip1[3] = new int [] {1, 1, 1, 1};
		
		
		
		int [][] ip2 = new int[4][4];
		ip2[0] = new int [] {1, 1, 1, 0};
		ip2[1] = new int [] {1, 1, 0, 1};
		ip2[2] = new int [] {1, 0, 0, 0};
		ip2[3] = new int [] {1, 1, 1, 1};
			
			
		
		int [][] result = new Walmart().findPath(ip2);
		for(int [] row : result) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	
	private int[][] findPath(int[][] ipArray){
		
		if(ipArray.length == 0) return new int[][] {};
		
		int m = ipArray.length;
		int n = ipArray[0].length;
		int [][] result = new int[m][n];
		int [][] visited = new int[m][n];
	
		if(ipArray[m-1][n-1] != 1) return result;
		
		traverse(ipArray, visited, result, 0, 0);
		
		return result;
		
		
	}
	
	private boolean traverse(int[][] ipArray, int [][] visited, int [][] result, int i, int j ){
			
		if(i == ipArray.length-1 && j == ipArray.length-1) {
			result[i][j] = 1;
			return true;
		} 
		if(i > ipArray.length-1 || j > ipArray.length-1 ) return false;
		
		if(ipArray[i][j] == 0 ||  visited[i][j] == 1 ) return false;
		
		visited[i][j] = 1;
		
		
		boolean isFound = traverse(ipArray, visited , result, i, j+1);
		if(!isFound) {
			isFound = traverse(ipArray, visited , result, i+1, j);
		}
		
		if(isFound) {
			result[i][j] = 1;
		}
		
		return isFound;
	
	}
		
	
}
