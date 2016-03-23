package ladder4;

public class uniquepaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// write your code here
		if (obstacleGrid == null || obstacleGrid.length == 0
				|| obstacleGrid[0].length == 0) {
			return 0;
		}
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] path = new int[m][n];
		// initialize
		path[0][0] = 1;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			} else {
				path[i][0] = 1;
			}
		}
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				break;
			} else {
				path[0][j] = 1;

			}
		}
		// forward
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					path[i][j] = 0;
				} else {
					path[i][j] = path[i - 1][j] + path[i][j - 1];

				}
			}
		}
		return path[m - 1][n - 1];

	}

	public static void main(String[] args) {
		uniquepaths2 a = new uniquepaths2();
		int[][] testarray = {{0,0},{0,0},{0,0},{1,0},{0,0}};
		int c= a.uniquePathsWithObstacles(testarray);
		System.out.print(c);
		
	}

}
