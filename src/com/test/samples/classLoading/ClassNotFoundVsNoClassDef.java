package com.test.samples.classLoading;

public class ClassNotFoundVsNoClassDef {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Valid v = (Valid) Class.forName("com.test.samples.classLoading.Valid").newInstance();
		System.out.println(v);
		
//		Class.forName("com.jerin.Invalid");
		
	
		
//		ToDeleteFromBin noCD = (ToDeleteFromBin) Class.forName("com.test.samples.classLoading.ToDeleteFromBin").newInstance();
//		System.out.println(noCD);
//	
//		
		ToDeleteFromBin td = new ToDeleteFromBin();
		
		 
	}
}

class Valid
{
}

class ToDeleteFromBin{
	
}



