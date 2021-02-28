package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
	Map<Character, TrieNode> childs;
	boolean isLastWord;
	
	public TrieNode() {
		isLastWord = false;
		childs = new HashMap<>();
	}
}

class Trie2 {
	
	TrieNode root;
	
	public Trie2() {
		root = new TrieNode();
	}
	
	public void add(String s) {
		TrieNode cur = root;
		
		for(Character curChar : s.toCharArray()) {
			if(!cur.childs.containsKey(curChar)) {
				cur.childs.put(curChar, new TrieNode());
			}
			cur = cur.childs.get(curChar);
		}
		cur.isLastWord = true;
	}
	
	public double find(String s) {
		
		TrieNode cur = root.childs.get(s.charAt(0));
		
		int answer = 1;
		
		for(int i = 1; i < s.length(); i++) {
			if(cur.childs.size() != 1 || cur.isLastWord) {
				answer++;
			}
			cur = cur.childs.get(s.charAt(i));
		}
		return answer;
	}
}
public class Main_5670_휴대폰자판 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "";
		
		while(( s = br.readLine()) != null ) {
			
			int N = Integer.parseInt(s);
			
			Trie2 trie = new Trie2();
			String[] words = new String[N];
			
			for(int i = 0; i < N; i++) {
				words[i] = br.readLine();
				trie.add(words[i]);
			}
			
			double answer = 0;
			for(int i = 0; i < N; i++) {
				answer += trie.find(words[i]);
			}
			
			System.out.println(String.format("%.2f",answer / N ));
		}
	}
}
