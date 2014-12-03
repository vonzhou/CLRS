package chapter2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/*
 * 习题 2.3-7 
 */
public class TwoSum {
	
	//题目考察的方式:先排序，再二分查找
	public static boolean twoSum(int[] numbers, int target){
		if(numbers == null || numbers.length <= 1)
			return false;
		MergeSort.mergeSort(numbers, 0, numbers.length-1);
		for(int i=0; i<numbers.length-1; i++)
			if(binarySearch(numbers,i+1,numbers.length-1,target-numbers[i]))
				return true;
		
		return false;
	}
	
	public static boolean binarySearch(int[] numbers, int from, int to, int target) {
		int low=from, high=to;
		while(low<=high){
			int m = low + (high-low)/2;
			if(target == numbers[m])
				return true;
			else if(target > numbers[m])
				low=m + 1;
			else high=m-1;
		}
		return false;
	}
/*
	public static int[] mergeTwo(int[] a, int[] b){
		int res[] = new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i <a.length && j<b.length){
			if(a[i] <= b[i])
				res[k++] = a[i++];
			else res[k++] = b[j++];
		}
		while(i < a.length)
			res[k++] = a[i++];
		while(j < b.length)
			res[k++] = b[j++];
		
		return res;
	}
	
	public int[] dedup(int[] numbers) {
		int k=1;
		for(int i=1;i<numbers.length;i++)
			if(numbers[i] != numbers[i-1])
				numbers[k++] = numbers[i];
		
		return Arrays.copyOf(numbers, k);
	}
	
*/	
	public static void main(String[] args) {
		int a[] = {1,34,4,454,3,6,8,};
		System.out.println(twoSum(a,12));
	}
	
	
	
}


















