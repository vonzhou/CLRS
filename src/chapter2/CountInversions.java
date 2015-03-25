package chapter2;

//修改归并排序  对逆置个数进行统计
// Z这种做法是错误的 ！！！TODO
public class CountInversions {
	
	public static int countInversions(int[] A, int p, int r){
		if(p >= r)
			return 0;
		int inversions = 0;
		int q = (p+r)/2;
		inversions += countInversions(A,p,q);
		inversions += countInversions(A,q+1,r);
		inversions += mergeInversions(A,p,q,r);
		return inversions;
	}
	public static int mergeInversions(int[] A,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i=0; i<n1;i++)
			L[i] = A[p+i];
		for(int i=0;i<n2;i++)
			R[i] = A[q+i+1];
		
		//哨兵
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i=0,j=0;
		int inversions=0;
		boolean counted = false;
		for(int k=p; k<=r; k++){
			if(!counted && R[j] < L[i]){
				inversions += n1-i+1;  // L[i...n1],R[j] all is inverse
				counted = true;
			}
			if(L[i] <= R[j]){
				A[k] = L[i++];
			}
			else {
				A[k] = R[j++];
				counted = false; // eat the first number in R 
			}
		}
		
		return inversions;
 	}
	
	
	public static void display(int[] a) {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {4,3,2,1,0};
		System.out.println(countInversions(a, 0, a.length-1));
	}
}
