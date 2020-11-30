import java.util.Arrays;

public class poker {

    /**
      https://blog.csdn.net/zhanxufeng/article/details/83025397

     */

    public static int answer1(int[] cards){
        int[] cnt = new int[25];
        int res = 0;
        for (int i = 0; i < cards.length; i++) {
            cnt[cards[i]]++;
        }
        helper(0,cards,cnt);
        return ans;
    }
    private static int ans=0;

    private static int[] cards1 = new int[14];

    public static void helper(int res,int[] cards,int[] cnt){
        for (int i=2;i<=9;i++){
            int pos=i;
            while (cards[pos]>=1) pos++;
            if (pos-i>=5){
                for (int j=i+4;j<=pos-1;j++){
                    saveCards(cards);
                   int save = res;
                    for (int k=j-4;k <= j;k++) cards[k]-=1;//出单顺,更新牌数.
                    res+=6;
                    helper(res,cards,cnt);

                    CountCard(cards,cnt);
                    while (cnt[4] > 0) { res += 5; cnt[4]--; }
                    while (cnt[3] > 0) { res += 4; cnt[3]--; }
                    while (cnt[2] > 0) { res += 2; cnt[2]--; }
                    if (cards[0]>0 && cards[1]>0) {res +=6;cards[0]--;cards[1]--;}
                    if (cards[0]>0){res +=3;cards[0]--;}
                    if (cards[1]>0){res +=3;cards[1]--;}
                    ans=Math.max(res,ans);
                    coverCards(cards);
                   res = save;
               }
            }
        }

    }

    public static void CountCard(int[] cards,int[] cnt){
        Arrays.fill(cnt,0);
        for (int i = 0; i < cards.length; i++) {
                cnt[cards[i]]++;
        }
    }



    public static void saveCards(int[] cards){
        for (int i = 0; i < cards.length; i++) {
            cards1[i]=cards[i];
        }
    }
    public static void coverCards(int[] cards){
        for (int i = 0; i < cards.length; i++) {
            cards[i]=cards1[i];
        }
    }



    public static void main(String[] args) {
        int[] cards = new int[]{0,0,1,2,2,2,2,1,0,0,0,0,0,0};
        System.out.println(answer1(cards));

    }


}
