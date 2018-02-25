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
	static String next() throws IOException {
		if(nextIntBase>=nextIntBuffer.length) {
			nextIntBase =0;
			nextIntBuffer = br.readLine().split(" ");
		}
		return nextIntBuffer[nextIntBase++];
	}

	// N M, where M in numbe of quries
	// followed bt M  lines
	// a b x, add x from a to b index
	// print arr[0] to arr[N]

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];
		int n=nextInt();
		int m=nextInt();
		int[] arr=new int[n+1];
		for(int i=0;i<m;i++) {
			int a=nextInt();
			int b=nextInt();
			int x=nextInt();
			arr[a]+=x;
			arr[b+1]-=x;			
		}

		int[] cum=new int[n+1];
		cum[0]=arr[0];
		for(int i=1;i<n+1;i++)
		{
			cum[i]=arr[i]+cum[i-1];
		}
		for (int i:cum)
		System.out.println(i+" ");
	}
}