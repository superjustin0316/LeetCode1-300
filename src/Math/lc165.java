package Math;

public class lc165 {

    /**
     * v1 > v2 ->  1
     * v1 < v2 -> -1
     * v1 = v2 ->  0
     */
    public int lc165(String version1, String version2){
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length,v2.length);i++){
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 < num2){
                return -1;
            }else if (num1 > num2){
                return 1;
            }
        }
        return 0;
    }
}
