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


	public void main()  {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];

		int t=1;
		while(t-->0) {
			int n=nextInt();
			int m=nextInt();
			int[] a=new int[n];
			int[] b=new int[n];
			for (int i=0;i<n ;i++ ) {
				a[i]=nextInt();
			}
 			for (int i=0;i<n ;i++ ) {
				b[i]=nextInt();
			}
			long currn=1,currd=1;
			long sum=0;
			for (int i=0;i<n ;i++ ) {
				if((a[i]!=0 || b[i]!=0)){
					if(a[i]>b[i])
					{
						sum=(sum+getval(currn,currd))%mod;
					}
					break; 	
				}
				else 
				{
					long h;
					if(a[i]==0 && b[i]!=0){
						h=getval((currn*(m-b[i]))%mod, ( m*currd)%mod);
						currd=(currd*m)%mod;
					}
					else if(a[i]!=0 && b[i]==0)
					{
						h=getval(currn*((a[i]-1))%mod,(m*currd)%mod);
						currd=(currd*m)%mod;
					}
					else
					{
						h=getval((currn*(m-1))%mod,(2*m*currd)%mod);
						currd=(((currd*m)%mod)*m)%mod;
					}
					sum=(sum+h)%mod;

				}	
			}
		println(sum);
		}
	}

	public long getval(long a,long b)
	{
		long x=pow(b,mod-2,mod);
		return (a*x)%mod;
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