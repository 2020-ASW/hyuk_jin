package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main_1766_문제집 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		List<PriorityQueue<Integer>> list = new ArrayList<>();
		
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int[] count = new int[N + 1];
		
		for(int i = 1; i <= N + 1; i++) {
			list.add(new PriorityQueue<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			}));
		}
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			
			list.get(st).add(ed);
			count[ed]++;
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		for(int i = 1; i <= N; i++) {
			if(count[i] == 0) {
				queue.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			sb.append(temp + " ");
			for(int cur : list.get(temp)) {
				
				if(count[cur] - 1 == 0) {
					count[cur]--;
					queue.add(cur);
					
					continue;
				}
				
				count[cur]--;
			}
		}
		System.out.println(sb.toString());
	}
}
