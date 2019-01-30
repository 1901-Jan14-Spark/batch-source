public class Helper{
  Helper(){
  }

  public void printNums(){
    for(int i = 1; i < 11; i++){
      System.out.println(i);
    }
  }

  public static void printUpToVal(int x){
    for(int i = 1; i < x; i++){
      System.out.println(i);
    }
  }

  public static void printRange(int x, int y){
    for(int i = x; i < y; i++){
      System.out.println(i);
    }
  }

  public static void printString(String str, int x){
    String tempStr = "";
    for(int i = 0; i < x; i++){
      tempStr += str;
    }
    System.out.println(tempStr);
  }

  public static void main(String[] args){
    Helper h = new Helper();
    h.printNums();
    System.out.println("\n");
    Helper.printUpToVal(5);
    System.out.println("\n");
    Helper.printRange(5, 10);
    System.out.println("\n");
    Helper.printString("haha", 5);
  }


}
