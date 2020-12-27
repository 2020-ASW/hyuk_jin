package Algo_Study_SWEA;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution_상원이의생일파티 {
	static List<List<Integer>> list;
	static boolean[] check;
	private static int solve(int num , int cnt) {
		
		Queue<Point> queue = new LinkedList<Point>();
		int answer = 0;
		check[num] = true;
		queue.add(new Point(num , cnt));
		
		while(!queue.isEmpty()) {
			
			Point cur = queue.poll();
			
			if(cur.y == 2) {
				continue;
			}
			for(int friend : list.get(cur.x)) {
				if(!check[friend]) {
					answer++;
					check[friend] = true;
					queue.add(new Point(friend, cur.y + 1));
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			check = new boolean[N];
			list = new ArrayList<>();
			
			for(int i = 0; i <= N + 1; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.get(a).add(b);
				list.get(b).add(a);
			}
			System.out.println(solve(1, 0));
		}
	}
}
