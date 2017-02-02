//https://www.hackerrank.com/challenges/crush
// Segment tree (easy)
import java.util.*;
public class crush
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i] = 0;
		}
		lazySegmentTree X = new lazySegmentTree(arr);
		for(int m=0;m<M;m++)
		{
			X.lazyUpdate(in.nextInt()-1,in.nextInt()-1,in.nextInt());
			
		}
		System.out.println(X.RangeQuery(0,arr.length-1));
	}
}
class lazySegmentTree
{
	int[] input;
	long[] segTree;
	long[] lazyTree;
	long[] output;
	static int counter;
	public lazySegmentTree(int[] input)
	{
		//createSegmentTree(input);
		this.input = input;
		int segTreeSize = (int)Math.pow(2,(int)Math.ceil(Math.log(input.length)/Math.log(2)))*2 -1;
		segTree = new long[segTreeSize];
		for(int i=0;i<segTreeSize;i++)
		{
			segTree[i] = 0;
		}
		createSegmentTree(0,input.length-1,0); //low,high,present
		lazyTree = new long[segTreeSize];


	}
	public void createSegmentTree(int low,int high,int present)
	{
		if(low==high)
		{
			segTree[present] = input[low]; 
		}
		else
		{
			int mid = (high + low)/2;
			createSegmentTree(low,mid,present*2+1);
			createSegmentTree(mid+1,high,present*2+2);
			//segTree[present] = Math.min(segTree[present*2+1],segTree[present*2+2]);  // minimum func 
			segTree[present] = Math.max(segTree[present*2+1],segTree[present*2+2]);

		}
	}
	public long RangeQuery(int low,int high)
	{
		return RangeQuery(0,input.length-1,low,high,0);
	}
	public long RangeQuery(int low,int high,int qlow,int qhigh,int present)
	{
		if(qhigh<low || qlow>high) //NO overlap
		{
			//return Integer.MAX_VALUE;   for min
			return Integer.MIN_VALUE;                  //for max
		}
		if(lazyTree[present] != 0)		 // This node needs to be updated 
    	{
        segTree[present] += lazyTree[present];            // Update it
        //segTree[present] = lazyTree
      	  if(low != high)
      	  {
     	       lazyTree[present*2+1] += lazyTree[present];         // Mark child as lazy
     	       lazyTree[present*2+2] += lazyTree[present];    // Mark child as lazy
    	    }
     	  lazyTree[present] = 0;                 // Reset it
    	   }
		if(low>=qlow && high<=qhigh) //full or over overlapping
		{
			return segTree[present];
		}
		  int mid = (low+high)/2;
        //return Math.min(minRangeQuery(low,mid,qlow,qhigh,present*2+1),minRangeQuery(mid+1,high,qlow,qhigh,present*2+2));
		return Math.max(RangeQuery(low,mid,qlow,qhigh,present*2+1),RangeQuery(mid+1,high,qlow,qhigh,present*2+2));


	}
	public void lazyUpdate(int low,int high,int x)
	{	
		lazyUpdate(0,input.length-1,low,high,0,x);
	}

	public void lazyUpdate(int low,int high,int qlow,int qhigh,int current,int val)
	{
		if(lazyTree[current] != 0)           //If the node is not updated.
    	{ 
        	// This node needs to be updated
        	segTree[current] += lazyTree[current];    // Update it
        	if(low != high)
        	{
            	lazyTree[current*2+1] += lazyTree[current];                  // Mark child as lazy
            	lazyTree[current*2+2] += lazyTree[current];                // Mark child as lazy
        	}
        	lazyTree[current] = 0;                                  // Reset it
    	}
    	if(qlow > high || qhigh < low)              // Current segment is not within range [l, r]
        {

        }
    	else if(qlow <= low && qhigh >= high)  // Segment is fully within range
    	{										
        	segTree[current] +=val;
        	if(high != low)            // Not leaf node
			{
            lazyTree[current*2+1] += val;
            lazyTree[current*2+2] += val;
        	}
        }
        else                             //segment is half in the range , half not.
        {	
    		int mid = (low + high) / 2;
    		lazyUpdate(low, mid, qlow, qhigh,current*2+1, val);        // Updating left child
    		lazyUpdate(mid+1,high,qlow,qhigh,current*2+2,val);   // Updating right child
    		segTree[current] = Math.max(segTree[current*2+1],segTree[current*2+2]);        // Updating root with max/sum value 
		}
	}
	
	public void getBackUpdatedValues()
	{
		counter=0;
		output = new long[input.length];
		getBackUpdatedValues(0,input.length-1,0);
	}
	public void getBackUpdatedValues(int low,int high,int current)
	{
		if(low==high)
		{
			output[counter] = segTree[current];
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
