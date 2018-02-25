static class HashPalindrome
	{
		String s;
		long[] hashvalues;
		static long p=127;
		static long pi;
		public HashPalindrome(String str)
		{
			s=str;
			pi=pow(p,mod-2);
			hashvalues=new int[s.length()];
			this.setHash();
		}

		long getHash(int start,int end)
		{
			if(start==0) return hashvalues[end];
			else
				return ((hashvalues[end]-hashvalues[start-1])*pow(pi,start))%mod;
		}

		void setHash()
		{
			hashvalues[0]=s.charAt(0);
			long m=1; 
			for(int i=1;i<s.length();i++)
			{
				m=(m*p)%mod;
				hashvalues[i]=(hashvalues[i-1]+s.charAt(i)*m)%mod;
			}
		}
	}

static int getPalindnumber(int start,int end)
	{
		// System.out.print(start+" "+end+" ");
		if(start>end) return 0;
		if(start==end) return 1;
		if(a[start][end]!=0) return a[start][end]-1;
		boolean pali=palindrome(start,end);
		// System.out.println(pali);

		if(pali)
		{
			a[start][end]=1+ 1+ getPalindnumber(start,start+(end-start-1)/2);
			return a[start][end]-1;
		}
		return ( a[start][end] = 1)-1;
	}
	