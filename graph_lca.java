
class Graph 
{
	ArrayList<ArrayList<Pair<Integer,Integer>>> a=new ArrayList<ArrayList<Pair<Integer,Integer>>>();
	int[] flag;
	int[] marked;
	int[] distance;
	int[] parent;
	int[] depth;
	int counter=0;
	int LG = 30;
	int[][] parents;
	TreeSet<Pair<Integer,Integer>> pq;
	// int[] distances;
	 void creategraph(int n)
	{
		a.clear();		
		flag=new int[n];
		distance=new int[n];
		Arrays.fill(distance,Integer.MAX_VALUE);
		for(int i=0;i<n;i++)
		{
			a.add(new ArrayList<Pair<Integer,Integer>>());
		}
		pq=new TreeSet<Pair<Integer,Integer>>();
		parent=new int[n];
		parents = new int[LG][n];
		for (int i=0;i<LG ;i++ ) {
			Arrays.fill(parents[i],-1);
		}
	}

	 void addEdge(int u,int v,int cost)
	{
		a.get(u).add(new Pair<Integer,Integer>(v,cost));
	}


	 void dfs(int s,int p)
	{
		if(flag[s]!=0) return;
		else
		flag[s]=counter;
		parent[s]=p;
		depth[s]=depth[p]+1;
		ArrayList<Pair<Integer,Integer>> temp=a.get(s);
		for(int i=0;i<temp.size();i++)
			{
				dfs(temp.get(i).a,s);
			}
	}

	void dijkshtra(int s)
	{
		Pair<Integer,Integer> current;
		marked = new int[a.size()];
		while(pq.size()>0) {
			current = pq.first();
			pq.pollFirst();
			if(marked[current.b]>0)
				continue;
			marked[current.b]=1;

			ArrayList<Pair<Integer,Integer>> arr=a.get(current.b);
			for(Pair<Integer,Integer> k:arr)
			{
				if(distance[current.b]+k.b<distance[k.a])
				{
					distance[k.a]=distance[current.b]+k.b;
					pq.add(new Pair<Integer,Integer>(distance[k.a],k.a));
				
				}
			}			

		}
	}

	int lca(int n1,int n2)
	{

		int h1=depth[n1];
		int h2=depth[n2];
		if(h2<h1) // swap(n1,n2)
		{
			int t=n2;
			n2=n1;
			n1=t;
		}
		n2=kthParent(n2,h2-h1);
		for(int i=LG-1;i>=0;i--)
		{
			int p1=parents[i][n1];
			int p2=parents[i][n2];
			if(p1!=p2)
			{
				n1=p1;
				n2=p2;
			}

		}
		return parents[1][n1];

	}

	int kthParent(int n,int k)
	{
		for (int i=0;k>0 && n>=0 ;i++,k>>=1 ) {
			if((k&1)>0)
				n=parents[i][n];
		}
		return n;
	}

	void build_lca(int root)
	{
		parents[0]=parent;
		// parents[i][n] using parents[i-1][x]
		for (int i=1; i<LG;i++ )
		for(int n=0;n<parent.length;n++)
		 {
			int pi_1=parents[i-1][n];
			if(pi_1>=0)
			parents[i][n]=parents[i-1][pi_1];
		}

	} 

}