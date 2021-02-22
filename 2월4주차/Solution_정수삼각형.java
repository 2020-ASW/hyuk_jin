package Algo_Study_Programmers;

public class Solution_정수삼각형 {
	static int[][] sumArr;
	private static int dfs(int r, int c, int[][] triangle) {
	
		if( r >= triangle.length) {
			return 0;
		}
		
		if(sumArr[r][c] > 0) {
			return sumArr[r][c];
		}
		
		sumArr[r][c] = triangle[r][c] + Math.max(dfs(r+1,c, triangle), dfs(r+1,c+1, triangle));

		return sumArr[r][c];
	}
    public static int solution(int[][] triangle) {
        int answer = 0;
        sumArr = new int[triangle.length][triangle.length];
        answer = dfs(0, 0, triangle);
        return answer;
    }
	public static void main(String[] args) {
		int[][] triangle = new int[][] {{ 7 }, 
										{ 3,8 },
										{ 8,1,0 },
										{ 2,7,4,4 },
										{ 4,5,2,6,5 }};
		System.out.println(solution(triangle));
	}
}
