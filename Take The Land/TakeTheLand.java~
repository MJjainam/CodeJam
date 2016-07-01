//package compete;


/*prerequisites - Knowledge on basic classical dynamic problems . 
If not known can be learned from the book "competitive programming 3" Section 3.5. Very helpful for programming contests.  */


import java.util.*;
class TakeTheLand {
	
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		while(in.hasNext())
		{
			
			int M=in.nextInt(); //Take inputs
			int N=in.nextInt();
			int[][] Land = new int[M][N];
			if(M==0 && N==0) break;
			for(int i=0;i<M;i++)
			{
				for(int j=0;j<N;j++)
					Land[i][j]=in.nextInt();
					
			}
			
			
		
		int maxLandArea=0;
		int LandArea;
		for(int left=0;left<N;left++)  //Imagine the land like a matrix. We here try all the possible rectangles of maximum number of zeroes
		{
			int[] temp1=new int[M];
			for(int right=left;right<N;right++)
			{
				for(int k=0;k<M;k++)
					temp1[k]+=Land[k][right];
				LandArea=kadane(temp1)*(right-left+1);  //kadane method here finds the length of the maximum contionous zeroes in the array temp.(right-left+1) gives the width of the matrix considred in the loop.
				if(LandArea>maxLandArea)
				{
					maxLandArea=LandArea;
				}
			}
				
		
		}
		System.out.println(maxLandArea);
		}
	}
	public static int kadane(int[] temp1)  //Google "1D max array range sum using kadane's method".You will get a little insight on the method used.It's quite simple if you read that.
	{
		int countContinousZeroes=0;
		int countLongestContinousZeroes=0;
		
		for(int i=0;i<temp1.length;i++)
		{
			if(temp1[i]==0)
				countContinousZeroes++;
			else 
			{
				if(countLongestContinousZeroes<countContinousZeroes)
					countLongestContinousZeroes=countContinousZeroes;
				countContinousZeroes=0;
			}
		}
		if(countLongestContinousZeroes<countContinousZeroes)
			countLongestContinousZeroes=countContinousZeroes;
		return countLongestContinousZeroes;
	}
	
	

}
