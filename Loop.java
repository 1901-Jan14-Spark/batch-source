
public class Loop {
public static void main(String[] args) {
	//1
	System.out.println("Hello World");
	//2
	int x=9;
	if (x>10) {
		System.out.println("x is greater than 10");
	}else {System.out.println("x is equal to or less than 10");
	}
	//3
	for (int i=0;i<4;i++) {
		System.out.println("greetings");
	}
	//4
	int j=0;
	while(j<4) {
		System.out.println("greetings");
		j++;
	}
	
	String color="red";
	 switch (color) {
	 case "orange":
		 System.out.println("Red and Yellow");
		 break;
	 case "green":
		 System.out.println("Blue and Yellow");
		 break;
	 case "purple":
		 System.out.println("Blue and Red");
		 break;
	default:
		System.out.println("Color Unkown");
	 
	 
	 
	 
	 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}

