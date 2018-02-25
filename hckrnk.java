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

	static void creategraph(ArrayList<ArrayList<Integer>> a,int n)
	{
		a.clear();
		for(int i=0;i<n;i++)
		{
			a.add(new ArrayList<Integer>());
		}
	}
	static int[] flag;
	static int counter=1;
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];

		ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
		int t=nextInt();
		while(t-->0) 
		{
			int n=nextInt();
			flag=new int[n];
			counter=0;
			creategraph(a,n);
			int m=nextInt();
			long cl=nextInt();
			long cr=nextInt();
			for(int i=0;i<m;i++)
			{
				int u=nextInt()-1;
				int v=nextInt()-1;
				a.get(u).add(v);				
				a.get(v).add(u);
			}
			components(a,n);
			int[] just=new int[n+1];
			for(int i=0;i<flag.length;i++)
				just[flag[i]]++;
			long cost=0;
			for(int i=0;i<just.length;i++)
				if(cl<cr)
					cost+=cl*just[i];
				else if(just[i]!=0)
					cost+=(cr*(just[i]-1)+cl);
		System.out.println(cost);
		}
	}

	static void components(ArrayList<ArrayList<Integer>> a,int n)
	{
		// ArrayList<Integer> temp=a.get(start);
		for(int i=0;i<n;i++)
			if(flag[i]==0){
				counter++; 
				dfs(a,i);
				// components(a,i,n);
			}
		// return counter;	
	}

	static void dfs(ArrayList<ArrayList<Integer>> a,int s)
	{
		if(flag[s]!=0) return;
		else
		flag[s]=counter;
		ArrayList<Integer> temp=a.get(s);
		for(int i=0;i<temp.size();i++)
			{
				// if(flag[temp.get(i)]==0)
				dfs(a,temp.get(i));
			}
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