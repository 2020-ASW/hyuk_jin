package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] liquid = new long[N];
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(str.nextToken());
		}
		
		Arrays.sort(liquid);
		long[] answer = new long[3];
		long minSum = Long.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int left = i + 1;
			int right = N - 1;
			
			while(left < right) {
				long sum = liquid[i] + liquid[left] + liquid[right];
				
				if(Math.abs(sum) < minSum) {
					minSum = Math.abs(sum);
					answer[0] = liquid[i];
					answer[1] = liquid[left];
					answer[2] = liquid[right];
				}
				
				if(sum < 0) {
					left++;
				}
				else if(sum > 0) {
					right--;
				}
				else {
					i = N;
					break;
				}
			}
		}
		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}
}
