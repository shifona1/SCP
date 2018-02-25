import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int s=in.nextInt();
		for(int i=0;i<s;i++) 
		{
			int n=in.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++)
				a[j]=in.nextInt();

			if(n%2==0 || a[0]!=1)
			{
				System.out.println("no");
			}
			else
			{
				if(a[0]==1)
				{
					if(!inc(a) || !dec(a))
						System.out.println("no");
					else
						System.out.println("yes");
				}

			}
		}
		// System.out.println("Case #"+(t+1)+": ");
	}

	static boolean inc(int[] a)
	{
		int n=a.length;
		for(int j=1;j<=n/2;j++)
						if(a[j]!=a[j-1]+1)
						{
							return false;
						}
		return true;				
	}

	static boolean dec(int[] a)
	{
		int n=a.length;
		for(int j=n/2+1;j<n;j++)
						if(a[j]!=a[j-1]-1)
						{
							return false;
						}
		return true;				
	}
}