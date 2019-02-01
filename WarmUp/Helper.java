public class Helper{

    // Question 1
    Helper(){

    }

    public static void main(String[] args){

        Helper obj = new Helper();


        printNums();
        System.out.println();
        printUpToVal(14);
        System.out.println();
        printRange(3, 11);
        System.out.println();
        System.out.println(printString("Word", 6));
       

    }


    // Question 2
    public static void printNums(){
        int i = 0;
        while(i < 10){
            i++;
            System.out.println(i);
        }
        // return 10;
    } 

    // Question 3
    public static void printUpToVal(int x){
        int i = 0;
        do{
            i++;
            System.out.println(i);
        } while (i < x);
    }

    // Question 4
    public static void printRange(int x, int y){
        System.out.println(x);
        do{
            x++;
            System.out.println(x);
        } while (x < y);

    }

    // Question 5
    public static String printString(String word, int times){
        int d = 0;
        String word2 = "";
        do{
            d++;
            word2 += word + ". ";
        } while(d < times);
        return word2;
    }

}