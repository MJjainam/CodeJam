import java.util.*;
/**
https://www.codechef.com/IPC15AMR/problems/ASYA2
**/
public class AsyaAndBeautifulStrings
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int[] A= new int[n1];
		int[] B = new int[n2];
		int C = Integer.parseInt("11111111111111111111111111",2);
		for(int i=0;i<n1;i++)
		{
			String S = in.next();
			for(int j=0;j<S.length();j++)
			{
				//int[i][S.charAt(j)-'A'] = 1;
				A[i] |= 1<<S.charAt(j)-'A';  
			}

		}
		for(int i=0;i<n2;i++)
		{
			String S = in.next();

			for(int j=0;j<S.length();j++)
			{
				B[i] |= 1<<S.charAt(j)-'A';
			}

		}
		//System.out.println();
		//System.out.println("binary rep of : " +B[2] +"is " +Integer.toBinaryString(B[2]));
		int count= 0;
		for(int i=0;i<n1;i++)
		{
			for(int j=0;j<n2;j++)
			{
				if((A[i] | B[j]) == C)
				{
					count++;
					//System.out.println("i " +i +" "+"j " +j);
				}
			}
		}
		System.out.println(count);

	}
}