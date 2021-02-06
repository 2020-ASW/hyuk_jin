package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_K진트리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int Q = Integer.parseInt(str.nextToken());
		
		for(int i = 0; i < Q; i++) {
			
			str = new StringTokenizer(br.readLine());
			
			long x = Long.parseLong(str.nextToken());
			long y = Long.parseLong(str.nextToken());
			
			if(K == 1) {
				System.out.println(Math.abs(x - y));
				continue;
			}
			
			int cnt = 0;
			
			while(x != y) {
				
				if(x > y) {
					x = ( x - 2 ) / K + 1;
				}
				else {
					y = ( y - 2) / K + 1;
				}
				cnt++;
			}
			System.out.println(cnt);
		}	
	}
}
