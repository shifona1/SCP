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


	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];

		int t=nextInt();
		while(t-->0) 
		{
		int n=nextInt();
		int p=nextInt();
		int q=nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=nextInt();
		int[] b=new int[q/64+2];
		for(int i=0;i<b.length;i++)
			b[i]=nextInt();

		long[] prod=new long[n+1];
		prod[0]=1;
		for(int i=1;i<=n;i++)
			prod[i]=(prod[i-1]*a[i-1])%p;


		int li=0,ri=0,li_prev=0,ri_prev=0;
		int x=0;
		for(int i=0;i<q;i++)
		{
			if(i%64==0)
			{
				li=(b[i/64]+x)%n;
				ri=(b[i/64+1]+x)%n;
			}
			else
			{
				li=(li_prev+x)%n;
				ri=(ri_prev+x)%n;
			}
			if(li>ri)
			{
				int temp=ri;
				ri=li;
				li=temp;
			}
			int ans=(int)((prod[ri+1]*Inv(prod[li],p))%p);
			li_prev=li;
			ri_prev=ri;
			x=(ans+1)%p;

			// System.out.println(x+" "+li+" "+ri);
		}


		System.out.println(x);
		}
	}

	static long pow(long x,long y,long mod)
	{
		if (y==0) return 1; 
		long z=pow(x,y/2,mod)%mod;
		if(y%2==0) return (z*z)%mod;
		else return (((x*z)%mod)%z)%mod;
		
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