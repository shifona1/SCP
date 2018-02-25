import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int r=in.nextInt();
		for(int i=0;i<r;i++) {
			int l=in.nextInt();
			String s=in.next();
			boolean lasthead=false;
			boolean valid=true;
			for(int j=0;j<l;j++)
			{	
				if(s.charAt(j)=='H')
					if(!lasthead)
					lasthead=true;
					else
					{
						valid=false;
						break;
					}
				else if(s.charAt(j)=='T' )
					if(lasthead)
					lasthead=false;
					else
					{
						valid=false;
						break;
					}


			}	
			if(valid&& !lasthead)
		System.out.println("Valid");
		else
			System.out.println("Invalid");
		}

	}
}