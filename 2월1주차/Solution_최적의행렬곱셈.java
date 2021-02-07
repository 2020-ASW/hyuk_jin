package Algo_Study_Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_최적의행렬곱셈 {
	
    public static int solution(int[][] matrix_sizes) {
		
		int N = matrix_sizes.length;
		
		int[] arr = new int[N + 1];
		int[][] minMap = new int[N + 1][N + 1];
		
		for(int i = 0; i < N; i++) {
			int[] temp = matrix_sizes[i];
			
			arr[i] = temp[0];
			arr[i + 1] = temp[1];
		}
		
		for(int l = 2; l <= N; l++) {
			
			for(int i = 1; i <= N - l + 1; i++) {
				
				int j = i + l - 1;
				minMap[i][j] = Integer.MAX_VALUE;
				
				for(int k = i; k < j; k++) {
					int cal = minMap[i][k] + minMap[k + 1][j] + arr[i-1] * arr[k] * arr[j];
					minMap[i][j] = Math.min(minMap[i][j], cal);
				}
			}
		}
		return minMap[1][N];
    }
	public static void main(String[] args) {
		
		int[][] matrix_sizes = new int[][] {{ 5, 3}, {3,10}, {10,6}};
		System.out.println(solution(matrix_sizes));
	}
}
