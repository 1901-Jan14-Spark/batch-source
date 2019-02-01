//part 2
// 1
public class Helper{
    public String realName; //public instance variable
    public String nickName;//instance variable
    public int age; //instance variable       
       
      
 // 2  
 public static void main(String[] args){
    printNums();
    int x=6;
    printUpToVal(x);
    int c=2;
    int k=3;
    int n=5;
    int y=7;
    printRange( c,  k) ;
    printString( n, happy);
 
 } 
 static void printNums() {
    
    for(int i=0; i<=10; i++)
    {
        System.out.println(i);
    }
    
        }     

           
      
// 3
public static void  printUpToVal(int x) 
{
    for( int y=1; y <= x; y++)
    {
        System.out.println(y);
    }
    
 }

// 4
public static void  printRange(int c, int k) 
{
    for( int i=c; i <= k; i++)
    {
        System.out.println(i);
    }
    
    
 }

// 5
 public static void  printString(int n, String[] happy) 
 {
     for( int i = 0; i <= n; i++)
     {
     happy += happy;
     }
     
     System.out.println(n);
  }




}

 
 
 
 
 