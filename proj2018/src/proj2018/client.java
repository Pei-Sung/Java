package proj2018;
import java.net.*;

import org.omg.CORBA.portable.OutputStream;
public class client 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try
		{
			ServerSocket svs = new ServerSocket(45); // open server port 45
			
			Socket s = svs.accept(); // clientºÝ  S
			System.out.println(s.getInetAddress());  // S IP
			
			OutputStream out = (OutputStream) s.getOutputStream();  // ¶Ç°e°T®§
			
			String q="Hello~";
			out.write(q.getBytes());
			
			out.close();
			s.close();
			
		}
		catch(Exception e)
		{
			System.out.println("ERROR!");
		}
	}

}
