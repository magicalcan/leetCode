import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class WordBreakII {

	ArrayList<Stack<Integer>> map = new ArrayList<Stack<Integer>>();
	
	public WordBreakII(){
		
	}
	
	public void initMap(int n){
		for (int i=0; i < n; i++){
			map.add(new Stack<Integer>());
		}
	}
	
	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        initMap(s.length());
        for(int i=s.length(); i>0; i--){
        	if(i < s.length()&&map.get(i).isEmpty()) 
        		continue;  //if the current index was not recorded by first iteration, means this break is not valid through the end.
        	for (int j=i-1; j>=0; j--){
            	String sub = s.substring(j, i);        	
            	if(dict.contains(sub)){
            		map.get(j).push(i);
        	    }
        	}
        }
        buildString(0, s, "", result);
        return result;
    }
   
    public void buildString(int begin, String s, String output, List<String> result){
    	Stack<Integer> st = map.get(begin);
        for (int i : st){
        	String sub = s.substring(begin, i);
        	String newPath = output + (begin==0? sub : " "+sub);
        	if(i == s.length()) result.add(newPath);
        	else buildString(i, s, newPath, result);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakII wb = new WordBreakII();
		String s = "catsanddog";
		Set<String>	dict = new HashSet<String>();
		String[] strs = {"cat", "cats", "and", "sand", "dog"};
        for (String str : strs){
        	dict.add(str);
        }
        List<String> list = wb.wordBreak(s, dict);
        for (String str : list){
        	System.out.println(str);
        }
	}
}
