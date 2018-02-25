import java.util.*;

class Solution
{
			static int c=0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++) {
			c=0;
			int f=in.nextInt();
			int s=in.nextInt();
			int[][] a=new int[f][2];
			//ArrayList<Integer> a=new ArrayList<Integer>();
			int[] count=new int[s+1];
			for(int j=0;j<f;j++)
			{
				int frst=in.nextInt();
				int sec=in.nextInt();
				
				if(!contains(a,frst,sec))
					{
						a[c][0]=frst;
						a[c][1]=sec;
						if(frst==sec) {
							count[frst]--;
						}
						c++;
					}


			}
			for(int j=0;j<c;j++)
			{
				count[a[j][0]]++;

				count[a[j][1]]++;
			}
			int max=Integer.MIN_VALUE;
			for(int j=0;j<=s;j++)
			{
				if(count[j]>max)
					max=count[j];
			}
		System.out.println("Case #"+(i+1)+": "+max);
		}
	}

	static boolean contains(int[][] a,int f,int s)
	{
		for(int i=0;i<c;i++)
			if(a[i][0]==f && a[i][1]==s)
				return true;

		return false;	
	}
}