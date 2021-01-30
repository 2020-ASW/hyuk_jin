package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node2 {
	int node;
	int cost;
	
	public Node2(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}
public class Main_1167_트리의지름 {
	static List<List<Node2>> list;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;
	static int max_point = 0;
	private static void dfs(int node, int cost) {
		
		if(cost > max) {
			max = cost;
			max_point = node;
		}
		
		for(Node2 cur : list.get(node)) {
			
			if(!visit[cur.node]) {
				visit[node] = true;
				dfs(cur.node, cost + cur.cost);
				visit[node] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		
		list = new ArrayList<List<Node2>>();
		visit = new boolean[V + 1];
		for(int i = 0; i <= V; i++) {
			list.add(new ArrayList<Node2>());
		}
		for(int i = 0; i < V; i++) {
			
			StringTokenizer str = new StringTokenizer(br.readLine());
			int len = str.countTokens();
			
			int st = Integer.parseInt(str.nextToken());
			
			for(int j = 0; j < (len - 2) / 2; j++) {
				int ed = Integer.parseInt(str.nextToken());
				int cost = Integer.parseInt(str.nextToken());
				
				list.get(st).add(new Node2(ed, cost));
			}
		}
		
		visit[1] = true;
		dfs(1, 0);
		
		dfs(max_point, 0);
		
		System.out.println(max);
		
	}
}
