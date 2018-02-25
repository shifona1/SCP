import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) {
		// Scanner in=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{

			int t=Integer.parseInt(br.readLine());
			for(int g=0;g<t;g++) {
				// int n=in.nextInt();
				// int m=in.nextInt();
				String input[]=br.readLine().split(" ");
				int n=Integer.parseInt(input[0]);
				int m=Integer.parseInt(input[1]);
				int[] minsalary=new int[n];
				input=br.readLine().split(" ");
				for(int i=0;i<n;i++)
					minsalary[i]=Integer.parseInt(input[i]);
				int[] offeredsal = new int[m];
				int[] maxjoboffers=new int[m];


				for(int i=0;i<m;i++)
				{
					input=br.readLine().split(" ");
					offeredsal[i]=Integer.parseInt(input[0]);
					maxjoboffers[i]=Integer.parseInt(input[1]);
				}

				int[][] qual = new int[n][m];
				for(int i=0;i<n;i++)
				{
					String s=br.readLine();
					for(int j=0;j<m;j++)
					{
						qual[i][j]=s.charAt(j)-'0';
					}
				}
					
					int[] joboffers=new int[m];
				for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
				{
					if(qual[i][j]==1)
						joboffers[j]++;
				}	

				int[] studentsalary=new int[n];
				int[] companyjob=new int[m];

				for(int i=0;i<n;i++)
				{
					int maxsalary=Integer.MIN_VALUE;
					int company=0;
					for(int j=0;j<m;j++)
					{
						if(qual[i][j]==1)
						{
							if(companyjob[j]<maxjoboffers[j])
							{
								if(maxsalary<offeredsal[j])
									{
										maxsalary=offeredsal[j];
										company=j;
									}
							}
						}
					}
					if(maxsalary>0 && maxsalary>=minsalary[i])
					{
						studentsalary[i]=maxsalary;
						companyjob[company]++;
					}


				}	 

				int students_employed=0,company_notemployed=0;
				long total=0;
				for(int i=0;i<n;i++)
				{
					if(studentsalary[i]!=0)
						students_employed++;
					total+=studentsalary[i];
				}
				for(int i=0;i<m;i++)
				{
					if(companyjob[i]==0)
						company_notemployed++;
				}
			System.out.println(students_employed+" "+total+" "+company_notemployed);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}