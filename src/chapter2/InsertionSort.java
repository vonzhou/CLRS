package chapter2;

public class InsertionSort {
	
	public static void insertionSort(int[] A){
		if(A == null || A.length <= 1)
			return ;
		for(int i = 1; i < A.length; i++){
			int key = A[i];
			int j = i-1;
			while(j >= 0 && A[j] > key){
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = key;
		}
	}
	public static void display(int[] a) {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		int A[] = {5,2,4,6,1,3,};
		insertionSort(A);
		display(A);
	}

	

}
