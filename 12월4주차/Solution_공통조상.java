package Algo_Study_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_공통조상 {
	static List<List<Integer>> list;
	static int[] depth, parent;
	static int size;

	private static void size_cnt(int node) {

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(node);
		size++;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (list.get(cur).size() == 0) {
				continue;
			}
			for (int child : list.get(cur)) {
				if (depth[child] >= depth[cur]) {
					queue.add(child);
					size++;
				}
			}
		}
	}

	private static int solution(int A, int B) {

		while (depth[A] > depth[B]) {
			A = parent[A];
		}
		while (depth[A] < depth[B]) {
			B = parent[B];
		}
		while (A != B) {
			A = parent[A];
			B = parent[B];
		}

		return A;
	}

	private static void dfs(int node, int cnt) {
		depth[node] = cnt;

		for (int child : list.get(node)) {
			if (depth[child] == 0) {
				dfs(child, cnt + 1);
				parent[child] = node;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			size = 0;
			int V = Integer.parseInt(str.nextToken());
			int E = Integer.parseInt(str.nextToken());

			int A = Integer.parseInt(str.nextToken());
			int B = Integer.parseInt(str.nextToken());

			list = new ArrayList<>();

			for (int i = 0; i <= V; i++) {
				list.add(new ArrayList<Integer>());
			}

			StringTokenizer input = new StringTokenizer(br.readLine());

			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(input.nextToken());
				int b = Integer.parseInt(input.nextToken());

				list.get(a).add(b);
				list.get(b).add(a);
			}

			depth = new int[V + 1];
			parent = new int[V + 1];

			dfs(1, 1);
			int result = solution(A, B);
			size_cnt(result);
			System.out.println("#" + tc + " " + solution(A, B) + " " + size);
		}
	}
}
