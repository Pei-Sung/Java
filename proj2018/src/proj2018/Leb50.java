package proj2018;
import java.io.*;
import java.util.*;
public class Leb50 
{
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("C:\\Users\\MMLAB\\Desktop\\Test DB\\DB_ItemID.txt");
		BufferedReader bfr = new BufferedReader(fr);
		String record;
		String[] str;
		ArrayList<String> ary=new ArrayList<String>();
		ArrayList<Integer> array=new ArrayList<Integer>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> mylist=new ArrayList<ArrayList<Integer>>();
		float count=0;
		while((record=bfr.readLine())!=null)
		{
			str=record.split(" ");
			for(int i=0;i<str.length;i++)
			{
				if(ary.indexOf(str[i])==-1)
				{
					ary.add(str[i]);
				}
				array.add(Integer.valueOf(str[i]));
			}
			count++;
//			System.out.print("\n");
		}
		System.out.println(ary);
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
//		for(int i=0;i<max;i++)
//		{
//			System.out.println("��"+(i+1)+"�Ӱӫ~�A�ʶR����:"+a[i]+"��");
//		}
		System.out.println("�п�Jmin_sup_count(%):");
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
		System.out.println("�j��min_sup_count���ӫ~�s��:"+list);
		for(int i=0;i<list.size();i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				ArrayList<Integer> list2=new ArrayList<Integer>();
				list2.add(list.get(i));
				list2.add(list.get(j));
				mylist.add(list2);
			}
		}
		System.out.println("�i�઺�զX:"+mylist);
		ArrayList<C2> lookk=new ArrayList<C2>();
		for(int i=0;i<mylist.size();i++)
		{
			C2 look = new C2(mylist.get(i).get(0),mylist.get(i).get(1));
			lookk.add(look);
		}
		bfr.close();
		fr.close();
	}
	
}
class C2
{
	int data1=0;
	int data2=0;
	public C2(int x ,int y)
	{
		data1=x;data2=y;
	}
}
