package demo;

/**
 * @author：hanzhigang
 * @Date : 2020/6/19 2:02 PM
 */
public class demo1 {



    private static void bubbleSort(int[] arr) {
        if(arr==null || arr.length < 2 ){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {2,5,1,3,8,5,7,4,3};
//        bubbleSort(arr);
//
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
        System.out.println(99/100);
    }

}
