package chapter2;

public class MergeSort {
	public static void merge(int[] A,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i=0; i<n1;i++)
			L[i] = A[p+i];
		for(int i=0;i<n2;i++)
			R[i] = A[q+i+1];
		
		//из╠Ь
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i=0,j=0;
		for(int k=p; k<=r; k++){
			if(L[i] <= R[j])
				A[k] = L[i++];
			else A[k] = R[j++];
		}
 	}
	
	public static void mergeSort(int A[],int p, int r){
		if(p >= r)
			return ;
		int q = (p+r)/2;
		mergeSort(A,p,q);
		mergeSort(A,q+1,r);
		merge(A,p,q,r);
	}
	public static void display(int[] a) {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		int A[] = {5,2,4,7,1,3,6};
		mergeSort(A,0,A.length-1);
		display(A);
	}

}
