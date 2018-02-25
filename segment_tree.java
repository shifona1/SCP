import java.util.*;
import java.io.*;

// public class Solution
class Solution
{
	 static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 


        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
 




	public static void main(String[] args) throws IOException {
		// br=new BufferedReader(new InputStreamReader(System.in));
		Reader br = new Reader();
		BufferedWriter os= new BufferedWriter(new OutputStreamWriter(System.out));
		// nextIntBuffer = new String[0];

		int n=br.nextInt();
		int[] a=new int[n];
		SegmentTree st=new SegmentTree(n);
		for(int i=0;i<n;i++) 
		{
			a[i]=br.nextInt();	
		}
		st.build(a);
		int q=br.nextInt();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<q;i++)
		{
			// int i1=nextInt();
			int i2=br.nextInt();
			int i3=br.nextInt();
				
				os.write(st.query(i2-1,i3)+"\n");
		}
		os.flush();

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

class SegmentTree
{
	int[] array;
	int size;

	public SegmentTree(int s)
	{
		size=1;
		while(size<s) size=size*2;
		array=new int[2*size];
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
		int l=array[2*index];
		int r=array[2*index+1];
		array[index]=merge(l,r);
	}

	int merge(int no1,int no2)
	{
		return Math.max(no1,no2);
	}

	// including l and excluding r
	int query(int l,int r) 
	{ 
		int sum=0;
		for(int i=l+size,j=r+size;i<j;i>>=1,j>>=1)
		{
			if((i&1)==1) sum=merge(sum,array[i++]);
			if((j&1)==1) sum=merge(sum,array[--j]); 
		}
		return sum;
	}

	void update(int index,int value)
	{
		int ind=index+size;
		array[ind]=value; //op change
		for(int i=ind/2;i>0;i>>=1)
			merge(i);
	} 



}