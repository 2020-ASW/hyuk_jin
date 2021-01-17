package retry01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_공통조상_re {
	static List<List<Integer>> list;
	static int[] depth, parent;
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	private static void dfs(int node, int level) {
		
		depth[node] = level;
		
		for(int child : list.get(node)) {
			if(depth[child] == 0) {
				dfs(child, level + 1);
				parent[child] = node;
			}
		}
	}
	
	private static int size_cnt(int target) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int size = 0;
		queue.add(target);
		
		while(!queue.isEmpty()) {
			size++;
			int cur = queue.poll();
			
			if(list.get(cur).size() == 0) {
				continue;
			}
			
			for(int child : list.get(cur)) {
				queue.add(child);
			}
		}
		
		return size;
	}

	private static int find(int A, int B) {
		
		while(depth[A] > depth[B]) {
			A = parent[A];
		}
		while(depth[A] < depth[B]) {
			B = parent[B];
		}
		while(A != B) {
			A = parent[A];
			B = parent[B];
		}
		
		return A;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int V = stoi(str.nextToken());
			int E = stoi(str.nextToken());
			
			int A = stoi(str.nextToken());
			int B = stoi(str.nextToken());
			
			depth = new int[V + 1];
			parent = new int[V + 1];
			
			list = new LinkedList<>();
			
			for(int i = 0; i <= V; i++) {
				list.add(new LinkedList<Integer>());
			}
			
			str = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < E; i++) {
				int a = stoi(str.nextToken());
				int b = stoi(str.nextToken());
				
				list.get(a).add(b);
			}
			
			dfs(1, 1);
			int result = size_cnt(find(A,B));
			System.out.println("#" + tc + " " + result);
		}
	}
}
