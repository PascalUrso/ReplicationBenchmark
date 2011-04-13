package results;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.lang.Math;
import java.lang.Float;
import java.util.ArrayList;

/**
 *
 * @author mehdi
 */
public class Moyenne {
	
	static int base = 100;
    public static void main(String[] args) throws IOException 
    {
        if (args.length != 1) System.exit(1);//[G1-G2...]
        TraiterLogoot(args[0]);
        TraiterWoot(args[0]);
       	TraiterWootO(args[0]);
       	TraiterWootH(args[0]);
        TraiterSOCT2(args[0]);
        TraiterRGA(args[0]);

    }
    
    
/*************************************************************************************/    
    static void TraiterWoot(String groupe) throws IOException
    {
        traiterFichierLocal("Woot",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("Woot",groupe);//traiter tout les fichiers remote.res
    }
    
    
     static void TraiterRGA(String groupe) throws IOException
    {
        traiterFichierLocal("RGA",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("RGA",groupe);//traiter tout les fichiers remote.res
    }
    static void TraiterLogoot(String groupe) throws IOException
    {
        traiterFichierLocal("Logoot",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("Logoot",groupe);//traiter tout les fichiers remote.res
    }
    
    static void TraiterWootH(String groupe) throws IOException
    {
        traiterFichierLocal("WootH",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("WootH",groupe);//traiter tout les fichiers remote.res

    }
    static void TraiterWootO(String groupe) throws IOException
    {
        traiterFichierLocal("WootO",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("WootO",groupe);//traiter tout les fichiers remote.res
    }
    static void TraiterSOCT2(String groupe) throws IOException
    {
        traiterFichierLocal("SOCT2",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("SOCT2",groupe);//traiter tout les fichiers remote.res

    }
    
/*****************************************************************************************/    

    static void traiterFichierLocal(String Algo,String groupe) throws IOException
    {
        float Tmoyen = 0,time = 0;
        int nbrOp = 0;
        
        String logootlocal0 = Algo+"-"+groupe+"0-local.res";            
        
        InputStream ips0=new FileInputStream(logootlocal0);InputStreamReader ipsr0=new InputStreamReader(ips0);BufferedReader br0=new BufferedReader(ipsr0);
        String line0;
        
        //initialisation Fichier avec le premier fichier        
        while ((line0=br0.readLine())!=null)
        {
            nbrOp++;
            time += recupValeurTemps(line0);
        }

        Tmoyen = time/nbrOp;
                
        for(int i=1; i<base; i++)
        {
             time=0;
             nbrOp = 0;
             String logootlocal1 = Algo+"-"+groupe+i+"-local.res";
             InputStream ips1=new FileInputStream(logootlocal1);InputStreamReader ipsr1=new InputStreamReader(ips1);BufferedReader br1=new BufferedReader(ipsr1);
             String line1;
             while ((line1=br1.readLine())!=null)
             {
                 nbrOp++;
            	 time += recupValeurTemps(line1);
             }
             
             Tmoyen += time/nbrOp;
                
            br1.close(); 
        }
        
        System.out.println("Local : "+Tmoyen);            

    }
    
    static void traiterFichierRemote(String Algo,String groupe) throws IOException
    {
       float Tmoyen = 0,time = 0;
        int nbrOp = 0;

        String logootlocal0 = Algo+"-"+groupe+"0-remote.res";            
        
        InputStream ips0=new FileInputStream(logootlocal0);InputStreamReader ipsr0=new InputStreamReader(ips0);BufferedReader br0=new BufferedReader(ipsr0);
        String line0;
        
        //initialisation Fichier avec le premier fichier        
        while ((line0=br0.readLine())!=null)
        {
            nbrOp++;
            time += recupValeurTemps(line0);
        }
        Tmoyen = time/nbrOp;

        for(int i=1; i<base; i++)
        {
             time = 0;
             nbrOp = 0;
             String logootlocal1 = Algo+"-"+groupe+i+"-remote.res";
             InputStream ips1=new FileInputStream(logootlocal1);InputStreamReader ipsr1=new InputStreamReader(ips1);BufferedReader br1=new BufferedReader(ipsr1);
             String line1;
             while ((line1=br1.readLine())!=null)
             {
                 nbrOp++;
            	 time += recupValeurTemps(line1);
             }
             
             Tmoyen += time/nbrOp;
                
            br1.close(); 
        }
        
        System.out.println("Remote : "+Tmoyen);
    }

    
    static float recupValeurTemps(String ligne)
    {
       String tab[] = ligne.split("\t");
       return Float.valueOf(tab[(tab.length)-1]).floatValue();
    }
    
    static int recupValeurNbrOp(String ligne)
    {
       String tab[] = ligne.split("\t");
       return Integer.parseInt(tab[0]);
    }

}
