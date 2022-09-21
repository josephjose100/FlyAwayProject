package com.first_project;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Fileinput {

	static int choice;
	public static void main(String[] args) {
        
		List<String> list=new ArrayList<String>();
		String name2;
		String name3;
		String name4;
		String path="E:\\files\\";
		Scanner sc=new Scanner(System.in);
		File f=null;
		System.out.println("         WELCOME");
		System.out.println("         -------");
		System.out.println(" ");
		System.out.println("PROJECT NAME   : LockedMe.com");
		System.out.println("DEVELOPER NAME : Joseph Jose");
		System.out.println("EMAIL ID       : josephjose100@gmail.com");
		do {
			System.out.println("  ");
			System.out.println("Press 1 ->to retrieve names of files in ascending order");
			System.out.println("Press 2 ->to add a new file");
			System.out.println("Press 3 ->to delete a file");
			System.out.println("Press 4 ->to search for a file");
			System.out.println("Press 5 ->to exit the program");
			System.out.println("Enter your choice from->[1,2,3,4,5]");
		    choice=sc.nextInt();
		    switch(choice) {
		    
		  case 1:
			  
		    	f=new File(path);                                                     //to sort names in ascending order
				File[] file_list1=f.listFiles();
				for(File f1:file_list1) {
					list.add(f1.getName());
				}
				Collections.sort(list);
				System.out.println("The names of files in ascending order is ");
				System.out.println(list);  
				list.clear();
		        break;
		    
		  case 2:
		
		    	System.out.println("Enter the file name");                             //to create a file
				name2=sc.next();
				try{
					f=new File(path+name2);                                           
				    f.createNewFile();
				    System.out.println("File: "+name2+" created at "+f.getAbsolutePath());
				}
				catch(Exception e) {
					e.printStackTrace();
			     }
		    	break;
		    	
		  case 3:
		    	
		    	System.out.println("Enter the file you want to delete");                    //to delete a file
		    	name3=sc.next();
		    		f=new File(path+name3);
		    		if(f.exists())
		    		{
		    			f.delete();
		    		    System.out.println("File "+name3+" deleted from "+f.getAbsolutePath());
		    		}
		    		else {
		    			System.out.println("File is not present");
		    		}	    	
		    	
		    	break;
		    	
		  case 4:
			  
		    	int flag=0;
		     	System.out.println("Enter he name of the file you want to search");          //to search a file
		    	name4=sc.next();
		        f=new File(path);
		    	File[] file_list=f.listFiles();
		    	for(File f1:file_list)
		    		if(name4.equals(f1.getName())) {
		    			System.out.println("File found");
		    			flag=1;
		    			break;
		    		}
		    	if(flag==0)
		    	{
		    		System.out.println("File not found");
		    	}	    	
		    	
		    	break;
		    	
	      case 5:
		    	                                                                          //to exit the program
		    	System.exit(0);
		    	break;
		    	
		    	
		 default:System.out.println("Invalid option");
		    	
		}
	}while(choice>0);
	
  }
}
