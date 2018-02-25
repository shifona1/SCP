import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        // your code goes here
        long c=0;
       // for(int i=0;i<s.length();i++)
         //   if(s.charAt(i)=='6'||s.charAt(i)=='0')
            //c++;
        int n=s.length();
        int[] cs=new int[n+1];
        //System.out.println(c);
        for(int i=1;i<=n;i++)
        	cs[i]=cs[i-1]+(s.charAt(i-1)-'0');
        int[] pos=new int[n];
        int k=0;
        for(int i=0;i<n;i++)
        	if((s.charAt(i)-'0')%2==0)
        		pos[k++]=i+1;
        for(int i=1;i<=s.length();i++)
        {
        	for(int l=0;l<k;l++)
        	{
           		int j=pos[l];
                if(j>=i)
        		if((cs[j]-cs[i-1])%3==0 )
        		{
        			//System.out.println(s.substring(i,j));
                    if((j-i+1)==1 && s.charAt(i-1)==0)
        			c++;
                    if((j-i+1)>1 && s.charAt(i-1)!=0)
                        c++;
        			
        		}
        	}
        }
        System.out.println(c);
    }
}
