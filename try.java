import java.util.*;
import java.io.*;

// public class Solution
class Solution
{
	static BufferedReader br;
	static String nextIntBuffer[];
	static int nextIntBase;
	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static String next() throws IOException {
		if(nextIntBase>=nextIntBuffer.length) {
			nextIntBase =0;
			nextIntBuffer = br.readLine().split(" ");
		}
		return nextIntBuffer[nextIntBase++];
	}

		public static <T1 extends Comparable<T1> ,T2 extends Comparable<T2> > Pair<T1,T2> mp(T1 a,T2 b) {
		return new Pair<T1,T2>(a,b);
	}
	static int readI() throws IOException {
		String a = next();
		if(a.contains(".")) {
			int i = a.indexOf(".");
			return Integer.parseInt(a.substring(0,i)+a.substring(i+1));
		}
		return Integer.parseInt(a)*100;

	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];

		int t=nextInt();
		for(int l=1;l<=t;l++) {
			int n=nextInt();
			int m=nextInt();
			double[] a=new double[n];
			for(int i=0;i<n;i++)
				a[i]=nextDouble();
			Arrays.sort(a);
			System.out.println("Case "+l+":");
			for(int t2=1;t2<=m;t2++)
			{
				System.out.println("Scenario "+t2+":");
				double z=nextDouble();
				for (int i=a.length-1; i>=0; --i) {
					int c=(int)(z/a[i]);
					if(c!=0) {
						if(a[i]>=1)
						System.out.println((int)Math.round(a[i])+" "+c);
					else
						System.out.println((a[i]*1.00)+" "+c);
					}
					z-=c*a[i];
				}
				// int c=(int)(z*100);
				// // int[] count=new int[10000]; 
				// while(c!=0){
				// 	int x=Arrays.binarySearch(a,z);
				// 	int y=x;	
				// 	if(x<0)
				// 	y=Math.abs(x+2);
				// 	int count=(c/(int)a[y]);

				// 	System.out.println(a[y]/100+" "+count);
				// 	c-=count*a[y];
				// }	
			}
// ,k
		}
	}

	static long pow(long x,long y,long mod)
	{
		if (y==0) return 1; 
		long z=pow(x,y/2,mod)%mod;
		if(y%2==0) return (z*z)%mod;
		else return (((x*z)%mod)*z)%mod;
		
	}

	static long gcd(long q,long d) {
		long x1[]=new long[1];long y1[]=new long[1];
		return  gcd(q,d,x1,y1);
	}
	static long gcd(long q,long d,long x[],long y[]) {
		if(d%q==0) {
			x[0]=1;
			y[0]=0;
			return q;
		}
		long x1[]=new long[1];long y1[]=new long[1];
		long ans = gcd(d%q,q,x1,y1);
		y[0]=x1[0];
		x[0]=y1[0]-(d/q)*x1[0];
		return ans;
	}
	static long Inv(long n,long m) {
		long x[]=new long[1];long y[]=new long[1];
		long g= gcd(n,m,x,y);
		if(g==1) {
			return (x[0]+m)%m;
		}
		return -1;
	}
}

class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2> > implements Comparable<Pair<T1,T2> > {
	  T1 a;
	  T2 b;
	  public Pair(T1 x, T2 y) {
	    a = x; b = y;
	  }
	  @Override
	  public int compareTo(Pair<T1,T2> other) {
	  	int comp1 = a.compareTo(other.a);
	  	if(comp1!=0)
	  		return comp1;
	    return b.compareTo(other.b);
	}
}	