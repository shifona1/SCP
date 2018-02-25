import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
		}
		int[] b=new int[n];
		for(int i=0;i<n;i++)
		{
			b[i]=max(b,i-2)+a[i];	
		}
		System.out.println(max(b,n));
	}

	static int max(int[] b,int i)
	{
		if(i<0)
			return 0;
		else 
		{
			for(int j=0;j<=i;j++)
            {
                if(b[j]>max)
                max=b[j];
            }
             return max;
		}


	}
}