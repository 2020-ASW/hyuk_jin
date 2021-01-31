package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1322_X와K {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		long N = Long.parseLong(str.nextToken());
		long K = Long.parseLong(str.nextToken());
		
		long[] arr = new long[65];
		
		int cnt = 0;
		while(N > 0) {
			if(N % 2 == 0) {
				arr[cnt] = 0;
			}
			else {
				arr[cnt] = 1;
			}
			
			N = N / 2;
		}
		long answer = 0;
		int Y = 1;
		for(int i = 0; i < 65 && K > 0; i++, Y *= 2) {
			if(arr[i] == 0) {
				if(K % 2 == 1) {
					answer += Y;					
				}
				K /= 2;
			}
		}
		System.out.println(answer);
	}
}
