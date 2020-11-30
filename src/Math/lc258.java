package Math;

public class lc258 {

    //O(1) O(1)
    public int solu1(int num){
        int sum = 0;
        while (num != 0){
            sum = num % 10;
            num = num / 10;
        }
        if (sum > 10){
            return solu1(sum);
        }else {
            return sum;
        }

    }

    public int solu2(int num){
        return (num -1) %9;
    }
}
