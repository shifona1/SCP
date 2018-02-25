import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int test=0;test<t;test++) {
			int n=in.nextInt();
			int k=in.nextInt();
			int[] a=new int[n+1];
			long[][] dp=new long[n+1][n+1];
			long or=0;
			for(int i=1;i<=n;i++)
			{
				a[i]=in.nextInt();
//				or|=a[i];
			}

			for(int i=1;i<=n;i++)
			{
				dp[i][1]=dp[i-1][1]|a[i];
				// System.out.println(dp[i][1]);
			}
			
			for(int j=1;j<=k;j++)	// partition
				for(int i=1;i<=n;i++)
				{
					 or=0;
					for(int m=i-1;m>0;m--)
					{
						if(m>=j-1)
						{
							or=or|a[m+1];
							dp[i][j]=Math.max(dp[m][j-1]+or,dp[i][j]);
						
						}
						else
							break;
					}
				}

		System.out.println(dp[n][k]);
		}
	}
}