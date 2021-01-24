package Algo_Study_Programmers;

import java.util.*;

class Food implements Comparable<Food> {
	
	int index;
	int time;
	
	public Food(int index, int time) {
		this.index = index;
		this.time = time;
	}
	
	@Override
	public int compareTo(Food o) {
		return this.time - o.time;
	}
}
public class Solution_무지의먹방라이브 {
    public static int solution(int[] food_times, long k) {
        
        long sum = 0;
        int len = food_times.length;
        
        for(int i = 0; i < len; i++) {
        	sum += food_times[i];
        }
        // 시간 보다 다 먹는 시간이 짧은 경우
        if(sum <= k) {
        	return -1;
        }
        
        PriorityQueue<Food> pq = new PriorityQueue<Food>();
        
        for(int i = 0; i < len; i++) {
        	pq.add(new Food(i + 1, food_times[i]));
        }
        
        sum = 0;
        
        long pre_time = 0;
        
        while(sum + (pq.peek().time - pre_time) * len <= k) {
        	int min_time = pq.poll().time;
        	
        	sum += ( min_time - pre_time) * len;
        	len--;
        	pre_time = min_time;
        }

        List<Food> list = new LinkedList<>();
        
        while(!pq.isEmpty()) {
        	list.add(pq.poll());
        }
        
        Collections.sort(list, new Comparator<Food>() {

			@Override
			public int compare(Food o1, Food o2) {
				return Integer.compare(o1.index, o2.index);
			}
        });
        
        return list.get((int)((k - sum) % len)).index;
    }
	
	public static void main(String[] args) {
		int[] food_times = new int[] { 3, 1, 2};
		int k = 5;
		System.out.println(solution(food_times, k));
	}
}
