package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1027_고층건물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] height = new int[N];
		int[] count = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(str.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			
			double cur = -1e9 - 1; 
			for(int j = i + 1; j < N; j++) {
				
				double view = 1.0 * (height[j] - height[i]) / (j - i);
				if(view > cur) {
					cur = view;
					count[i]++;
					count[j]++;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer = (count[i] > answer) ? count[i] : answer;
		}
		System.out.println(answer);
	}
}
