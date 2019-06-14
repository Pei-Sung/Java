package proj2018;

public class pratice1130mxamemory 
{
	public static double MaxMemory=0;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		double current_memory=
		((double)(double)(Runtime.getRuntime().totalMemory()/1024)/1024)-
		((double)(double)(Runtime.getRuntime().freeMemory()/1024)/1024);
		if(current_memory>MaxMemory)
		{
			MaxMemory=current_memory;
		}
		System.out.println("Maximum Memory:"+(int)(MaxMemory*100)/100.0+"MB");
	}

}
