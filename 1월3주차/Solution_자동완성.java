package retry01;

import java.util.*;

class Node {
	char word;
	int count;
	Map<Character, Node> list;
	
	public Node(char word) {
		this.word = word;
		this.count = 1;
		list = new HashMap<Character, Node>();
	}
}
public class Solution_자동완성 {
	static Node head = new Node(' ');
	
	private static void insert(String word) {
		Node cur = head;
		
		for(int i = 0; i < word.length(); i++) {
			if(cur.list.containsKey(word.charAt(i))) {
				cur.list.get(word.charAt(i)).count++;
				cur = cur.list.get(word.charAt(i));
			}
			else {
				Node tmp = new Node(word.charAt(i));
				cur.list.put(word.charAt(i), tmp);
				cur = cur.list.get(word.charAt(i));
			}
		}
	}
	private static int find(String word) {
		Node cur = head;

		int result = 0;
		for(int i = 0; i < word.length(); i++) {
			result++;
			if(cur.list.get(word.charAt(i)).count > 1) {
				cur = cur.list.get(word.charAt(i));
			}
			else {
				return result;
			}
		}
		return result;
	}
	public static int solution(String[] words) {
		
		for(int i = 0; i < words.length; i++) {
			insert(words[i]);
		}
		
		int result = 0;
		
		for(int i = 0; i < words.length; i++) {
			result += find(words[i]);
		}
		
		return result;
	}
	public static void main(String[] args) {
		String[] words = {"abc", "def", "ghi", "jklm" };
		System.out.println(solution(words));
	}
}
