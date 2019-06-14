package proj2018;
public class pratice1130timecount 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		long startTimestamp;
		long endTimestamp;
		startTimestamp=System.currentTimeMillis();
//		for(int i=0;i<9999999;i++)
//		{
//			System.out.println(i);
//		}
		count(9999999);
		endTimestamp=System.currentTimeMillis();
		System.out.println("Total time="+(endTimestamp-startTimestamp)+"ms");
	}
	public static void count(int a)
	{
		for(int i=0;i<a;i++)
		{
			System.out.println(i);
		}
	}
}
