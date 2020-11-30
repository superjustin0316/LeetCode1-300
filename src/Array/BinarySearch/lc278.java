package Array.BinarySearch;

public class   lc278 {

    //longn 1
    public int solution(int n){//计数的数组, 开始:1, 结束:n
        int left = 1;
        int right = n;

        while (left <= right){
            int mid = (left + right) / 2;
            if (isBadVersion(mid)){
                right = mid -1;
            }else {
                left = mid +1;

            }
        }// 当 left > right 的时候，结束while
        return left;


    }

    public boolean isBadVersion(int n){
        return true;
    }

}
