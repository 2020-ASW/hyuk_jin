package Algo_Study_Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Employee {
	
	int id;
	int cost;
	
	public Employee(int id, int cost) {
		this.id = id;
		this.cost = cost;
	}
}
public class Solution_매출하락최소화 {
	
	static List<Employee>[] treeMap;
	static boolean[] visit;
	static int[][] dp;
	static int N;
	
	private static void dfs(int cur) {

		visit[cur] = true;
		
		if(treeMap[cur].size() == 0) {
			return;
		}
		
		int sum = 0, cnt = 0;
		
		for(Employee child : treeMap[cur]) {
			if(visit[child.id]) {
				continue;
			}
			
			dfs(child.id);
			
			if(dp[child.id][0] > dp[child.id][1]) {
				sum += dp[child.id][1];
				cnt++;
			}
			else {
				sum += dp[child.id][0];
			}
		}
		
		dp[cur][1] += sum;
		
		if(cnt > 0) {
			dp[cur][0] = sum;
		}
		else {
			int min = Integer.MAX_VALUE;
			
			for(Employee child : treeMap[cur]) {
				min = Math.min(min, dp[child.id][1] - dp[child.id][0]);	
			}
			dp[cur][0] = sum + min;
		}
	}
    public static int solution(int[] sales, int[][] links) {
        
        N = sales.length;
        treeMap = new ArrayList[N + 1];
        dp = new int[N + 1][2];
        visit = new boolean[N + 1];
        Employee[] employees = new Employee[N + 1];
        for(int i = 1; i <= N; i++) {

        	treeMap[i] = new ArrayList<Employee>();
        	dp[i][1] = sales[i - 1];
        	employees[i] = new Employee(i, sales[i- 1]);
        }
        
        for(int[] link : links) {
        	treeMap[link[0]].add(employees[link[1]]);
        }
        
        dfs(1);
        
    	int answer = Math.min(dp[1][0], dp[1][1]);
        return answer;
    }
	public static void main(String[] args) {
		
		int[] sales = new int[] { 14, 17, 15, 18, 19, 14, 13, 16, 28, 17 };
		int[][] links = new int[][] {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};
		System.out.println(solution(sales, links));
	}
}
