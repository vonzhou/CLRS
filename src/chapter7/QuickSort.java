package chapter7;

import java.util.Arrays;

//P86
public class QuickSort {
	
	public void quicksort(int[] A, int p, int r){
		if(p<r){
			int q = partition(A, p, r);
			quicksort(A,p,q-1);
			quicksort(A,q+1,r);
		}
	}
	
	public int partition(int[] A, int p, int r){
		int x = A[r];
		int i= p-1;
		for(int j=p; j <= r-1; j++){
			if(A[j] <= x){
				i++;
				exchange(A, i, j);
			}
		}
		exchange(A, r, i+1);
		return i+1;
	}

	private void exchange(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	
	
	public static void main(String[] args) {
		int[] a = {2,8,7,1,3,5,6,4,};
		QuickSort q = new QuickSort();
		q.quicksort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
