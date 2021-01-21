package Algo_Study_Programmers;

import java.util.*;

class Node2 { 
	int count;
	Map<Character, Node2> map;
	
	public Node2() {
		this.count = 1;
		map = new HashMap<Character, Node2>();
	}
}

public class Solution_자동완성2 {
	static Node2 root;
	static int answer;
	
	private static void insert(String word) {
		Node2 curHead = root;
		for(int i = 0; i < word.length(); i++) {
			if(curHead.map.containsKey(word.charAt(i))) {
				curHead.map.get(word.charAt(i)).count++;
				curHead = curHead.map.get(word.charAt(i));
			}
			else {
				Node2 tmp = new Node2();
				curHead.map.put(word.charAt(i), tmp);
				curHead = curHead.map.get(word.charAt(i));
			}
		}
	}
	private static void find(String word) {
		Node2 curHead = root;
		for(int i = 0; i < word.length(); i++) {
			if(curHead.map.containsKey(word.charAt(i))) {
				curHead = curHead.map.get(word.charAt(i));
				answer++;
			}
			
			if(curHead.count == 1) {
				return;
			}
		}
	}
    public static int solution(String[] words) {
    	
    	answer = 0;
    	
    	root = new Node2();
    	
    	for(int i = 0; i < words.length; i++) {
    		insert(words[i]);
    	}
    	
    	for(int i = 0; i < words.length; i++) {
    		find(words[i]);
    	}
    	return answer;
    }
	public static void main(String[] args) {
		String[] tmp = { "go", "gone", "guild" };
		
		System.out.println(solution(tmp));
	}
}
