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
		int[] c=new int[n+1];
		for(int i=1;i<=n;i++)
			c[i]=c[i-1]^a[i-1];
		int ways=0;
		for(int i=1;i<=n;i++)
		{
			if(c[i]%2==0)
				ways++;
		}
		// for(int k:c)
  //       System.out.println(k);
		// for(int i=1;i<=n;i++)
		// {
		// 	for(int j=i;j<=n;j++)
		// 	{
  //               int k=0;
  //               if(i!=j)
  //               k=(c[n]^(c[j]^c[i]));
  //               else
  //                   k=c[n]^c[i];
  //               System.out.println(" i="+i+" j="+j+" ans="+k);
		// 		if(k==0)
		// 			ways++;
// }
		// 	}
		// }

		System.out.println(ways);
	}
}