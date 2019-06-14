package proj2018;
//import java.io.PrintStream;
import java.io.*;
import static java.lang.System.out;
import java.util.*;
public class Leb49 
{
	static PrintStream SOP = System.out;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		pratice5();
		SOP.println(1111);
		out.println(123);
	}
	public static void pratice1()
	{
		int sum=1;
		Scanner scn=new Scanner(System.in);
		System.out.print("請輸入N值:");
		int n=scn.nextInt();
		for(int i=n;i>=1;i--)
		{
			sum=sum*i;
		}
		System.out.print(n+"階為:"+sum);
		scn.close();
	}
	public static void pratice2() 
	{
		for(int i=1;i<3;i++)
		{
			for(int j=1;j<5;j++)
			{
				System.out.println(i+"*"+j+"="+j*i);
			}
		}
	}
	public static void pratice3()
	{
		int x=1,y=4;
		for(int i=1;i<3;i++)
		{
			for(int j=1;j<3;j++)
			{
				System.out.println(x+"*"+y+"="+x*y);
				x=x+1;
				y=y-1;
			}
		}
	}
	public static void pratice4()
	{
		for(int i=1;i<10;i++)
		{
			for(int j=1;j<10;j++)
			{
				System.out.println(i+"*"+j+"="+j*i);
			}
		}
	}
	public static void pratice5()
	{
		Scanner scn=new Scanner(System.in);
		System.out.print("請輸入N值:");
		int n=scn.nextInt();
		int sum=1;
		int count=0;
		for(int i=1;i<=n;i++)
		{
			sum=1;
			for(int j=1;j<=i;j++)
			{
				sum=sum*j;
			}
			count+=sum;
		}
		System.out.println(count);
	}
}
