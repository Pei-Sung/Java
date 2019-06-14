package proj2018;

import java.io.*;
import java.util.*;
public class testpratice 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("C:\\Users\\MMLAB\\Desktop\\Test DB\\DB_ItemID.txt");
		BufferedReader br=new BufferedReader(fr);
		String record;
		String[] str;
		ArrayList<Integer> array=new ArrayList<>();
		ArrayList<String> ary=new ArrayList<>();
		ArrayList<ArrayList<Integer>> data=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> mylist=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> mylist1=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		float count=0;
		while((record=br.readLine())!=null)
		{
			str=record.split(" ");
			ArrayList<Integer> ary1=new ArrayList<>();
			for(int i=0;i<str.length;i++)
			{
				ary1.add(Integer.parseInt(str[i]));
//				System.out.print(str[i]);
				if(ary.indexOf(str[i])==-1)
				{
					ary.add(str[i]);
				}
				array.add(Integer.parseInt(str[i]));
			}
			data.add(ary1);
//			System.out.println("");
			count++;
		}
		
		System.out.println("總交易次數:"+count);
//		System.out.println(array);
//		System.out.println(ary);
		int max=0;
		for(int i=0;i<array.size();i++)
		{
			if(max<array.get(i))
			{
				max=array.get(i);
			}
		}
		int[] a=new int[max];
		for(int i=0;i<array.size();i++)
		{
			a[array.get(i)-1]++;
		}
//		int min=9999999;
//		for(int i=0;i<max;i++)
//		{
//			System.out.println("第"+(i+1)+"個商品，購買次數:"+a[i]+"次");
//			if(a[i]<min)
//			{
//				min=a[i];
//			}
//		}
		System.out.println("請輸入min_sup_count(%):");
		Scanner scn=new Scanner(System.in);
		float sup=scn.nextFloat();
		float minsup=(float)((sup*0.01)*count);
		System.out.println(minsup);
		for(int i=0;i<max;i++)
		{
			if(a[i]>minsup)
			{
				list.add(i+1);
			}
		}
		int[] a1=new int[max];
		ArrayList<Integer> array1=new ArrayList<>();
		System.out.println("大於min_sup且長度為1的相關商品組合:");
		for(int i=0;i<max;i++)
		{
//			System.out.println(a[i]);
			if(a[i]>=minsup)
			{
				a1[i]=a[i];
			}
			if(a1[i]!=0)
			{
				System.out.println("{"+(i+1)+"}，購買次數:"+a1[i]+"次");
				array1.add(i+1);
			}
		}
		for(int i=0;i<array1.size();i++)
		{
			for(int j=i+1;j<array1.size();j++)
			{
				ArrayList<Integer> list2=new ArrayList<Integer>();
				list2.add(array1.get(i));
				list2.add(array1.get(j));
				mylist.add(list2);
			}
		}
		System.out.println(data);
		System.out.println("長度為2的候選商品:");
		System.out.println(mylist);
		ArrayList<Integer> C2 = new ArrayList<Integer>();
		ArrayList<Integer> C2time = new ArrayList<Integer>();
		for(int i=0;i<data.size();i++)
		{
			for(int k=0;k<mylist.size();k++)
			{
				if(i==0)
				{
					C2time.add(0);
				}
				if(data.get(i).indexOf(mylist.get(k).get(0))>-1 && data.get(i).indexOf(mylist.get(k).get(1))>-1)
				{
					C2time.set(k,C2time.get(k)+1);		
				}
			}	
		}
		for(int k=0;k<C2time.size();k++)
		{
			if(C2time.get(k)>=minsup)
			{
				C2.add(k);
			}
		}
		for(int k=0;k<C2time.size();k++)
		{
			if(C2time.get(k)<minsup)
			{
				C2time.remove(k);
				k=k-1;
			}
		}
		System.out.println("大於min_sup且長度為2的相關商品組合:");
		for(int k=0;k<C2.size();k++)
		{
			System.out.println(mylist.get(C2.get(k))+" "+C2time.get(k)+"次");
		}
		System.out.println("長度為3的候選商品:");
		System.out.println(mylist1);
		ArrayList<Integer> C3 = new ArrayList<Integer>();
		ArrayList<Integer> C3time = new ArrayList<Integer>();
		for(int i=0;i<array1.size();i++)
		{
			for(int j=i+1;j<array1.size();j++)
			{
				for(int k=j+1;k<array1.size();k++)
				{
					ArrayList<Integer> list3=new ArrayList<Integer>();
					list3.add(array1.get(i));
					list3.add(array1.get(j));
					list3.add(array1.get(k));
					mylist1.add(list3);
				}
			}
		}
		for(int i=0;i<array.size();i++)
		{
			for(int j=0;j<array.size();j++)
			{
				
			}
		}
//		System.out.println("大於min_sup且長度為3的商品組合:");
		scn.close();
		br.close();
		fr.close();
	}
//	public static void search(ArrayList<ArrayList<Integer>> array,ArrayList<ArrayList<Integer>> rraay)
//	{
//		
//	}

}