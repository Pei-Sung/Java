package proj2018;
import java.io.*;
public class test3 
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String fp="C:\\Users\\MMLAB\\Desktop\\Test DB\\SensorDB.csv";
		FileReader fr =new FileReader(fp);
		BufferedReader bfr=new BufferedReader(fr);
		String record=null;
		float[]a=new float[3500];
		int count=0;
		float sum1=0,sum=0;
		float amax = 0,amin=0,gmax=0,gmin=0;
		while((record=bfr.readLine())!=null)
		{
			String[] x=record.split(",|\"");
//			System.out.println(x[7]+" "+x[16]);
			if(count==1)
			{
				 amax=Float.parseFloat(x[7]);
				 amin=Float.parseFloat(x[7]);
				 gmax=Float.parseFloat(x[16]);
				 gmin=Float.parseFloat(x[16]);
//				System.out.println(record);
				Float aa=Float.parseFloat(x[7]);
				Float bb=Float.parseFloat(x[16]);
				sum+=aa;
				sum1+=bb;
				
			}
			if(count>1)
			{
				if(Float.parseFloat(x[7])>amax)
				{
					amax=Float.parseFloat(x[7]);
				}
				if(Float.parseFloat(x[7])<amin)
				{
					amin=Float.parseFloat(x[7]);
				}
				if(Float.parseFloat(x[16])>gmax)
				{
					gmax=Float.parseFloat(x[16]);
				}
				if(Float.parseFloat(x[16])<gmin)
				{
					gmin=Float.parseFloat(x[16]);
				}
//				System.out.println(record);
				Float aa=Float.parseFloat(x[7]);
				Float bb=Float.parseFloat(x[16]);
				sum+=aa;
				sum1+=bb;
				
			}
			count++;
		}
		System.out.println(amax);
		System.out.println(amin);
		System.out.println(gmax);
		System.out.println(gmin);
		System.out.println(" ");
		System.out.println("accX¥­§¡:"+(sum/count));
		System.out.println("gyroX¥­§¡:"+(sum1/count));
		bfr.close();
		fr.close();
	}

}
