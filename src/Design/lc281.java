package Design;

import java.util.Iterator;
import java.util.List;

public class lc281 {
    private Iterator<Integer> i,j,temp;//依次遍历

    public void lc146(List<Integer> v1, List<Integer> v2){
        i = v1.iterator();
        j = v2.iterator();
    }

    public int next(){
        if (j.hasNext()){
            temp = i;
            i = j ;
            j = temp;
        }
        return i.next();
    }

    public  boolean hasNext(){
        return i.hasNext()|| j.hasNext();
    }
}
