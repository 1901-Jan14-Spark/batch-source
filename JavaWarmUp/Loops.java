public class Loops {
	public static void main(String [] args) {
			
		System.out.println("hello world");
		int x = 7;
		if (x > 10) {
			System.out.println("x is greater than 10.");
		} 
			else {System.out.println("x is equal to or less than 10.");
			}

		// For Loop
        for(int i= 0; i<4; i++){
            System.out.println("greetings");
        }
		// While Loop
		int n = 0;
        while(n < 4){
			System.out.println("greetings");
            n++;
        }

		//do while loop
		int f = 0;
		do {
			System.out.println("greetings");
			f++;
			} while (f < 4);


		String color = "orange";
		//switch statement
		switch (color){
			case "green": System.out.println("yellow + blue");
			break;
			case "orange": System.out.println("red + yellow");
			break;
			case "purple": System.out.println("red + blue");
			break;
			default: System.out.println("color unknown");
		}
	}
}   
		

