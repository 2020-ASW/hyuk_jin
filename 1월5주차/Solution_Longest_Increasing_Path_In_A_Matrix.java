package Algo_Study_LeetCode;

public class Solution_Longest_Increasing_Path_In_A_Matrix {
	
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] {  0, 0, -1, 1};
	static int row, col;
	static int[][] dp;
	
	private static int dfs(int r, int c, int[][] matrix) {
		
		if(dp[r][c] != 0) {
			return dp[r][c];
		}
		int answer = 0;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr >= 0 && nr < row && nc >= 0 && nc < col && matrix[nr][nc] > matrix[r][c]) {
				answer = Math.max(answer, dfs(nr,nc,matrix));
			}
		}
		dp[r][c] = answer + 1;
		
		return dp[r][c];
	}
    public static int longestIncreasingPath(int[][] matrix) {
    	
    	int answer = 0;
    	row = matrix.length;
    	col = matrix[0].length;
    	
    	if(row == 0) {
    		return 0;
    	}
    	
    	dp = new int[row][col];
    	
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			answer = Math.max(answer, dfs(i,j, matrix));
    		}
    	}
    	
    	return answer;
    }
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{ 9,9,4 }, { 6,6,8 }, { 2,1,1 }};
		longestIncreasingPath(matrix);
	}
}
