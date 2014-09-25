import java.util.ArrayList;
import java.util.List;

/**
 * Created by lunwang on 9/24/2014.
 */
public class TextJustification {
    int last = 0;
    public List<String> fullJustify(String[] words, int L) {
        if(words==null) return null;
        List<String> l = new ArrayList<String>();
        while(last<words.length){
            l.add(buildLine(words,last,L));
        }
        return l;
    }

    public String buildLine(String[] w, int start, int L){
        int i = start;
        StringBuilder line = new StringBuilder(w[i]);
        i++;
        int l = line.length();
        while(i<w.length && (l+1+w[i].length())<=L){
            l = l+1+w[i].length();
            i++;
        }
        int n = L-l;  //number of extra spaces at the end
        int avg = (i-start-1)>0? n/(i-start-1):0;    //number of extra spaces per slot
        int mod = (i-start-1)>0? n%(i-start-1):0;
        for(int m=start+1; m<i; m++){
            if(i<w.length) {   //if not the end of text
                for(int j=0; j<avg; j++){   //determine whether more than one space will be placed in this slot
                    line.append(" ");
                    n -= 1;
                }
                if(mod>0){      //determine whether extra space will be placed here
                    line.append(" ");
                    n -= 1;
                    mod -= 1;
                }
            }
            line.append(" " + w[m]);
        }
        while(n>0){
            line.append(" ");
            n--;
        }
        last = i;
        return line.toString();
    }

    public static void main(String[] args) {
        TextJustification tester = new TextJustification();
        String[] w = {"Here","is","an","example","of","text","justification."};
        int l = 16;
        List<String> result = tester.fullJustify(w,l);
        for (String s : result){
            System.out.println("line: "+s+"***");
        }
    }
}