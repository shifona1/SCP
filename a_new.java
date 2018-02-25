import java.util.*;
import java.io.*;

public class Solution
// class Solution
{
	static BufferedReader br;
	static String nextIntBuffer[];
	static int nextIntBase;
	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	static String next() throws IOException {
		if(nextIntBase>=nextIntBuffer.length) {
			nextIntBase =0;
			nextIntBuffer = br.readLine().split(" ");
		}
		return nextIntBuffer[nextIntBase++];
	}


	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		nextIntBuffer = new String[0];

		String[] time=next().split(":");
		int hr=Integer.parseInt(time[0]);
		int min=Integer.parseInt(time[1]);
		int current=hr*60+min;
		int mini=-100;
		for(int i=hr;i<=23;i++) {
			String mins="";
			int new_min=0;
			if(i/10==0)
				mins=i+"0";
			else
				mins=(new StringBuilder(i+"")).reverse().toString();
			// System.out.println(mins);
			if(Integer.parseInt(mins)<=59)
				new_min=Integer.parseInt(mins)+i*60;
			if(new_min>=current){
							mini=new_min-current;
							break;}
		}
		if(mini<0)mini=24*60-current;
		System.out.println(mini);
	}
}