package array;

import java.util.Arrays;

public class getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0;i < k;i++){
            res[i] = arr[i];
        }
        return res;
    }
}
