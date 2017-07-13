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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Teacher_authentication {
     Scanner k=new Scanner(System.in);
  int count=0;
  	String csvFile = "Teachers.csv";
	BufferedReader br = null;
   BufferedWriter wr = null;
	String line = "";
	String cvsSplitBy = ",";
    Tnode list=null;  
	Student_authentication st; 
  public void insert()
  {
    try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {

		        // use comma as separator
			String[] values = line.split(cvsSplitBy);
         
  
   Tnode newnode=new Tnode(values[0],values[1],values[2]);
   if(list==null)
     list=newnode;
   else
     {
      newnode.next=list;
      list=newnode;
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
public void display()
{
 Tnode temp;
 if(list==null) System.out.println("Empty");
 else
 {
  temp=list;
  while(temp!=null)
  {
   System.out.println(temp.name+"-->"+temp.subject);
   temp=temp.next;
  }
 }
 }
 public String match(String n,String p)
 {
  String yes="matched";
  if(list==null)
   return "Empty";
  else
  {
   Tnode temp=list;
   while(temp.next!=null && !(temp.name.equals(n)) && !(temp.password.equals(p)))
   {
    temp=temp.next;
   }       if(temp.password.equals(p)&&temp.name.equals(n) )
        yes="matched";
       else
         yes ="Not matched";
      }
    
    return yes;
   }
   
   void dd()
   {
    st.dd_update();
   }
    void scs()
   {
    st.scs_update();
   }
    void ds()
   {
    st.ds_update();
   }
   void wt()
   {
    st.wt_update();
   }
    void dml()
   {
    st.dml_update();
   }
   
    public void update(String n)
 {
  //String yes="matched";
  if(list==null)
   System.out.println("Empty file");
  else
  {
   Tnode temp=list;
   while(temp.next!=null && !(temp.name.equals(n)))
   {
    temp=temp.next;
   }
   if(temp.name.equals(n))
     {
       if(temp.subject.equals("ddco"))
       {
        dd();   
       }
       else if(temp.subject.equals("ds"))
       {
        ds();
       }
       
       else if(temp.subject.equals("scs"))
       {
        scs();
       }
       else if(temp.subject.equals("wt"))
       {
        wt();
       }
       else if(temp.subject.equals("dml"))
       {
        dml();
        }
       }
       else
       System.out.println("Not accessable");
       }
      }

    void match(JTextField name, JPasswordField pwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
