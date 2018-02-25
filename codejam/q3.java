import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++) {
			int d=in.nextInt();
			int n=in.nextInt();
			char[][] a=new char[d][d];
			for(int j=0;j<d;j++)
				for(int k=0;k<d;k++)
					a[j][k]='I';

			for(int j=0;j<d;j+=2)
			{

				for(int k=0;k<d-2;k+=3)
				{
					if(n<=0)break;
					a[j][k]='I';
					a[j][k+1]='/';
					a[j][k+2]='O';
					n--;
				}
			}
		System.out.println("Case #"+(i+1)+": ");
		for(int j=0;j<d;j++){
					for(int k=0;k<d;k++)
						System.out.print(a[j][k]);
					System.out.println();
				}
			
		}
	}
}