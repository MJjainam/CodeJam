import java.util.*;
import java.math.*;

public class NotSoRandom {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(); //Test cases
		for(int t=0;t<T;t++)
		{
			int N=in.nextInt();
			Integer X=in.nextInt();    //initial input number 
			int K=in.nextInt();	   // Fixed number 
			BigDecimal A= new BigDecimal(in.nextInt()*0.01);  //Converting percentages to decimals
			BigDecimal B=new BigDecimal(in.nextInt()*0.01);
			BigDecimal C=new BigDecimal(in.nextInt()*0.01);
			

			HashMap<Integer,BigDecimal> Output = new HashMap<Integer,BigDecimal>(); // Memoization
			Output.put(X,new BigDecimal(1));   
			HashMap<Integer,BigDecimal> TEMP; //Temporary HashMap -acts like an use and throw Hashmap for "Output" HashMap
			for(int i=1;i<=N;i++)
			{
				TEMP = new HashMap<Integer,BigDecimal>();
				Integer KEY;
				BigDecimal VALUE;
				for(Map.Entry<Integer,BigDecimal> entry : Output.entrySet())
				{
					KEY = entry.getKey();
					VALUE = entry.getValue();
					if(TEMP.containsKey(KEY & K))
					{
						TEMP.put(KEY & K,(TEMP.get(KEY & K).add(VALUE.multiply(A))).setScale(15,RoundingMode.FLOOR));
						//Here use of setScale is important to limit the precision of the decimal part of probability.
						//If not done , would take a lot of time computing the unneccesary precision.
					}
					else 
					{
						TEMP.put(KEY & K, (VALUE.multiply(A)).setScale(15, RoundingMode.FLOOR));
					}
					if(TEMP.containsKey(KEY | K))
					{
						TEMP.put(KEY | K,   (TEMP.get(KEY|K).add(VALUE.multiply(B)) ).setScale(15,RoundingMode.FLOOR) );
					}
					else
					{
						TEMP.put(KEY | K, (VALUE.multiply(B)).setScale(15, RoundingMode.FLOOR));
					}
					if(TEMP.containsKey(KEY ^ K))
					{
						TEMP.put(KEY ^ K,   (TEMP.get(KEY ^ K).add(VALUE.multiply(C))).setScale(15,RoundingMode.FLOOR));
					}
					else
					{
						TEMP.put(KEY ^ K, (VALUE.multiply(C)).setScale(15, RoundingMode.FLOOR));
					}
					
				}
				Output = TEMP;  //Use and throw
			}
			double answer=0;
			for(Map.Entry<Integer,BigDecimal> entry : Output.entrySet())
			{
				answer += entry.getKey()*entry.getValue().doubleValue();   
			}
			System.out.println("Case #"+(t+1) +": " +new BigDecimal(answer).setScale(10,RoundingMode.CEILING));
			
			
		}
	}

}

