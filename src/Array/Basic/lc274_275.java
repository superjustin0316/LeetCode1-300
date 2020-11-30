package Array.Basic;

import java.util.Arrays;

public class lc274_275 {

    public int lc274(int[] citations){
        Arrays.sort(citations);
        int res =0;
        while (res < citations.length && citations[citations.length -1- res] > res){
            res ++;
        }
        return res;
    }

    public int lc275(int[] citations){
        int len = citations.length;
        int start = 0, end = len -1;
        while (start <= end){
            int mid = (end -start)/2+start;
            if (citations[mid] == len - mid){
                return len - mid;
            } else if (citations[mid] < len - mid){
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        return len - start;
    }
}
