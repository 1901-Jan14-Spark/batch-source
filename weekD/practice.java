// Efficiency: O(n)
public class practice {
  public static int fibonacci(int n){
    int counter = 0;
    int current = 1;
    int previous = 0;
    int temp = 0;

    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }

    while(counter < n - 1){
      temp = previous + current;
      previous = current;
      current = temp;
      counter++;
    }

    return current;
  }

// O(n)
  public static int gcf(int n1, int n2){
    int maximum = Math.max(n1, n2);
    int minimum = Math.min(n1, n2);
    int remainder = 0;

    if(maximum == 0){
      return 0;
    }

    while(minimum != 0){
      remainder = maximum % minimum;
      maximum = minimum;
      minimum = remainder;
    }

    return maximum;
  }


// O(n)
  public static int convertToBinary(int input){
    int temp1 = input;
    String str = "";

    while(temp1 > 0){
      if(temp1 % 2 == 0){
        str = "0" + str;
      }else{
        str = "1" + str;
      }

      temp1 /= 2;
    }

    return Integer.parseInt(str);

  }

  public static void main(String[] args){
    System.out.println(fibonacci(8));
    System.out.println(gcf(190, 285));
    System.out.println(convertToBinary(12));
  }
}
