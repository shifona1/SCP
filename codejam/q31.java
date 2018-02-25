import java.util.*;

class Solution
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++) {
			int d=in.nextInt();
			int n=287-in.nextInt();
			 char[][] a=new char[d][d];
			// for(int j=0;j<d;j++)
			// 	for(int k=0;k<d;k++)
			// 		a[j][k]='I';

			for(int j=0;j<d;j++)
			{

				for(int k=0;k<12;k+=4)
				{
					a[j][k]='I';
					a[j][k+1]='/';
					a[j][k+2]='O';
					a[j][k+3]='/';
				}
				a[j][12]='I';
				a[j][13]='/';
				a[j][14]='O';
						

			}
			int[][] counter=new int[d][d];
			for(int j=0;j<d;j++)
				for(int k=0;k<d;k++)
				{
					int[][] b=getList(a,j,k);
					for(int l=0;l<b.length;l++)
					{
						if(b[l][0]>=0 && b[l][0]<d )
							if(b[l][1]>=0 && b[l][1]<d )
							if(b[l][2]>=0 && b[l][2]<d )
							if(b[l][3]>=0 && b[l][3]<d )
								counter[j][k]++;
							//System.out.println(j+","+k+"\t"+l+"   "+b[l][0]+","+b[l][1]+" "+b[l][2]+","+b[l][3]);
					}
				}

				while(n>0) {
					int mj=-1,mk=-1,mv=0;
					for(int j=0;j<d;j++)
				for(int k=0;k<d;k++)
					if(counter[j][k]>mv && counter[j][k]<=n) {
						mv=counter[j][k];
						mj=j;mk=k;
					}

					if(mj==-1)
						System.exit(1);
					int[][] b=getList(a,mj,mk);
					int ass = 0;
					for(int l=0;l<b.length;l++)
					{
						if(b[l][0]>=0 && b[l][0]<d )
							if(b[l][1]>=0 && b[l][1]<d )
							if(b[l][2]>=0 && b[l][2]<d )
							if(b[l][3]>=0 && b[l][3]<d )
								{
									counter[b[l][0]][b[l][1]]--;
									counter[b[l][2]][b[l][3]]--;
									ass+=2;
								}
							//System.out.println(j+","+k+"\t"+l+"   "+b[l][0]+","+b[l][1]+" "+b[l][2]+","+b[l][3]);
					}
					if(ass!=mv)
						;//System.exit(2);
					counter[mj][mk]=0;
					if(a[mj][mk]=='/') {
						a[mj][mk]='I';
					} else a[mj][mk]='/';
					n-=mv;
				}

		System.out.println("Case #"+(i+1)+": ");
		for(int j=0;j<d;j++){
					for(int k=0;k<d;k++)
						System.out.print(a[j][k]);
					System.out.println();
				}
			
		}
	}

	static int[][] getList(char a[][],int i, int j)
	{
		int[][] b=new int[6][4];


		for(int k=0;k<6;k++)
			for(int l=0;l<4;l++)
				b[k][l]=-1;
		char c=a[i][j];
		if(a[i][j]=='I'||a[i][j]=='O')
		{
			b[0][0]=i;
			b[0][1]=j-1;
			b[0][2]=i;
			b[0][3]=j-2;

			b[1][0]=i;
			b[1][1]=j+1;
			b[1][2]=i;
			b[1][3]=j+2;


			b[2][0]=i-1;
			b[2][1]=j-1;
			b[2][2]=i-2;
			b[2][3]=j-2;


			b[3][0]=i+1;
			b[3][1]=j+1;
			b[3][2]=i+2;
			b[3][3]=j+2;
		

			b[4][0]=i-1;
			b[4][1]=j+1;
			b[4][2]=i-2;
			b[4][3]=j+2;

			b[5][0]=i+1;
			b[5][1]=j-1;
			b[5][2]=i+2;
			b[5][3]=j-2;

		}
		if(a[i][j]=='/')
		{
			b[0][0]=i;
			b[0][1]=j+1;
			b[0][2]=i;
			b[0][3]=j-1;



			b[1][0]=i-1;
			b[1][1]=j+1;
			b[1][2]=i+1;
			b[1][3]=j-1;


			b[2][0]=i+1;
			b[2][1]=j+1;
			b[2][2]=i-1;
			b[2][3]=j-1;

		}
		return b;
	}
}