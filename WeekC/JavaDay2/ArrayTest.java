import java.util.Arrays;

public class ArrayTest{
    // data structure of a fixed size
    // can hold primitives or objects (but only of the type declared)

    public static void main(String[] args){

        int[] intArr1 = new int[5];

        // for(int i = 0; i<intArr1.length; i++){
        //     System.out.println(intArr1[i]);
        // }

        // can use a dynamic for loop, similar to our for/of loop
        for(int i : intArr1){
            System.out.println(i);
        }

        String[] strArr = new String[3];
        strArr[1] = "green";
        strArr[2] ="blue";

        for(String str: strArr){
            System.out.print(str+ " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(strArr));

    }

}