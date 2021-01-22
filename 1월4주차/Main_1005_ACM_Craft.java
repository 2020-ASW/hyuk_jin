package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1005_ACM_Craft {
	static List<List<Integer>> list;

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = stoi(br.readLine());

		for (int tc = 0; tc < TC; tc++) {

			StringTokenizer str = new StringTokenizer(br.readLine());

			int N = stoi(str.nextToken());
			int K = stoi(str.nextToken());

			int[] times = new int[N + 1];
			int[] count = new int[N + 1];
			
			int[] result = new int[N + 1];
			boolean[] visit = new boolean[N + 1];
			
			list = new LinkedList<>();
			str = new StringTokenizer(br.readLine());

			for(int i = 0; i <= N; i++) {
				list.add(new LinkedList<Integer>());	
			}
			
			for (int i = 1; i <= N; i++) {

				int time = stoi(str.nextToken());
				times[i] = time;
			}

			for (int i = 0; i < K; i++) {

				str = new StringTokenizer(br.readLine());

				int X = stoi(str.nextToken());
				int Y = stoi(str.nextToken());

				list.get(X).add(Y);
				count[Y]++;
			}

			int target = stoi(br.readLine());

			Queue<Integer> queue = new LinkedList<>();

			for(int i = 1; i <= N; i++) {
				if(count[i] == 0) {
					result[i] = times[i];
					queue.add(i);
					visit[i] = true;
				}
			}

			while (!queue.isEmpty()) {
				int tmp = queue.poll();

				for (int cur : list.get(tmp)) {
					
					count[cur]--;
					
					result[cur] = Math.max(result[cur], result[tmp] + times[cur]);
					if(count[cur] == 0) {
						queue.add(cur);						
					}
				}
			}
			System.out.println(result[target]);
		}
	}
}
