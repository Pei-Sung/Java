package proj2018;
import java.io.*;
import java.util.*;
import java.*;

public class exe {
	static String FilePath ="C:\\Users\\MMLAB\\Desktop\\Mushroom.txt";
	static float min_sup = 0, min_conf = 0;						//最小支持度/最小信賴度
	static int allBuyNum = 0, goodsClassNum = 0, dataNum = 0, goodsNumFI = 0, maxItem = 0, minItem = 999999999;
	static ArrayList<ArrayList<Integer>> DataBase = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> F1List = new ArrayList<Integer>();
	static ArrayList<ArrayList<Integer>> C2 = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		LoadDatabase();
		
		Scanner input = new Scanner(System.in);
		
		print("Please enter one number to set min_sup(最小支持度，例：若設定80%請輸入80)： ", true);//enter min
		min_sup = input.nextFloat();
		
		print("Please enter one number to set min_conf(最小信賴度，例：若設定80%請輸入80)：", true);
		min_conf = input.nextFloat();
		
		int[] F1 = new int[maxItem+1];
		GenF1(DataBase,F1);
		
		GenC2(F1List, C2);
	}
	
	public static void print(Object str, boolean ln){
		if(ln == true)
			System.out.println(str);
		else
			System.out.print(str);
	}
	
	public static void LoadDatabase() throws IOException{
		FileReader fr = new FileReader(FilePath);
		BufferedReader bfr = new BufferedReader(fr);
		
		String record;
		
		while((record=bfr.readLine())!=null){
			String[] recordSplit = record.split(" ");
			ArrayList<Integer> singleShopping = new ArrayList<Integer>();
			
			for(int i=0;i<recordSplit.length;i++){
				int Item = Integer.parseInt(recordSplit[i]);
				singleShopping.add(Item);
				allBuyNum++;
				maxItem = Math.max(maxItem, Item);
				minItem = Math.min(minItem, Item);
			}
			dataNum++;
			DataBase.add(singleShopping);
		}
		bfr.close();
		fr.close();
	}
	
	public static void show(){
		
			print("交易狀況如下",true);
			for(int i=0;i<DataBase.size();i++){
				for(int j=0;j<DataBase.get(i).size();j++){
					print(DataBase.get(i).get(j)+" ",false);
				}
				print("",true);
			}
			print("資料筆數："+dataNum,true);
	}
	
	
	public static void GenF1(ArrayList<ArrayList<Integer>> DB, int F1[]){
		
		for(int i=0;i<DB.size();i++){
			for(int j=0;j<DB.get(i).size();j++){
				int n = DB.get(i).get(j);
				
				F1[n]++;
			}
		}
	//*****show
		print("-----單一商品出現頻率(F1)-----",true);
		for(int i=0;i<F1.length;i++){
			if(F1[i] >= min_sup){
				print("{"+i+"}:"+F1[i],true);
				F1List.add(i);
				goodsNumFI++;
			}
		}
	}
	
	public static void GenC2(ArrayList<Integer> F1List, ArrayList<ArrayList<Integer>> C2){
		int numC2 = 0;
		
		for(int i=0;i<F1List.size()-1;i++){
			for(int j=i+1;j<F1List.size();j++){
				ArrayList<Integer> c = new ArrayList<Integer>();
				
				c.add(F1List.get(i));
				c.add(F1List.get(j));
				
				C2.add(c);
				
				numC2++;
			}
		}
		
		CountCK(DataBase,C2);

		
	}
	
	public static void CountCK(ArrayList<ArrayList<Integer>> DB, ArrayList<ArrayList<Integer>> CK){
		print("-----商品組合出現狀況-----",true);
		for(int i=0;i<CK.size();i++){
			int SC = 0;
			
			for(int j=0;j<DB.size();j++){
				if(IsContain(CK.get(i),DB.get(j))==true){
					SC++;
				}
			}
			if(SC>=min_sup){
				goodsNumFI++;
		//*****show
				print("{"+C2.get(i).get(0)+", "+C2.get(i).get(1)+"}:"+SC,true);
			}
			else{
				CK.remove(i);
				i--;
			}
		}
	}
	
	public static boolean IsContain(ArrayList<Integer> c, ArrayList<Integer> t){
		for(int i=0;i<c.size();i++){
			if(t.contains(c.get(i))==false){
				return false;
			}
		}
		return true;
	}
	
	public static void XX(ArrayList<ArrayList<Integer>> FI,ArrayList<ArrayList<Integer>>CK){
		int L = FI.get(0).size();
		
		for(int i=0;i<FI.size()-1;i++){
			for(int j=i+1;j<FI.size();j++){
				int count = 0;
				
				for(int k=0;k<L-1;k++){
					if(FI.get(i).get(k)==FI.get(j).get(k)){
						count++;
					}
					else{
						break;
					}
					
					if(count ==L-1){
						ArrayList<Integer> c = new ArrayList<Integer>(FI.get(i));
						c.add(FI.get(j).get(L-1));
						CK.add(c);
					}
				}
			}
		}
	}
}
