package BinarySearch;

public class mathlc367 {
    //O(n) O(1)
    public boolean lc367(int num){
        if (num < 0) return false;
        if (num == 1) return true;
        for (int i = 1 ; i*i <= num;i++){
            if ( i * i == num) return true;
        }
        return false;
    }

    //O(log n) O(1)
    public boolean solu2(int num){
        int low = 1;
        int high = num;
        while(low <= high){
            long mid = (high + low)/2;//long
            if (mid *mid == num){
                return true;
            } else if (mid * mid < num){
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    //O(n) O(1)
    public boolean solu3(int num){
        int i = 1;
        while (num>0){
            num = num -1;
            i=i+2;
        }
        return num==0;
    }

    //O(?) O(1)
    public boolean solu4(int num){
        long x= num;
        while (x*x > num){
            x =(x+num/x)/2;
        }
        return x * x == num;
    }

}
