package Algo_Study_Programmers;

import java.util.*;

public class Solution_동굴탐험 {
	static final int MAXIMUM = 200002;
	static List<Integer>[] adj = new LinkedList[MAXIMUM];
	static List<Integer>[] graph = new LinkedList[MAXIMUM];
	static boolean[] check = new boolean[MAXIMUM];
	static boolean[] visit = new boolean[MAXIMUM];
	static boolean[] finish = new boolean[MAXIMUM];
	static boolean flag;
	
	private static void dfs(int i) {
		visit[i] = true;
		
		for(int j : adj[i]) {
			if(visit[j]) {
				continue;
			}
			graph[i].add(j);
			dfs(j);
		}
	}
	
	private static void isCycle(int i) {
		check[i] = true;
		for(int j : graph[i]) {
			if(!check[j]) {
				isCycle(j);
			}
			else {
				if(!finish[j]) {
					flag = true;
				}
			}
		}
		finish[i] = true;
	}
	public static boolean solution(int n, int[][] path, int[][] order) {
		
		int u, v;
		
		for(int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Integer>();
			graph[i] = new LinkedList<Integer>();
 		}
		
		for(int i = 0; i < path.length; i++) {
			u = path[i][0];
			v = path[i][1];
			
			adj[u].add(v);
			adj[v].add(u);
		}
		dfs(0);
		for(int i = 0; i < order.length; i++) {
			u = order[i][0];
			v = order[i][1];
			graph[u].add(v);
		}
		flag = false;
		isCycle(0);
		
		for(int i = 0; i < n; i++) {
			visit[i] = check[i] = finish[i] = false;
		}
		for(int i = 0; i < n; i++) {
			adj[i].clear();
			graph[i].clear();
		}
		return !flag;
	}
	public static void main(String[] args) {
		int n = 9;
		int[][] path = new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		int[][] order = new int[][] {{8,5},{6,7},{4,1}};
		System.out.println(solution(n, path, order));
	}
}
