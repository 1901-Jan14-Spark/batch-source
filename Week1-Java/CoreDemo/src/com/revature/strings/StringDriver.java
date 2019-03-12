package com.revature.strings;

public class StringDriver {

	public static void main(String[] args) {
		
		String s1 = "I'm a String!";
		String s2 = "I'm a String!";
		
		// we expect this to be true as they have the same value 
		System.out.println("Equality as per equals: "+s1.equals(s2));
		
		// because s1 and s2 point to the same place in the string pool
		// this is also true, which would not be the case with other objects
		System.out.println("Equality as per == : "+ (s1 == s2));
		System.out.println("String1 hashcode: "+s1.hashCode());
		System.out.println("String1 hashcode: "+s2.hashCode());
		
		// now we can create a string using the new keyword, which we know 
		// stores our String outside of the string pool
		String s3 = new String("I'm a String!");
		System.out.println();
		System.out.println("For a String created with a constructor:");
		System.out.println("Equality as per equals: "+s1.equals(s3));
		System.out.println("Equality as per == :" + (s1 == s3));
		
		System.out.println();
		System.out.println("Change s3's reference to within the string pool:");
		s3 = s3.intern();
		System.out.println("Equality as per equals: "+s1.equals(s3));
		System.out.println("Equality as per == : " + (s1 == s3));

		
		System.out.println();
		System.out.println("Modified one of our original strings");
		s2 = s2 + "!!!";
		System.out.println("Equality as per equals: "+s1.equals(s2));
		System.out.println("Equality as per == : "+ (s1 == s2));
		System.out.println("String1 hashcode: "+s1.hashCode());
		System.out.println("String1 hashcode: "+s2.hashCode());
		
		System.out.println();
		System.out.println("Working now with StringBuilders");
		StringBuilder sb1 = new StringBuilder("I'm a StringBuilder object!");
		StringBuilder sb2 = new StringBuilder("I'm a StringBuilder object!");
		System.out.println("StringBuilder 1 hascode: "+ sb1.hashCode());
		System.out.println("StringBuilder 2 hascode: "+ sb2.hashCode());
		System.out.println("Are StringBuilders equal? "+sb1.equals(sb2));
		System.out.println("Are their corresponding string values equal? (equals)"+sb1.toString().equals(sb2.toString()));
		
		// the StringBuilder's toString implementation uses the new keyword so these Strings are in the heap, outside the string pool
		System.out.println("Are their corresponding string values equal? (==)"+(sb1.toString()==sb2.toString()));
		System.out.println("Using intern on these strings to reference the string pool: "+(sb1.toString().intern()==sb2.toString().intern()));
		System.out.println("Hashcodes of Strings?");
		System.out.println("StringBuilder1.toString().hashCode(): "+sb1.toString().hashCode());
		System.out.println("StringBuilder2.toString().hashCode(): "+sb2.toString().hashCode());

		
		System.out.println();
		sb1.append("!!!");
		System.out.println("HashCodes after manipulating StringBuilder 1");
		System.out.println("StringBuilder 1 hascode: "+ sb1.hashCode());
		System.out.println("StringBuilder 2 hascode: "+ sb2.hashCode());
		System.out.println("Equality as per String value equals method "+sb1.toString().equals(sb2.toString()));
		
		
	}

}
