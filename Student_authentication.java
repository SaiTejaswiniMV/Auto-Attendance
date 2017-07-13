/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sai Tejaswini.M.V
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

import java.io.*;

public class Student_authentication {
    Scanner k=new Scanner(System.in);
  int count=0;
  	String csvFile = "Students.csv";
	BufferedReader br = null;
   BufferedWriter wr = null;
	String line = "";
	String cvsSplitBy = ",";
    Snode list=null;  
	int dd,ds,scs,wt,dml,usn; 
	int pdd=0;int pds=0;int pscs=0;int pwt=0;int pdml=0;


  public void insert()//reading data from .csv file and storing in the form of singly linked list 
  {
     try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {

		        // use comma as separator
			String[] values = line.split(cvsSplitBy);
            usn=Integer.parseInt(values[0]);//converting String to integer
          dd=Integer.parseInt(values[3]);
          ds=Integer.parseInt(values[4]);
          scs=Integer.parseInt(values[5]);
          wt=Integer.parseInt(values[6]);
          dml=Integer.parseInt(values[7]);
         
  
         
  
   Snode newnode=new Snode(usn,values[1],values[2],dd,ds,scs,wt,dml);//end insertion
   if(list==null)
     list=newnode;
   else
     {
      Snode temp=list;
      while(temp.next!=null)
      {
       temp=temp.next;
      }
      temp.next=newnode;
     }
	}
}
catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
public void display()//just to check (not used in code)
{
 Snode temp;
 if(list==null) System.out.println("Empty");
 else
 {
  temp=list;
  while(temp!=null)
  {
   System.out.println(temp.usn+"-->"+temp.password);
   temp=temp.next;
  }
 }
 }
 public String match(int n,String p)//password matching
 {
  String yes="matched";
  if(list==null)
   return "Empty";
  else
  {
   Snode temp=list;
   while(temp.next!=null && !(temp.usn==n) && !(temp.password.equals(p)))
   {
    temp=temp.next;
   }
     if((temp.password.equals(p))&& (temp.usn==n ) )
        yes="yes";
       else
         yes ="Not matched";
   }
    return yes;
   }
       
   void edit(int line,int word,String change)//editing values in the .csv file
	{
		try
		{
			String tname=csvFile;
			BufferedReader fin1=new BufferedReader(new FileReader(tname));
			String ch;
			int count=0,i=0;
			//lable-1
			while((ch=fin1.readLine())!=null)//to count the number of lines in the document
			{
				count++;
			}
			String []lwise=new String[count];
			fin1.close();/*fin1 as even when its fin and after having done fin.close() then too i cant use the same variable nextInt
			it says the variable already defined*/
			
			/*edit cant be done with only 1 fin as once lable-1 is executed, the pointer points at the end, there for to print again from first
			we need a new i/o variable*/
			BufferedReader fin=new BufferedReader(new FileReader(tname));
			while((ch=fin.readLine())!=null)
			{
				lwise[i]=ch;
				//System.out.println("line"+(i+1)+" : "+lwise[i]);
				i++;
			}
			String []rwise=lwise[line-1].split(",");
			
			
			rwise[word-1]=change;
			//reflecting change
			String newstr="";
			int see=0;
			for(int j=0;j<rwise.length;j++)
			{
				if(see==0)
					newstr=newstr+rwise[j];
				else
					newstr=newstr+","+rwise[j];
				see++;
			}
			lwise[line-1]=newstr;
			PrintWriter fout=new PrintWriter(new FileWriter(tname));
			for(int j=0;j<count;j++)
			{
				fout.println(lwise[j]);
			}
			fout.close();
			fin.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
			
	}
   int countLine()//counting number of lines in the file
	{
		int count=0;
		try
		{			
			String tname=csvFile;
			BufferedReader fin=new BufferedReader(new FileReader(tname));
			String ch;
			int i=0;
			while((ch=fin.readLine())!=null)
			{
				count++;
			}
			fin.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		return count;
	}
//updating attendance by 1
   void dd_update(int i)
   { 
     int c=countLine();
     pdd+=1;
     String s1 = Integer.toString(pdd);//converting int to String
     
       edit(i,4,s1);
     
     }
    void ds_update(int i)
   { 
     int c=countLine();
     pds+=1;
     String s2 = Integer.toString(pds);
    
           edit(i,5,s2);
    
     }

void scs_update(int i)
   { 
     int c=countLine();
     pscs+=1;
     String s3 = Integer.toString(pscs);
     
       edit(i,6,s3);
     }    

void wt_update(int i)
   { 
     int c=countLine();
     pwt+=1;
     String s4 = Integer.toString(pwt);

     
     
       edit(i,7,s4);
     
}
 void dml_update(int i)
   { 
          int c=countLine();
          pdml+=1;
          String s5 = Integer.toString(pdml);
     
     
       edit(i,8,s5);
     
     }
    
    String seeLine(int line)//for viewing a single line in the file(this method is used only when student is logged in) 
	{
		String ret=null;
		try
		{
			String tname=csvFile;
			BufferedReader fin1=new BufferedReader(new FileReader(tname));
			String ch;
			int count=0,i=0;
			//lable-1
			while((ch=fin1.readLine())!=null)//to count the number of lines in the document
			{
				count++;
			}
			String []lwise=new String[count];
			fin1.close();/*fin1 as even when its fin and after having done fin.close() then too i cant use the same variable nextInt
			it says the variable already defined*/
			
			/*edit cant be done with only 1 fin as once lable-1 is executed, the pointer points at the end, there for to print again from first
			we need a new i/o variable*/
			BufferedReader fin=new BufferedReader(new FileReader(tname));
			while((ch=fin.readLine())!=null)
			{
				lwise[i]=ch;
				//System.out.println("line"+(i+1)+" : "+lwise[i]);
				i++;
			}
			ret=lwise[line-1];
			
			fin.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		return ret;
	}
}
