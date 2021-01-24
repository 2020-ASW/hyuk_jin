package Algo_Study_LeetCode;

public class Solution_Couples_Holding_Hands {
    public static int minSwapsCouples(int[] row) {
        
    	int len = row.length;
    	if(row == null || len <= 2) {
    		return 0;
    	}
    	
    	int[] arr = new int[len];
    	
    	for(int i = 0; i < len; i++) {
    		arr[row[i]] = i;
    	}
    	
    	int answer = len / 2; 
    	
    	for(int i = 0; i <len; i += 2) {
    		if(arr[i] / 2 == arr[i+1] / 2) {
    			answer--;
    		}
    		else {
    			int swap;
    			
    			if(arr[i] % 2 == 0) {
    				swap = row[arr[i] + 1];
    			}
    			else {
    				swap = row[arr[i] - 1];
    			}
    			
    			int cou = i + 1;
    			
    			row[arr[swap]] = cou;
    			row[arr[cou]] = swap;
    			
                int tmp = arr[swap];
                arr[swap]= arr[cou];
                arr[cou]= tmp;
    		}
    	}
    	return answer;
    }
	public static void main(String[] args) {
		int[] row = new int[] { 0, 2 , 1, 3 };
		System.out.println(minSwapsCouples(row));
	}
}
