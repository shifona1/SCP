import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int g=0;g<t;g++) {
			int n=in.nextInt();
			int d=in.nextInt();
			long[] a=new long[n];
			long sum=0;
			long x=0;
			for(int i=0;i<n;i++)
			{
				a[i]=in.nextLong();
				sum+=a[i];
			}
			if(sum%n==0)
			x=sum/n;
			else
			{
				System.out.println(-1);
				continue;
			}

			long steps=0;
			boolean flag=true;
			for(int i=0;i<d;i++)
			{
			long[] b=new long[n/d+2];
				int j=i;
				int k=0;
				b[k++]=a[j];
				long sum2=0;
				while(j+d<n)
				{
					b[k++]=a[j+d];
					j+=d;
					// sum2+=b[k];
				}
				if(j==i)
				{
					for(int l=j;l<d;l++)
					{
						if(a[l]!=x)
							flag=false;
					}
					break;
				}
				else
				{
					long steps2=convert(b,x,k);
					// System.out.println("steps="+steps2);
					if(steps2!=-1)
						steps+=steps2;
					else
					{
						flag=false;
						break;
					}
				}
			}
			if(flag)
				System.out.println(steps);
			else
				System.out.println(-1);
		}
	}

	static void assertion(boolean istrue) {
		if(!istrue) {
			throw new RuntimeException("Assert Fail!");
		}
	}

	static long convert(long[] b,long x,int l){
		for(int i=0;i<l;i++)
			b[i]-=x;

		return converttozero(b,l);
	}

	static long converttozero(long[] b,int l)
	{
		long steps=0;
		for(int i=0;i<l-1;i++)
		{
			b[i+1]+=b[i];
			steps+=Math.abs(b[i]);
			// b[i]=;
		}
		if(b[l-1]==0) return steps;
		//assertion(b[l-1]==0);
		else return -1;
	} 
}