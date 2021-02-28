package Algo_Study_Programmers;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	
	int cnt;
	Map<Character, TrieNode> childs;
	
	public TrieNode() {
		cnt = 0;
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
			cur.cnt++;
			if(!cur.childs.containsKey(curChar)) {
				cur.childs.put(curChar, new TrieNode());
			}
			cur = cur.childs.get(curChar);
		}
	}
	
	public int find(String s) {
		
		TrieNode cur = root;
		
		for(Character curChar : s.toCharArray()) {
			if(curChar == '?') {
				return cur.cnt;
			}
			
			cur = cur.childs.get(curChar);
			if(cur == null) {
				return 0;
			}
		}
		
		return cur.cnt;
	}
}


public class Solution_가사검색 {
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
		Trie2[] trie = new Trie2[10000];
		Trie2[] Rtrie = new Trie2[10000];
		for(int i = 0 ; i < words.length; i++) {
			String word = words[i];
			int idx = word.length() - 1;
			
			if(trie[idx] == null) {
				trie[idx] = new Trie2();
				Rtrie[idx] = new Trie2();
			}
			trie[idx].add(word);
			Rtrie[idx].add(new StringBuilder(word).reverse().toString());			
		}
		int cnt = 0;
		int result = 0;
		
		for(String query : queries) {
			int idx = query.length() - 1;
			
			if(trie[idx] == null) {
				answer[cnt++] = 0;
				continue;
			}
			if(query.charAt(0) != '?') {
				result = trie[idx].find(query);
			}
			else {
				result = Rtrie[idx].find(new StringBuilder(query).reverse().toString());
			}
			answer[cnt++] = result;
		}
        return answer;
    }
	
	public static void main(String[] args) {
		
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?" }; 
		solution(words, queries);
	}
}
