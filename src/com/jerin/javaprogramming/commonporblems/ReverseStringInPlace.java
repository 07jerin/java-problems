package com.jerin.javaprogramming.commonporblems;

public class ReverseStringInPlace {

	public static void main(String[] args) {
		System.out.println(reverse("abc"));
		System.out.println(reverse("abcdefg"));
		System.out.println(reverse("123456"));
	}

	private static String reverse(String ip) {
		char temp = 'a';
		StringBuilder sb = new StringBuilder(ip);
		for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
			temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, temp);
		}
		return sb.toString();
	}

}
