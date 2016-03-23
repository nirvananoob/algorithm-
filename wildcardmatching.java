package ladder5;

public class wildcardmatching {
	public boolean isMatch(String s, String p) {
        // write your code here
       
        if (s == null || p == null){
            return false ;
        }
        if (!p.contains("*") && p.length() != s.length()){
            return false;
        }
        int m = s.length() ;
        int n = p.length() ;
        boolean[][] res = new boolean[m + 1][n +1] ;
        res[0][0] = true ;
        
     for (int i = 1 ; i < m +1 ; i++){
         for (int j = 1 ; j < n +1 ; j ++){
             
             if (p.charAt(j -1) == '?' || p.charAt(j -1) == s.charAt(i -1)){
                 res[i][j]  = res[i-1][j-1] ;
             }
             if (p.charAt(j -1) == '*'){
                  
                     res[i][j] = res[i-1][j] || res[i][j-1] ||res[i-1][j-1]  ;
                 }
             }
         }
       return res[m][n]  ;
     }
	public static void main(String[] args){
		wildcardmatching test = new wildcardmatching();
		String s = "bbbba";
		String p = "?*a*a";
		
		boolean res = test.isMatch(s, p);
		s = ""+ s;
		System.out.print(res);
		System.out.print(s);
		
	}
}
