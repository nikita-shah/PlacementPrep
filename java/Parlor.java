import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Parlor {
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			File ip_file = new File("parlor.in");	
			File op_file = new File("parlor.out");
			op_file.createNewFile();
			FileReader fr = new FileReader(ip_file);
			FileWriter fw = new FileWriter(op_file);
			BufferedReader brip = new BufferedReader(fr);
			BufferedWriter brop =  new BufferedWriter(fw);



			String line;
			while(!(line=brip.readLine()).equals("0"))
			{

				count = parlor(line);
				if(count==0)
				{
					brop.write("All customers serviced.");
					brop.newLine();
				}
				else
				{
					brop.write(count+" customer(s) walked away.");
					brop.newLine();

				}
			}	

			brop.close();
			fw.close();
			brip.close();
			fr.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}


	}

	private static int parlor(String line) {
		// TODO Auto-generated method stub

		String[]input = line.split(" ");
		int parlor_size= Integer.parseInt(input[0]);
		String customerLog=input[1];

		ArrayList<String>service = new ArrayList<String>();		
		ArrayList<String>walkedAway= new ArrayList<String>();

		for(int i=0;i<customerLog.length();i++)
		{
			//an incoming character
			//check in walked away ,if present skip current


			if(walkedAway.contains(customerLog.charAt(i)+""))
			{continue;}
			else
			{
				if(service.contains(customerLog.charAt(i)+""))
				{
					service.remove(customerLog.charAt(i)+"");
				}
				else
				{
					if(!isFull(service,parlor_size))
					{
						service.add(customerLog.charAt(i)+"");
					}
					else
					{
						walkedAway.add(customerLog.charAt(i)+"");
					}
				}
			}

		}

		return walkedAway.size();
	}

	private static boolean isFull(ArrayList<String> service,int parlor_size)
	{
		if(service.size()==parlor_size)
			return true;
		return false;

	}
   
	


}
