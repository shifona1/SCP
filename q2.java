import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int temp=n;
		if(n==0)
		{
			System.out.println(0);
			System.exit(0);
		}
		int c=0,z=0;
		int dig = 0;
		while(temp>0 && z<k)
		{	
			dig++;
			if(temp%10==0)
				z++;
			else 
				c++;
			temp/=10;
		}
		if(temp==0)
			c=dig-1;
		System.out.println(c);
	}
}