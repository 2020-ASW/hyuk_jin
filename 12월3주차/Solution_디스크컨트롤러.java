package Algo_Study_Programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Job {
	int reqTime;
	int workTime;
	
	Job(int reqTime, int workTime) {
		this.reqTime = reqTime;
		this.workTime = workTime;
	}
}
public class Solution_디스크컨트롤러 {
	
    public static int solution(int[][] jobs) {
        LinkedList<Job> wait = new LinkedList<>();
    	
        PriorityQueue<Job> pq = new PriorityQueue<Job>(new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				return o1.workTime - o2.workTime;
			}
		});
   
        for(int[] job : jobs) {
        	wait.offer(new Job(job[0], job[1]));
        }
        
        Collections.sort(wait, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				return o1.reqTime - o2.reqTime;
			}
		});
        
    	int answer = 0;
        int cnt = 0;
        int time = 0;
        
        while(cnt < jobs.length) {
        	
        	while(!wait.isEmpty() && wait.peek().reqTime <= time) {
        		pq.offer(wait.pollFirst());
        	}
        	if(!pq.isEmpty()) {
        		Job job = pq.poll();
        		time += job.workTime;
        		answer += time - job.reqTime;
        		cnt++;
        	}
        	else {
        		time++;
        	}
        }
        return answer / cnt;
    }
	public static void main(String[] args) {
		int[][] jobs = new int[][] {{ 0, 3 } , { 1, 9 }, { 2, 6 }};
		solution(jobs);
	}
}
