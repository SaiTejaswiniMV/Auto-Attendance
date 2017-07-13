/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sai Tejaswini.M.V
 */
import java.util.*;
public class Client {
     public static void main(String []args)
 {
  Teacher_authentication t=new Teacher_authentication();
  Student_authentication s=new Student_authentication();
  Scanner key=new Scanner(System.in);
  System.out.println("Login As ??");
  System.out.println("1.Teacher");
  System.out.println("2.Student");
  int choice=key.nextInt();
  if(choice==1)
  {
    System.out.println("Enter your username");
    String u=key.next();
    System.out.println("Enter your password");
    String p=key.next();
    t.insert();
    String m=t.match(u,p);
     if(m.equals("matched"))
    {
      System.out.println(m);

      t.update(u);  //problem :this is showing NULL pointer exeption
    }
    else System.out.println(m);
  }
  else if(choice==2)
  {
    System.out.println("Enter your username");
    int su=key.nextInt();
    System.out.println("Enter your password");
    String sp=key.next();
    s.insert();
    String sm=s.match(su,sp);
     if(sm.equals("yes"))
    {
      System.out.println(sm);

      System.out.println(s.seeLine(su)); //problem:always hows not matched
    }
    else System.out.println(sm);
  }
  else
   System.out.println("Not valid");
  }

    
}
