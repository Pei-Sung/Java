package proj2018;

import java.io.*;
import java.util.*;
public class Apriori 
{
	public static String FilePath ="C:\\Users\\MMLAB\\Desktop\\Mushroom.txt";
	public static ArrayList<ArrayList<Integer>> DB=new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> C2=new ArrayList<ArrayList<Integer>>();
	public static ArrayList<Integer> F1=new ArrayList<Integer>();
	public static ArrayList<Integer> F1List=new ArrayList<Integer>();
	public static int gMaxItem;
	public static int gMinItem=Integer.MAX_VALUE;
	public static int gMaxLeng=0;
	public static int gcount=0;
	public static float gMinSC=0;
	public static int gNumFI=0;
	public static float min_conf=0;
	static long startTimestamp;
	static long endTimestamp;
	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		startTimestamp=System.currentTimeMillis();
		LoadDataBase(FilePath,DB);   //讀取資料
		Scanner scn =new Scanner(System.in);
		print("Please enter one number to set min_sup(最小支持度，例：若設定80%請輸入80)： ", true);   //輸入最小支持度
		float a=scn.nextFloat();
		gMinSC=(float) ((a*0.01)*gcount);
//		gMinSC = scn.nextFloat();
		
		print("Please enter one number to set min_conf(最小信賴度，例：若設定80%請輸入80)：", true);  //輸入最小關聯度
		min_conf = scn.nextFloat();
		int [] F1=new int[gMaxItem+1];
		GenF1(DB,F1);   //取長度為1的FI
		
		GenC2(F1List,C2);
//		showDB(C2);
		endTimestamp=System.currentTimeMillis();
		timecount(startTimestamp,endTimestamp);
	}
	
	public static void timecount(long startTimestamp,long endTimestamp)
	{
//		startTimestamp=System.currentTimeMillis();
//		endTimestamp=System.currentTimeMillis();
		System.out.println("Total time="+(endTimestamp-startTimestamp)+"ms");
	}
	
	public static void print(Object str, boolean ln){
		if(ln == true)
			System.out.println(str);
		else
			System.out.print(str);
	}
	
	public static void LoadDataBase(String FilePath,ArrayList<ArrayList<Integer>> DB) throws IOException
	{
		FileReader fr=new FileReader(FilePath);
		BufferedReader bfr =new BufferedReader(fr);
		String record;
		while((record=bfr.readLine())!=null)
		{
			String[] str=record.split(" ");
			ArrayList<Integer> t =new ArrayList<Integer>();
			for(int i=0;i<str.length;i++)
			{
				int item=Integer.parseInt(str[i]);
				t.add(item);
				gMaxItem=Math.max(gMaxItem, item);
				gMinItem=Math.min(gMinItem, item);
			}
			DB.add(t);
			gcount++;
		}
		System.out.println("總交易筆數:"+gcount);
		System.out.println("商品ID最大數:"+gMaxItem);
		System.out.println("商品ID最小數:"+gMinItem);
		bfr.close();
		fr.close();
	}
	public static void showDB(ArrayList<ArrayList<Integer>> DB)
	{
		for(int i=0;i<DB.size();i++)
		{
			System.out.print("[");
			for(int j=0;j<DB.get(i).size();j++)
			{
				System.out.print(DB.get(i).get(j)+" ");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	public static void GenF1(ArrayList<ArrayList<Integer>> DB,int F1[])
	{
		for(int i=0;i<DB.size();i++)
		{
			for(int j=0;j<DB.get(i).size();j++)
			{
				int v=DB.get(i).get(j);
				F1[v]++;
			}
		}
		print("-----單一商品出現頻率(F1)-----",true);
		for(int i=0;i<F1.length;i++)
		{
			if(F1[i]>=gMinSC )
			{
				System.out.println("{"+i+"}"+F1[i]);
				F1List.add(i);
				gNumFI++;
			}
		}
	}
	public static void GenC2(ArrayList<Integer>F1List,ArrayList<ArrayList<Integer>> C2)
	{
		int numC2=0;
		for(int i=0;i<F1List.size()-1;i++)
		{
			for(int j=i+1;j<F1List.size();j++)
			{
				ArrayList<Integer> c = new ArrayList<Integer>();
				
				c.add(F1List.get(i));
				c.add(F1List.get(j));
				
				C2.add(c);
				
				numC2++;
			}
		}
		
		CountCK(DB,C2);
	}
	public static boolean IsContain(ArrayList<Integer> c, ArrayList<Integer> t)
	{
		for(int i=0;i<c.size();i++)
		{
			if(t.contains(c.get(i))==false)
			{
				return false;
			}
		}
		return true;
	}
	public static void CountCK(ArrayList<ArrayList<Integer>> DB,ArrayList<ArrayList<Integer>> CK)
	{
		print("-----商品組合出現狀況-----",true);
		for(int i=0;i<CK.size();i++)
		{
			int SC = 0;
			
			for(int j=0;j<DB.size();j++)
			{
				if(IsContain(CK.get(i),DB.get(j))==true)
				{
					SC++;
				}
			}
			if(SC>=gMinSC)
			{
				gNumFI++;
		//*****show
				print("{"+C2.get(i).get(0)+", "+C2.get(i).get(1)+"}:"+SC,true);
			}
			else
			{
				CK.remove(i);
				i--;
			}
		}
	}
	
}
