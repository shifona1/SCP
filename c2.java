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
	static long mod=998244353; 

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];

		int a=nextInt();
		int b=nextInt();
		int c=nextInt();
		// for(int i=0;i<t;i++) 
		int n=0,m=0;
		{
			//frst
			long count=1;
			n=a+b;
			m=Math.min(a,b);
			count=(count*(comb(n,m)%mod))%mod;

			n=c+b;
			m=Math.min(c,b);
			count=(count*(comb(n,m)%mod))%mod;
			
			n=a+c;
			m=Math.min(a,c);
			count=(count*(comb(n,m)%mod))%mod;
			

			System.out.println(count);
			// System.out.println(((pow(2,a*b)*pow(2,b*c))%mod)*pow(2,a*c)%mod);
		}
	}

		static long comb(int n,int m)
		{
			long num=fact(n)%mod;
			long den=(fact(m)*fact(n-m))%mod;
			long den_inv=pow(den,mod-2);
			return (num*den_inv)%mod;
		}

		static long pow(long x,long y)
		{
			if(y==1) return x;
			if(y==0) return 1;
			long z=pow(x,y/2)%mod;
			if(y%2==0)
				return (z*z)%mod;
			else 
				return (((x*z)%mod)*z)%mod;

		} 

		static long fact(int n)
		{
			if(n==0) return 1;
			else
			return (n*(fact(n-1)%mod))%mod;
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