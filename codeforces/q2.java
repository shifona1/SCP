import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][] ch=new int[n][2];
		for(int i=0;i<n;i++) {
			ch[i][0]=in.nextInt();			
			ch[i][1]=in.nextInt();
		}
		int m=in.nextInt();
		int[][] pc=new int[m][2];
		for(int i=0;i<m;i++) {
			pc[i][0]=in.nextInt();			
			pc[i][1]=in.nextInt();
		}
		int index=getMax(ch,n);
		//Arrays.sort(pc);
		long max=Integer.MIN_VALUE;
		for(int i=0;i<m;i++)
		{	
			max=Math.max(max,(ch[index][0]-pc[i][1]));
			//System.out.println(max);
		}
		index=getMin(ch,n);
		for(int i=0;i<m;i++)
		{	
			max=Math.max(max,(pc[i][0]-ch[index][1]));
			//System.out.println(max);
		}


		if(max<0) System.out.println(0);
		else System.out.println(max);
	}

	static int getMax(int[][] a,int n)
	{
		int max=Integer.MIN_VALUE;
		int ind=0;
		for(int i=0;i<n;i++)
		{
			if(max<a[i][0])
			{
				ind=i;
				max=a[i][0];
			}
		 }
		// System.out.println("index= "+ind);
		return ind;
	}

	static int getMin(int[][] a,int n)
	{
		int min=Integer.MAX_VALUE;
		int ind=0;
		for(int i=0;i<n;i++)
		{
			if(min>a[i][1])
			{
				ind=i;
				min=a[i][1];
			}
		 }
		// System.out.println("index= "+ind);
		return ind;
	}
}