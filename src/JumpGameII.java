/**
 * Created by lunwang on 10/27/2014.
 */
public class JumpGameII {
    public int jump(int[] A) {
        int steps = 0;  //result
        int old = 0;    //how far can we reach already
        int cur = 0;    //how far can we reach with next step
        for(int i=0; i<A.length; i++){
            if(i>old){
                if(cur == old && i<A.length-1){
                    return -1;                     //impossible to reach the end
                }
                old = cur;
                steps++;
            }
            int temp = i + A[i];
            cur = cur>temp? cur : temp;
        }
        return steps;
    }
}
