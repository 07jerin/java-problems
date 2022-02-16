package com.test.samples;

import java.util.List;

import org.junit.Test;

public class TestApplicationSearch {

	@Test
	public void testApplicationSearch() {
		ApplicationSearch appSearch = new ApplicationSearch();
		
		appSearch.addApplication("Facebook");
		appSearch.addApplication("Fingerprint");
		appSearch.addApplication("Hdfc Bank");
		appSearch.addApplication("Hdfc Banking");
		appSearch.addApplication("Hdfc Loan");
		appSearch.addApplication("Banking Loan");
		appSearch.addApplication(null);
		appSearch.addApplication("");
		appSearch.addApplication("A B C D F");
		
		List<String> Hdfc_B = appSearch.getApplications("Hdfc B");
		List<String> A_B_C = appSearch.getApplications("a b c");
		System.out.println(Hdfc_B);
		System.out.println(A_B_C);
		
		
//		List<String> face = appSearch.getApplications("f");
//		List<String> fIN = appSearch.getApplications("fIN");
//		List<String> hdfc = appSearch.getApplications("hdfc");
//		List<String> Bankings = appSearch.getApplications("Bankings");
//		System.out.println(face);
//		System.out.println(fIN);
//		System.out.println(hdfc);
//		System.out.println(Bankings);
		
		
//		
//		List<String> Face = appSearch.getApplications("Face");
//		List<String> ace = appSearch.getApplications("ace");
//		List<String> Facebook = appSearch.getApplications("Facebook");
//		List<String> f = appSearch.getApplications("F");
//		List<String> Hdfc = appSearch.getApplications("Hdfc");
//		List<String> Bank = appSearch.getApplications("Bank");
//		List<String> Loan = appSearch.getApplications("Loan");
//		
//		List<String> empty = appSearch.getApplications("empty");
//		List<String> _null = appSearch.getApplications(null);
//		List<String> _empty = appSearch.getApplications("");
//		
//		
//		System.out.println(Face);
//		System.out.println(ace);
//		System.out.println(Facebook);
//		System.out.println(f);
//		System.out.println(Hdfc);
//		System.out.println(Bank);
//		System.out.println(Loan);
//		
//		System.out.println("--------");
//		System.out.println(empty);
//		System.out.println(_null);
//		System.out.println(_empty);
//		
		
		
	}
}
