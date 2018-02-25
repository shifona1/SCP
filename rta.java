import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) 
		{
			a[i]=in.nextInt();
		}
		int c=0;
		int i=0;
		while(i<n)
		{
			i=i+a[i]+1;
			c++;
		}
		System.out.println(c);
	}
}