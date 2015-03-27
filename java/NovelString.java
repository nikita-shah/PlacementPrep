import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class NovelString {

	public static void main(String[] args)
	{

		//take input from file in java
		try
		{
			File ip_file = new File("novel.in");	
			File op_file = new File("novel.out");
			op_file.createNewFile();
			FileReader fr = new FileReader(ip_file);
			FileWriter fw = new FileWriter(op_file);
			BufferedReader brip = new BufferedReader(fr);
			BufferedWriter brop =  new BufferedWriter(fw);



			String line;
			while(!(line=brip.readLine()).equals("$$"))
			{
				
				if(checkNovel(line))
				{
					
					brop.write(line + " is a novel string"+"\n");
					brop.newLine();
				}
				else
				{
				brop.write(line+ " is not a novel string"+"\n");
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

	private static boolean checkNovel(String line) {
		// TODO Auto-generated method stub
		System.out.println("new string");
		int k=0;
		Boolean duplicateFound=false;

		int str_size = line.length();
		for(int span=1;span<=str_size-2 && !duplicateFound;span++)
		{

			ArrayList<String> sb=new ArrayList<String>();
			for(int start_index=0;start_index<=str_size-1-span;start_index++)		
			{

				sb.add(line.charAt(start_index)+""+line.charAt(start_index+span));				
			//	System.out.println(sb);
				
					if(checkDuplicates(sb))
					{   duplicateFound = true;
					k=span-1;
					break;
					}
				
			}

		}
		
		return !duplicateFound;
	}

	private static boolean checkDuplicates(ArrayList<String> doublets) {
		// TODO Auto-generated method stub
		/*
		String newlyAdded = doublets.substring(doublets.length()-2);
		String intermediate = doublets.substring(0, doublets.length()-2);
		if(intermediate.contains(newlyAdded))
		{
			System.out.println("String failed here  ");
			System.out.println("last two : "+newlyAdded);
		    System.out.println("comapred with : "+intermediate);
			return true;
		}
			return false;
		 */
		if(doublets.size()>=2)
		{
		for(String s : doublets.subList(0, doublets.size()-2))
		{
			/*System.out.println("sublist :" +doublets.subList(0, doublets.size()-2));
			System.out.println("latest string :"+doublets.get(doublets.size()-1) );*/
			System.out.println("compare "+s);
			System.out.println(doublets.get(doublets.size()-1));
			if(s.equalsIgnoreCase(doublets.get(doublets.size()-1)))
			{
				return true;
			}
		}
		}
		else
		{
			if(doublets.get(0).equals(doublets.get(1)))
				return true;
				return false;		
		}
		return false;
	}




}
