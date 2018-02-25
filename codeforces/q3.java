import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		long n=in.nextLong();
		long m=in.nextLong();
		if(m>n)
		{
			System.out.println(n);
			System.exit(0);
		}

		double q=8*(n-m)+1;
		if(q>=0)
			q=Math.sqrt(q);
		else{
			//System.out.println(q);
				System.exit(-1);
			}
			//System.out.println(q);
		double i=(2*m-1+q)/2;
		System.out.println((long)Math.ceil(i));
	}
}