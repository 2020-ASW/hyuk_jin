package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1153_네개의소수 {
	
	static boolean[] prime = new boolean[1000001];
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 2; i * i <= 1000000; i++) {
			for(int j = i * i; j <= 1000000; j += i) {
				prime[j] = true;
			}
		}
		
		List<Integer> list = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		 
		if(N < 8) {
			System.out.println("-1");
			return;
		}
		
		if(N % 2 == 0) {
			list.add(2);
			list.add(2);
			N = N - 4;
		}
		else {
			list.add(2);
			list.add(3);
			N = N - 5;
		}
		
		for(int i = 2; i <= N / 2; i++) {
			if(!prime[i] && !prime[N - i]) {
				list.add(i);
				list.add(N - i);
				break;
			}
		}
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
