package ladder4;

public class longestIncreasingSubsequence {
	 public int longestIncreasingSubsequence(int[] nums) {
	        // write your code here
	        if (nums == null || nums.length == 0 ){
	            return 0;
	        }
	        int len = nums.length;
	        if (len == 1) {
	            return 1;
	        }
	        int[] count = new int[len] ;
	        count[0] = 1 ;
	        for (int i = 1; i < len; i++){
	            count[i] = 1;
	            for(int j = 0 ; j < i ; j++){
	                if (count[j] + 1 > count[i] && nums[i] >= nums[j]){
	                    count[i]  = count[j] + 1;
	                }
	            }
	            
	        }
	        return count[len - 1] ;
	    }
	 public static void main(String[] args){
		 longestIncreasingSubsequence  a = new  longestIncreasingSubsequence();
		 int[] nums={88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59};
		 int result = a.longestIncreasingSubsequence(nums);
		 System.out.print(result);
	 }
}
