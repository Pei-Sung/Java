package proj2018;
import java.io.*;
public class test5try 
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		FileReader fr =new FileReader("C:\\Users\\MMLAB\\Desktop\\Test DB\\DB_ItemID.txt");
		BufferedReader bfr=new BufferedReader(fr);
		String record;
		int a;
		int[] recorda=new int[10];
		while((record=bfr.readLine())!=null)
		{
			a=Integer.parseInt(record);
		}
		bfr.close();
		fr.close();
	}

}
