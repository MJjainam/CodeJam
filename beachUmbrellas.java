import java.util.*;
//https://www.facebook.com/hackercup/problem/1760870734198100/
public class beachUmbrellas
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		final long MOD = 1000000007;
		for(int t=0;t<T;t++)
		{

			int N = in.nextInt();
			int[] arr = new int[N];
			int M = in.nextInt();
			int[] mark = new int[4001];

			for(int n=0;n<N;n++)
			{
				arr[n] = in.nextInt();
			}
			if(N!=1)
			{
				for(int i=0;i<N;i++)
				{
					for(int j=i+1;j<N;j++)
					{
						mark[arr[i]+arr[j]]++;
					}
				}
				long totalR=0;

				for(int n=0;n<N;n++)
				{
					totalR= (totalR + (2*arr[n])%MOD)%MOD;
				//arr[n] = 2*arr[n];
				}

				long ans = 0;
				for(int i=0;i<mark.length;i++)
				{
					
					if(mark[i]>=1)
					{
						//
						long k = (M-1)+i-totalR;
						if(k>=0)
						{
						//System.out.println("K " +k);
						long product = 1;
						boolean markN = false;
						boolean markN1 = false;
						for(int j=1;j<=N;j++)
						{
							product = product*(k+j);
							assert product>=0 : "product is less than zero";
							if(product%N==0 && markN==false)
							{
								product=product/N;
								markN = true;
							}
							if(product%(N-1)==0 && markN1==false)
							{
								product = product/(N-1);
								markN1 = true;
							}
							product = product%MOD;
						}
						assert markN1==true && markN==true : "Exception";
						//assert markN==false : "asd";
						product = product*2*mark[i];
						assert product>=0 : "product is less than zero 2";
						product = product%MOD;
						ans=(ans + product)%MOD;
						}

					}
					


				}
				System.out.println("Case #" +(t+1) +": " +ans);

			}

			else
			{
				System.out.println("Case #" +(t+1) +": " +M);
			
			}
		}
	}
}