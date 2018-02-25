import java.util.*;

class Main
{
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{			
			int[] salary=new int[3];
			for(int j=0;j<3;j++)
				salary[j]=in.nextInt();
			Arrays.sort(salary);
			System.out.println("Case "+(i+1)+": "+salary[1]);
		}
	}
}