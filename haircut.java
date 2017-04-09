//https://code.google.com/codejam/contest/4224486/dashboard#s=p1
import java.util.*;
class haircut {
	public static int arr[] = new int[1001];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int temp = t;//in.nextInt();
		while(temp--!=0) {
			int b = in.nextInt();
			long n = in.nextInt();
			for(int i=0;i<b;i++) {
				arr[i] = in.nextInt();
			}
			
			System.out.println("Case #"+(t-temp)+": "+ans(b,n));
		}
		in.close(); 
	}
	public static int ans(int b,long n) {
		long time = binary(b,n,0,(long)Math.pow(10,15)+100);
		
		long t[] = finished(b,time);
		long x = n-(t[0]+t[1]);
		for(int i=0;i<b;i++) {
			if(time%arr[i]==0)
			{
				x--;
				if(x==0)
					return (i+1);
			}
		}
		return -1;
	}
	public static long binary(int b,long target,long low,long high) {
		//if(low>high) return -1;
		//assert 1!=1:"one is indeed equal to one";
		assert low<=high :"low is not smaller than high";
		long mid = low+high;
		mid/=2;
		long t1[] = finished(b,mid);
		long t2[] = finished(b,mid+1);
		if(((t1[0]+t1[1])<target)&&((t2[0]+t2[1])>=target))
			return mid;
		else {
			if(t1[0]+t1[1]>=target)
				return binary(b,target,low,mid-1);
			else
				return binary(b,target,mid+1,high);
		}
	}
	public static long[] finished(int b,long t) {
		long count = 0;
		long ongoing=0;
		long ret[] = new long[2];
		for(int i=0;i<b;i++) {
			count+=t/arr[i];
			if(t%arr[i]!=0) ongoing++;
		}
		ret[0] = count;
		ret[1] = ongoing;
		return ret;
	}

}