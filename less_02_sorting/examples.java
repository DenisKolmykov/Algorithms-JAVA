package less_02_sorting;


//import java.util.Date;

public class examples { 

    public static void Sort1(int[] arr){ // O(n^2) 
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            int Min = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[Min]){
                    Min = j;
                }
            }
            int temp = arr[Min];
            arr[Min] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] buff = new int[1000001];
    public static void Sort2(int[] arr){ // O(n log(n))
        Sort2(arr, 0, arr.length-1);
    }
    public static void Sort2(int[] arr, int left, int right){ // быстрая сортировка СЛИЯНИЕМ
        if(left == right){
            return;
        }
        int mid = (left + right) / 2;
        Sort2(arr, left, mid);
        Sort2(arr, mid+1, right);

        // 4 5 6 | 1 2 3

        int i = left, j = mid + 1, k = left;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                buff[k++] = arr[i++];
            }else{
                buff[k++] = arr[j++];
            }
        }

        while(i <= mid){
            buff[k++] = arr[i++];
        }

        while(j <= right){
            buff[k++] = arr[j++];
        }

        for(int q = left; q <= right; q++){
            arr[q] = buff[q];
        }
    }

    public static int BinarySearch(int[] arr, int value){
        int left = 0, right = arr.length - 1;
        while(right - left > 1){
            int mid = (left + right) / 2;
            if(arr[mid] < value){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(arr[left] == value)
            return left;
        if(arr[right] == value)
            return right;
        return -1;
    }
    public static void main(String[] args) {
        int n = 1000000;
        int[] arr1 = new int[n];
        //int[] arr2 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = (int)(Math.random() * 100);
            //System.out.printf("%d ", arr[i]);
            //arr2[i] = arr1[i];
        }
        //System.out.println();

//        Sort2(arr);
//
//        for(int i : arr){
//            System.out.printf("%d ", i);
//        }
//        System.out.println();

        //Date start = new Date();
//        Sort1(arr1);
        //Date end = new Date();
        //long time1 = end.getTime() - start.getTime();

        //start = new Date();
        Sort2(arr1);
        //end = new Date();
        //long time2 = end.getTime() - start.getTime();

        //System.out.printf("time1: %d, time2: %d%n", time1, time2);

        int pos = BinarySearch(arr1, 42);
        System.out.println(pos);
        System.out.println(arr1[pos-1]);
        System.out.println(arr1[pos]);
        System.out.println(arr1[pos+1]);
    }

}
