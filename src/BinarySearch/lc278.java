package BinarySearch;

public class lc278 {

    public int lc278(int n){
        int start = 1;
        int end = n;

        while( start <= end){//①
            int mid = (start + end) / 2;
            if (isBadVersion((mid))){
                end = mid - 1 ;//②
            } else {
                start = mid + 1 ;//③
            }
        }
        return start - 1;//④
    }




    public boolean isBadVersion(int mid){
        return true;
    }
}
