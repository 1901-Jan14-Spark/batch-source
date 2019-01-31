public class Helper{

    public static void main(String[] args){
         Helper helper= new Helper();
        //  helper.printNums();
		//  helper.printUpToValue(5);
		//  helper.printRange(50, 55);
		//  helper.printString("Hello", 5);
printNums();
printUpToValue(5);
printRange(50, 55);
printString("Hello", 5);
    }

private  static void  printNums() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		
	}
    int x=0;
private  static void printUpToValue(int x) {
		for(int i=0;i<=x;i++) {
			System.out.println(i);
		}
		
	}
	private static void printRange(int y, int z) {
		for(int i=y;i<=z;i++) {
			System.out.println(i);
		}
	}
		private static void printString(String Hello, int a) {
			String Hellos="";
			for(int i=0;i<a;i++) {

				 Hellos=Hellos.concat(Hello);
			}
		System.out.println(Hellos);
	}



		}











