import java.util.*;

public class centre_of_mass
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int T=in.nextInt();                     
		for(int t=0;t<T;t++)
		{
			int N=in.nextInt();
			double x=0,y=0,z=0,dx=0,dy=0,dz=0; /* initializing the variables (x,y,z) and(dx,dy,dz). dx ,dy and dz are variables for velocities */				
			for(int i=0;i<N;i++)				
			{
			//In this for loop we are summing all the x-coordinate , y-coordinate ,z-co-ordinate of all the particles and storing in x,y,z ...Similarly we are summing up the velocities (dx,dy,dz) of all the particles and storing it in dx,dy,dz.
			
			x+=in.nextDouble();       
			y+=in.nextDouble();
			z+=in.nextDouble();
			dx+=in.nextDouble();
			dy+=in.nextDouble();
			dz+=in.nextDouble();
			
		
		}	
		x=x/N;    //The next six lines finds the position and velocities of centre of mass           
		y=y/N;
		z=z/N;
		dx=dx/N;
		dy=dy/N;
		dz=dz/N;
		
		double ans;
		double coef;
		//please see this video to understand the later part of the code
		//		https://www.youtube.com/watch?v=9wznbg_aKOo
		// The second method to find the distance of the point from a 3D line is used in this code
		if(dx==0 && dy==0 && dz==0)
		{
		//If the velocity of the center of mass is zero then the distance between origin and (x,y,z) can be the only possible distance.
		//Time for that to happen is zero
			ans=dist(x,y,z);
			coef=0;
			System.out.printf("Case #%d: %.8f %.8f\n",(t+1),ans,coef);  
			
		}
		else  //If the center of mass is moving....
		{
		//coef is nothing but 't' in the video .
		//coincidentally it also tells the time .
		
			coef=-(x*dx + y*dy + z*dz)/dist(dx,dy,dz)/dist(dx,dy,dz);
			if(coef<=0)  //if particle is moving away from the person (origin) coef will be less than zero
			{
				
				ans=dist(x,y,z);
				coef=0;
				System.out.printf("Case #%d: %.8f %.8f\n",(t+1),ans,coef);
				
				
			}
			else
			{
			
			//if particle is moving towards the origin , finding the co-ordinates of the point nearest to the origin.
				double x1=x+(dx*coef);
				double y1=y+(dy*coef);
				double z1=z+(dz*coef);
				ans=dist(x1,y1,z1);		
				System.out.printf("Case #%d: %.8f %.8f\n",(t+1),ans,coef);

				/*System.out.println(ans);
				System.out.println(coef);*/

			}

		}
		}
		
	}
	
	public static double dist(double a,double b,double c)
	{
		//Simple function to return the distance between point (a,b,c) to origin.
		return Math.sqrt((a*a)+(b*b)+(c*c));
	}
}
