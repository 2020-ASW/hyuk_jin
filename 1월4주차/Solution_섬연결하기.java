package Algo_Study_Programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Land implements Comparable<Land> {
	int r;
	int c;
	int cost;

	public Land(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}

	@Override
	public int compareTo(Land o) {
		return this.cost - o.cost;
	}
}

public class Solution_섬연결하기 {

	static int[] parent;

	public static int find(int n) {
		if (parent[n] == n) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	public static void union(int land1, int land2) {

		int Root1 = find(land1);
		int Root2 = find(land2);

		if (Root1 != Root2) {
			parent[Root2] = parent[Root1];
		}
	}

	public static int solution(int n, int[][] costs) {

		int answer = 0;
		int cnt = 0;

		PriorityQueue<Land> queue = new PriorityQueue<Land>();
		parent = new int[n];
		for (int i = 0; i < costs.length; i++) {
			queue.add(new Land(costs[i][0], costs[i][1], costs[i][2]));
		}

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		while (!queue.isEmpty()) {
			Land land = queue.poll();

			if (find(land.r) == find(land.c)) {
				continue;
			} else {
				union(land.r, land.c);
				answer += land.cost;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int n = 6; // 섬 수
		int[][] costs = new int[][] { { 0, 1, 5 }, { 0, 3, 2 }, { 0, 4, 3 }, { 1, 4, 1 }, { 3, 4, 10 }, { 1, 2, 2 },
				{ 2, 5, 3 }, { 4, 5, 4 } };
		System.out.println(solution(n, costs));
	}
}
