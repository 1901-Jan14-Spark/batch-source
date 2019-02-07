public class mergeSort {

  public static int[] sort(int[] input){
    int length = input.length;

    if(length <= 1){
      return input;
    }

    int[] left = new int[length/2];
    int[] right = new int[length - length/2];

    for (int i = 0; i < left.length; i++){
        left[i] = input[i];
    }
    for (int i = 0; i < right.length; i++){
        right[i] = input[i + length/2];
    }

    return merge(sort(left), sort(right));
  }

  private static int[] merge(int[] left, int[] right){
    int[] result = new int[left.length + right.length];
    int i = 0, j = 0;

    for(int k = 0; k < result.length; k++){
        if(i >= left.length){
          result[k] = right[j++];
        } else if(j >= right.length){
          result[k] = left[i++];
        } else if(left[i] <= right[j]){
          result[k] = left[i++];
        } else{
          result[k] = right[j++];
        }
    }

    return result;
  }

  public static void main(String[] args){
    int[] arr = new int[]{7, 3, 2, 6, 8, 5, 1, 4, 9};
    arr = sort(arr);
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
}
