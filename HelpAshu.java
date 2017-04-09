import java.util.*;
/* https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/practice-problems/algorithm/help-ashu-1/

*/
public class HelpAshu
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] input =  new int[N];
		for(int i=0;i<N;i++)
		{
			input[i] = in.nextInt()%2;
		}
		SegmentTree X = new SegmentTree(input);
		int Q = in.nextInt();
		//X.printOutput();
		for(int t=0;t<Q;t++)
		{
			switch(in.nextInt())
			{
				case 0: X.updateSegmentTree(in.nextInt()-1,in.nextInt()%2);/*X.printOutput();*/break;
				case 1: System.out.println(X.evenQuery(in.nextInt()-1,in.nextInt()-1)); break;
				case 2: System.out.println(X.oddQuery(in.nextInt()-1,in.nextInt()-1));break;

			}

		}
		



	}
}
class SegmentTree
{
	int[] input;
	int[] output;
	int[] updatedArray;
	static int counter;
	public SegmentTree(int[] input)
	{
		//createSegmentTree(input);
		this.input = input;
		int outputSize = (int)Math.pow(2,(int)Math.ceil(Math.log(input.length)/Math.log(2)))*2 -1;
		//System.out.println("Output size is " +outputSize);
		output = new int[outputSize];
		for(int i=0;i<outputSize;i++)
		{
			output[i] =100	;
		}
		createSegmentTree(0,input.length-1,0); //low,high,present
	}
	public void createSegmentTree(int low,int high,int present)
	{
		if(low==high)
		{
			output[present] = input[low]; 
		}
		else
		{
			int mid = (high + low)/2;
			createSegmentTree(low,mid,present*2+1);
			createSegmentTree(mid+1,high,present*2+2);
			output[present] = output[present*2+1] + output[present*2+2];  // minimum func 

		}
	}
	public void updateSegmentTree(int pos,int x)
	{
		updateSegmentTree(0,input.length-1,0,pos,x);
	}
	public void updateSegmentTree(int low,int high,int current,int pos,int x)
	{
		if(low==high)
		{

			output[current] = x%2;
			//System.out.println("low is: " +low +" high is:  " +high);
			//System.out.println("updated the index: " +current +"to: " +output[current]);
		}
		else
		{
			int mid = (low+high)/2;
			if(pos<=mid)
			{
			//System.out.println("in if , low is: " +low +" high is:  " +high);
			updateSegmentTree(low,mid,current*2+1,pos,x);
			}
			else
			{
			//	System.out.println("in else , low is: " +low +" high is:  " +high);
			updateSegmentTree(mid+1,high,current*2+2,pos,x);
			}
			output[current] = output[current*2+1]  + output[current*2+2];
			//System.out.println("updated the index: " +current +"to: " +output[current]);
		}

	}
	public int evenQuery(int low,int high)
	{
		return evenQuery(0,input.length-1,low,high,0);
	}
	public int evenQuery(int low,int high,int qlow,int qhigh,int present)
	{
		if(qhigh<low || qlow>high) //NO overlap
		{
			return 0;
		}
		if(low>=qlow && high<=qhigh) //full or over overlapping
		{
			return (high-low+1 - output[present]); 
		}
		  int mid = (low+high)/2;
        	return evenQuery(low,mid,qlow,qhigh,present*2+1) + evenQuery(mid+1,high,qlow,qhigh,present*2+2);
		
	}

	public int oddQuery(int low,int high)
	{
		return oddQuery(0,input.length-1,low,high,0);
	}
	public int oddQuery(int low,int high,int qlow,int qhigh,int present)
	{
		if(qhigh<low || qlow>high) //NO overlap
		{
			return 0;
		}
		if(low>=qlow && high<=qhigh) //full or over overlapping
		{
			return output[present];
		}
		  int mid = (low+high)/2;
        	return oddQuery(low,mid,qlow,qhigh,present*2+1) + oddQuery(mid+1,high,qlow,qhigh,present*2+2);

	}
	public void printOutput()
	{
		for(int i=0;i<input.length;i++)
		{
			System.out.print(updatedArray[i] +" ");
		}
		System.out.println();
	}
	public void getBackUpdatedValues()
	{
		counter=0;
		updatedArray = new int[input.length];
		getBackUpdatedValues(0,input.length-1,0);
		printOutput();
	}
	public void getBackUpdatedValues(int low,int high,int current)
	{
		if(low==high)
		{
			updatedArray[counter] = output[current];
			counter++;
		}
		else
		{
			int mid=(high+low)/2;
			getBackUpdatedValues(low,mid,current*2+1);
			getBackUpdatedValues(mid+1,high,current*2+2);
		}

	}
	
	
}
