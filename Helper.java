public class Helper{
    private int y;
    private int r;
    private int e;
    private String word;
    private int c;
    private String words;
    static void printNums(){
        int x = 1;
        for(x = 1; x<11; x++){
            System.out.println(x);
        }
    }

    static void printUpToVal(int y){
        int i =0;
        for(i=0; i<y;i++){
            System.out.println(i);
        }
    }

    static void printRange(int r, int e){
        int i = r;
        for(i = r ; i<= e; i++){
            System.out.println(i);
        }
    }

    static void printString(String word, int c){
            String place = word;
            String words = place;
            int i = 0;
            for(i=1; i<c; i++){
                words = words + place;
                
            }
            System.out.println(words);
    }


public static void main(String[] args){
            printNums();
            printUpToVal(7);
            printRange(3,7);
            printString("hi",8);
         }
    }



