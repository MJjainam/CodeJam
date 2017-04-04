import java.util.*;
/* https://www.hackerrank.com/challenges/bear-and-steady-gene*/
public class Solution
{
	public static void main(String[] args)
	{
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			String S = in.next();
			solver X = new solver(S);
			X.solve();
	}
}
class solver
{
	int G=0,C=0,A=0,T=0;
	int n;
	int g=0,c=0,a=0,t=0;
	String S;

	int minL = Integer.MAX_VALUE;
	public solver(String S)
	{
		n=S.length();
		this.S = S;
		int counta =0;
		int countg = 0;
		int countc = 0;
		int countt = 0;
		for(int i=0;i<S.length();i++)
		{
				switch(S.charAt(i))
				{
				case 'G' : countg++;break;
				case 'C' : countc++;break;
				case 'T' :countt++;break;
				case 'A' : counta++;break;
				default: System.out.println("erorr");break;
				}
	
		}
		int level = n/4;
		if(countg - level >0) this.G = countg-level;
		if(counta - level >0) this.A = counta-level;
		if(countc - level >0) this.C = countc-level;
		if(countt - level >0) this.T = countt-level;
		//System.out.println(A);
		
	}
	public void solve()
	{
		if(this.G==0&&this.C==0&&this.T==0&&this.A==0)
		{
			System.out.println(0);
			
		}
		else
		{
			int i = -1;
			int j = -1;
			//boolean flag =true;
			while(j!=n)
			{
				//System.out.println("insde while");
				do
				{
					j++;
					if(j==n) break;
				}while(!update(S.charAt(j)));
				while(j!=n && delete(S.charAt(++i)));
					if(j!=n && minL > j-i+1)minL = j-i+1;
			}
			System.out.println(minL);
		}
	}
	public boolean update(char temp)
	{
		switch(temp)
		{
			case 'G' : g++;break;
			case 'C' : c++;break;
			case 'T' :t++;break;
			case 'A' : a++;break;
			default: System.out.println("erorr");break;
		}
		if(g>=G&&c>=C&&t>=T&&a>=A)
			return true;
		else return false;
	}
	public boolean delete(char X)
	{
	switch(X)
		{
			case 'G' : g--;break;
			case 'C' : c--;break;
			case 'T' :t--;break;
			case 'A' : a--;break;
			default: System.out.println("erorr");break;
		}
		if(g>=G&&c>=C&&t>=T&&a>=A)
			return true;
		else return false;
		
	
	}
	
}
