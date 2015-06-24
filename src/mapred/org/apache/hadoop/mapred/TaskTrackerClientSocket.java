package org.apache.hadoop.mapred;
import java.net.*;
import java.io.*;

public class TaskTrackerClientSocket{
	public Socket client;
	
	public Socket getClient() {
		return client;
	}
	public void setClient(Socket client) {
		this.client = client;
	}
	
	public TaskTrackerClientSocket()
	{
	}
	
	public String ClientServiceUp(int port)throws Exception{
		client = new Socket(InetAddress.getLocalHost(),port);
		String result = null;
		BufferedReader in = 
				new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter out = 
				new PrintWriter(client.getOutputStream());
		
		while(true)
		{
			String str = in.readLine();
			if(str.length()>0)
			{
				result = str;
				break;
			}
		}
//		in.close();
//		out.close();
		client.close();
		return result;
	}
}