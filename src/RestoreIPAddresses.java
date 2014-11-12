import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lunwang on 9/30/2014.
 */
public class RestoreIPAddresses {

    List<String> result = new ArrayList<String>();

    public boolean ifValid(int n){
        if(n>=0&&n<=255) return true;
        else return false;
    }

    public List<String> restoreIpAddresses(String s) {
        buildString(0,s,"",1);
        return result;
    }

    public void buildString(int begin, String s, String output, int steps){
        int l = s.length();
        for(int i=begin+1;i<l&&i<=begin+3;i++){
            String sub = s.substring(begin,i);
            if(ifValid(Integer.parseInt(sub))){
                if(steps==4&&i!=l){
                    continue;
                }
                String newString = output + (begin == 0? sub : "."+sub);
                if(steps==4&&i==l) result.add(newString);
                else buildString(i,s,newString,steps+1);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RestoreIPAddresses test = new RestoreIPAddresses();
        String s = "0000";
        List<String> list = test.restoreIpAddresses(s);
        for (String str : list){
            System.out.println(str);
        }
    }


}
