public class Helper{
    public static void main(String[] args){
        printUpToVal(4);    
        printNums();
        printRange(4,15);
        printString("Cat", 6);
    }
    public static void printNums(){            
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        for(int i : arr1)
            System.out.println(i);
    }
    public static void printUpToVal(int max){
        for(int i = 1; i<max ; i++)
            System.out.println(i);
    }
    public static void printRange(int low, int high){
        for(int i = low ; i<=high; i++)
            System.out.println(i);
    }
    public static void printString(String Cat, int Dog){
    int counter = 0;
    do{System.out.print(Cat);
        counter++;}
    while(counter<Dog);
    
    }
}



