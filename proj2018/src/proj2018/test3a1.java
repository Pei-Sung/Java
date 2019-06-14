package proj2018;
import java.io.*;
import java.util.*;
public class test3a1 
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("C:\\Users\\MMLAB\\Desktop\\Test DB\\SensorDB.csv");
		BufferedReader br = new BufferedReader(fr);
		int counter=0;
		float accX=0,gyroX=0;
		String[] x;
		ArrayList<String> array=new ArrayList<>();
		ArrayList<Float> array1=new ArrayList<>();
		while(br.ready()){
			x = br.readLine().split(",|\"");
			if(counter>0){
				accX+=Float.parseFloat(x[7]);
				gyroX+=Float.parseFloat(x[16]);
				array.add(x[7]);
				array1.add(Float.parseFloat(x[7]));
//				array2.add(Integer.parseInt(x[16]));
//				array1.add(Integer.valueOf(x[7]));
			}
			counter++;
		}
//		System.out.println(" ");
//		System.out.println(array);
		System.out.println(array1);
		float amax=0;
		for(int i=0;i<array1.size();i++)
		{
			if(i==0)
			{
				amax=array1.get(0);
			}
			if(array1.get(i)>amax)
			{
				amax=array1.get(i);
			}
		}
		System.out.println(amax);
		System.out.println("accX的平均值為："+accX/counter);
		System.out.println("gyroX的平均值為："+gyroX/counter);
		fr.close();
		br.close();
	}

}
