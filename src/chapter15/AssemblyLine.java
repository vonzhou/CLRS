package chapter15;

public class AssemblyLine {
	
	int n = 0; // station number
	int[][] f = new int[3][n+1]; // fastest time to Si,j
	int[][] L = new int[3][n+1]; // fastest station to Si,j
	// f[0][0] is f*, L[0][0] is L*
	
	public AssemblyLine(int n){
		this.n = n;
		//System.out.println(f.length);
		for(int i=0;i<3;i++)
			f[i] = new int[n+1];
		for(int i=0;i<3;i++)
			L[i] = new int[n+1];
	}
	
	public void computeFastestWay(int n, int[] e, int[] x, int[][] a, int[][] t){
		/*System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println("a:"+a[1][1]);
		System.out.println("e:"+e[1]);
		System.out.println("f:"+f[1][1]);*/
		f[1][1] = e[1] + a[1][1];
		f[2][1] = e[2] + a[2][1];
		for(int j=2; j<=n; j++){
			if(f[1][j-1] + a[1][j] <= f[2][j-1]+t[2][j-1]+a[1][j]){
				f[1][j] = f[1][j-1] + a[1][j] ;
				L[1][j] = 1;
			}else{
				f[1][j] = f[2][j-1] + t[2][j-1] + a[1][j];
				L[1][j] = 2;
			}
			if(f[2][j-1] + a[2][j] <= f[1][j-1]+t[1][j-1]+a[2][j]){
				f[2][j] = f[2][j-1] + a[2][j] ;
				L[2][j] = 2;
			}else{
				f[2][j] = f[1][j-1] + t[1][j-1] + a[2][j];
				L[2][j] = 1;
			}
		}
		
		if(f[1][n] + x[1]<= f[2][n] + x[2]){
			f[0][0] =  f[1][n] + x[1];
			L[0][0] = 1;
		}else{
			f[0][0] =  f[2][n] + x[2];
			L[0][0] = 2;
		}
	}
	
	public void showFastestWay(){
		for(int i=1; i<=2;i++){
			for(int j=1; j<=n; j++){
				System.out.print(f[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println("The fastest way sosume time : " + f[0][0]);
	}
	
	public void printStations(){
		int i = L[0][0]; 
		System.out.println("Line " + i + ",Station " + n);
		for(int j=n; j>=2; j--){
			i = L[i][j];
			System.out.println("Line " + i + ",Station " + (j-1));
		}
			
	}
	
	public static void main(String[] args) {
		int n = 6;
		int[] e = {0, 2, 4};
		int[] x = {0, 3, 2};
		int[][] a = {{0,0,0,0,0,0,0},
					{0, 7, 9, 3, 4, 8, 4},
					{0, 8, 5, 6, 4, 5, 7}};
		int[][] t = {{0,0,0,0,0,0,0},
					{0,  2, 3, 1, 3, 4, 0},
					{0, 2, 1, 2, 2, 1,0}};
		AssemblyLine al = new AssemblyLine(n);
		//System.out.println(a[1][1]);
		al.computeFastestWay(n, e, x, a, t);
		al.showFastestWay();
		al.printStations();
		
	}
}
