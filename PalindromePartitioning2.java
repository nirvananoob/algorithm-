package ladder4;

public class PalindromePartitioning2 {
	public int minCut(String s) {
        // write your code here
        if(s == null || s.length() ==1){
            return 0;
        }
        int len = s.length();
        int[] count = new int[len+1];
        count[0] = -1 ;
        count[1] = 0 ;
        for (int i = 2; i <len+1; i++){
            count[i] = Integer.MAX_VALUE;
            for (int j = 0 ; j < i; j++){
                if (count[j] ==  Integer.MAX_VALUE ){
                    continue;
                }
                if( count[j] + 1 < count[i] && isPalindrome(s.substring(j , i ))){
                    count[i] = count[j] + 1;
                }
            }
        }
        return count[len];
    }
    public boolean isPalindrome(String s) {
        
        if (s == null || s.length() == 1){
            return true;
        }
        int len = s.length() ;
        int start = 0;
        int end = len - 1;
        boolean isPalindrome = true;
        while(start <= end ){
            if (s.charAt(start) != s.charAt(end)){
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        return isPalindrome;
    }
    public static void main(String[] args){
    	String a = "ab";
    	PalindromePartitioning2 test = new PalindromePartitioning2();
    	boolean result = test.isPalindrome(a.substring(0,2));
    	System.out.print(result);
    }
}
