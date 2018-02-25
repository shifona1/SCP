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
		// Reader br = new Reader();
		BufferedWriter os= new BufferedWriter(new OutputStreamWriter(System.out));
		nextIntBuffer = new String[0];

		int t=nextInt();
		while(t-->0)
		{
			int n=nextInt();

			int[] a=new int[n];
			Lazy st=new Lazy(n);
			// for(int i=0;i<n;i++) 
			// {
			// 	a[i]=nextInt();	
			// }
			st.build(a);
			int q=nextInt();
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<q;i++)
			{
				int i1=nextInt();
				int i2=nextInt();
				int i3=nextInt();
				if(i1==0){
					int i4=nextInt();
					st.update(i2-1,i3,i4);
				}
				else
				{
					// st.query(i2-1,i3);
					os.write(st.query(i2-1,i3)+"\n");
				}	
			}
			os.flush();
		}

		// System.out.println("Case #"+(t+1)+": ");
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

class Lazy
{
	long[] array;
	long[] aux;
	int size;
	int[] height;

	public Lazy(int s)
	{
		size=1;
		while(size<s) size=size*2;
		array=new long[2*size];
		aux=new long[2*size];
		height=new int[2*size];
		int count=0,c1=0;
		int t=size;
		for(int i=2*size-1;i>0;i--)
		{
			height[i]=c1;
			count++;
			if(count==t)
			{
				c1++;
				count=0;
				t/=2;
			}
		}
	}

	void build(int[] a)
	{
		for(int i=0;i<a.length;i++)
			array[size+i]=a[i];
		for(int i=size-1;i>0;i--)
			merge(i);
	} 

	void merge(int index)
	{
		long l=array[2*index];
		long r=array[2*index+1];
		array[index]=merge(l,r); 
		array[index]+=(1<<height[index])*aux[index]; // change
	}

	long merge(long no1,long no2) 				// change
	{
		return no1+no2;
	}

	void apply(int index,long value) //change
	{
		array[index]+=(1<<height[index])*value;
		aux[index]+=value;
	}

	// including l and excluding r
	long query(int l,int r) 
	{ 
		long sum=0;
		push(l+size);
		push(r-1+size); 

		for(int i=l+size,j=r+size;i<j;i>>=1,j>>=1)
		{
			if((i&1)==1) sum=merge(sum,array[i++]);
			if((j&1)==1) sum=merge(sum,array[--j]); 
		}
		return sum;
	}

	void push(int index)
	{
		int h = height[1]-height[index];
		for(int i=h;i>0;i--)
		{
			int p=index>>i;
			apply(p<<1,aux[p]);
			apply(p<<1|1,aux[p]);
			aux[p]=0;

		}
	}

	void update(int l,int r,int value)
	{
		// int sum=0;
		for(int i=l+size,j=r+size;i<j;i>>=1,j>>=1)
		{
			if((i&1)==1) apply(i++,value);
			if((j&1)==1) apply(--j,value); 
		}
		
		fixup(l+size);
		fixup(r-1+size);

	}

	void fixup(int ind)
	{
		for(int i=ind/2;i>0;i>>=1)
			{
				merge(i);
			}		
	} 



}