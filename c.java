import java.util.*;
import java.io.*;

// public class Solution implements Runnable
class Solution implements Runnable
{
	public static void main(String[] args) throws IOException  {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];
		bos = new OutputStreamWriter(new BufferedOutputStream(System.out));
		new Thread(null, new Solution(), "Main", 1<<28).start();
	}

	static BufferedReader br;
	static String nextIntBuffer[];
	static int nextIntBase;
	public static int mod=998244353;
	static OutputStreamWriter bos;
	static int nextInt() {
		return Integer.parseInt(next());
	}

	static long nextLong() {
		return Long.parseLong(next());
	}

	static String next() {
		try{
			if(nextIntBase>=nextIntBuffer.length) {
				nextIntBase =0;
				nextIntBuffer = br.readLine().split(" ");
			}
		}catch(IOException e) {}
		return nextIntBuffer[nextIntBase++];
	}


	static void print (String s)    {try{ bos.write(s);	}catch(IOException e){}}
	static void print (int s)  {try{ bos.write(String.valueOf(s));	}catch(IOException e){}}
	static void print (long s)  {try{ bos.write(String.valueOf(s));	}catch(IOException e){}}
	static void print (double s)  {try{ bos.write(String.valueOf(s));	}catch(IOException e){}}
	static void println (String s)  {try{ print(s); 	bos.write('\n');	}catch(IOException e){}}
	static void println (int s)  {try{ print(s); 	bos.write('\n');	}catch(IOException e){}}
	static void println (long s)  {try{ print(s); 	bos.write('\n');	}catch(IOException e){}}
	static void println (double s)  {try{ print(s); 	bos.write('\n');	}catch(IOException e){}}

		public static <T1 extends Comparable<T1> ,T2 extends Comparable<T2> > Pair<T1,T2> mp(T1 a,T2 b) {
		return new Pair<T1,T2>(a,b);
	}

	static long[] fact;
	public void main()  {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];

		int t=1;
		while(t-->0) {
			int a=nextInt();
			int b=nextInt();
			int c=nextInt();
			fact=new long[500001];
			fact[0]=1;
			for (int i=1;i<5001 ;i++ ) {
				fact[i]=i*fact[i-1]%mod;
			}
			long ans1=0,ans2=0,ans3=0;
			for (int i=0;i<=Math.min(a,b) ;i++ ){ 
				ans1+=(pnc(a,i)*pnc(b,i)%mod*fact(i))%mod;
				ans1%=mod;
			}

			for (int i=0;i<=Math.min(c,b) ;i++ ) {
				ans2+=(pnc(c,i)*pnc(b,i)%mod*fact(i))%mod;
				ans2%=mod;
			}
			
			for (int i=0;i<=Math.min(a,c) ;i++ ) {
				ans3+=(pnc(a,i)*pnc(c,i)%mod*fact(i))%mod;
				ans3%=mod;
			}
			
			// println(ans1+" "+ans2+" "+ans3);

		println(ans1*ans2%mod*ans3%mod);
		}
	}

	static long fact(long x)
	{
		return fact[(int)x];
	}

	static long pnc(long n,long r)
	{
		return (fact(n)*Inv(fact(r),mod)%mod*Inv(fact(n-r),mod)%mod);
	}

	public void run() {
		try
		{
			main();
			bos.flush();
		}catch(IOException e) {
			e.printStackTrace();
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
		// throw new RuntimeException();
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