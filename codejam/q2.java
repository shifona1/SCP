import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++) {
			int n=in.nextInt();
			double[] p=new double[2*n];
			for(int j=0;j<2*n;j++)
				p[j]=in.nextDouble();
			Arrays.sort(p);
			double ans=1;
			for(int j=0;j<n;j++)
				ans=ans*(1-p[j]*p[2*n-j-1]);
			
		System.out.println("Case #"+(i+1)+": "+ans);

		}
	}
}