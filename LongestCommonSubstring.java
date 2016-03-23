package ladder5;

public class LongestCommonSubstring {
	public int longestCommonSubstring(String A, String B) {
        // write your code here
         if (A == null || B == null || A.length() == 0  || B.length() == 0 ){
            return 0 ;
        }
         int m = A.length () ;
        int n = B.length () ;
        if (m == 1 || n == 1){
            if (m >= n ){
                if (A.contains(B)){
                    return 1 ;
                }
            
            }
            else{
                if (B.contains(A)){
                    return 1;
                }
            }
            return 0   ;  
        }
        int[][] result = new int[m+1][n+1] ;
        
      for (int i = 1 ; i < m + 1; i++ ){
          for (int j = 1 ; j < n + 1 ; j++){
              if (A.charAt(i-1) == B.charAt(j-1)){
                  if (A.charAt(i-2) == B.charAt(j-2)){
                  result[i][j] = result[i-1][j-1] + 1;
                      
                  }else{
                      result[i][j] = Math.max(result[i-1][j-1] , 1);
                  }
              }else{
                  result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
              }
          
      }
      
    }
    return result[m][n] ;
    }
	public static void main(String[] args){
		LongestCommonSubstring test  = new LongestCommonSubstring() ;
		String a = "ab";
		String b = "a" ;
		boolean[][] res = new boolean[1][1];
		int finalres = test.longestCommonSubstring(a, b);
		System.out.print(finalres);
		System.out.print(123);
		System.out.print(res[0][0]);
		System.out.print(a.substring(0,1));
	}
}
