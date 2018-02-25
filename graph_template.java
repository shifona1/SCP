import java.util.*;
import java.io.*;

// public class Solution implements Runnable
class Solution implements Runnable
{
	public static void main(String[] args) throws IOException  {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];
		new Thread(null, new Solution(), "Main", 1<<28).start();
	}

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


	public void main() throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];

		int t=nextInt();
		while(t-->0) {
			

		}
		// System.out.println("Case #"+(t+1)+": ");
	}

	public void run() {
		try
		{
			main();
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

class Graph 
{
	ArrayList<ArrayList<Pair<Integer,Integer>>> a=new ArrayList<ArrayList<Pair<Integer,Integer>>>();
	int[] flag;
	int[] marked;
	int[] distance;
	int counter=0;
	TreeSet<Pair<Integer,Integer>> pq;
	// int[] distances;
	 void creategraph(int n)
	{
		a.clear();		
		flag=new int[n];
		distance=new int[n];
		Arrays.fill(distance,Integer.MAX_VALUE);
		for(int i=0;i<n;i++)
		{
			a.add(new ArrayList<Pair<Integer,Integer>>());
		}
		pq=new TreeSet<Pair<Integer,Integer>>();
	}

	 void addEdge(int u,int v,int cost)
	{
		a.get(u).add(new Pair<Integer,Integer>(v,cost));
	}

	 void components(int n)
	{
		for(int i=0;i<n;i++)
			if(flag[i]==0){
				counter++; 
				dfs(i);
			}
	}

	 void dfs(int s)
	{
		if(flag[s]!=0) return;
		else
		flag[s]=counter;
		ArrayList<Pair<Integer,Integer>> temp=a.get(s);
		for(int i=0;i<temp.size();i++)
			{
				dfs(temp.get(i).a);
			}
	}

	void dijkshtra(int s)
	{
		Pair<Integer,Integer> current;
		marked = new int[a.size()];
		while(pq.size()>0) {
			current = pq.first();
			pq.pollFirst();
			if(marked[current.b]>0)
				continue;
			marked[current.b]=1;

			ArrayList<Pair<Integer,Integer>> arr=a.get(current.b);
			for(Pair<Integer,Integer> k:arr)
			{
				if(distance[current.b]+k.b<distance[k.a])
				{
					distance[k.a]=distance[current.b]+k.b;
					pq.add(new Pair<Integer,Integer>(distance[k.a],k.a));
				
				}
			}			

		}
	}


}