package retry01;

import java.util.*;
public class Main_3745_오름세 {
	static int[] arr;
	static List<Integer> list;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()) {
			
			int N = sc.nextInt();
			
			arr = new int[N];
			list = new LinkedList<Integer>();
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			list.add(arr[0]);
			
			for(int num : arr) {
				if(num > list.get(list.size() - 1)) {
					list.add(num);
				}
				else {
					
					int left = 0;
					int right = list.size();
					
					while(left < right) {
						
						int mid = (left + right) / 2;
						
						if(list.get(mid) < num) {
							left = mid + 1;
						}
						else {
							right = mid;
						}
					}
					list.set(right, num);
				}
			}
			sb.append(list.size() + "\n");
		}
		System.out.println(sb.toString());
	}
}
