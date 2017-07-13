/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sai Tejaswini.M.V
 */
public class Snode {
   
 String password;
 Snode next; 
 int ddco;
 int ds;
 int scs;
 int wt;
 int dml;
 int usn;
 String section;
 Snode(int usn,String pwd,String sec,int dd,int dst,int sts,int wbt,int dml1)
 {
   usn=usn;
    password=pwd;
    next=null;
    ddco=dd;
    ds=dst;
    scs=sts;
    wt=wbt;
    dml=dml1;
    section=sec;
 }
 }
    

