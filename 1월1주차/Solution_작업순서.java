package Algo_Study_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution_작업순서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 1; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(str.nextToken());
			int E = Integer.parseInt(str.nextToken());
			
			int[] nums = new int[V + 1];
			boolean[] check = new boolean[V + 1];
			StringBuilder sb = new StringBuilder();
			
			List<List<Integer>> list = new LinkedList<>();
			
			for (int i = 0; i <= V; i++) {
				list.add(new LinkedList<Integer>());
			}
			
			str = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < E; i++) {
				int st = Integer.parseInt(str.nextToken());
				int ed = Integer.parseInt(str.nextToken());
				
				list.get(st).add(ed);
				nums[ed]++;
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for(int i = 1; i <= V; i++) {
				if(nums[i] == 0) {
					queue.add(i);
				}
			}
			while(!queue.isEmpty()) {
			
				int cur = queue.poll();
				
				sb.append(cur + " ");
				
				for(int i = 0; i < list.get(cur).size(); i++) {
					if(nums[list.get(cur).get(i)] - 1 == 0) {
						queue.add(list.get(cur).get(i));
					}
					else {
						nums[list.get(cur).get(i)]--;
					}
				}
			}
			System.out.println("#" + tc + " " + sb);
		}
	}
}
