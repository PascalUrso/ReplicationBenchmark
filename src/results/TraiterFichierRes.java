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
public class TraiterFichierRes {
	
	static int base = 100;
    public static void main(String[] args) throws IOException 
    {
        if (args.length != 3) System.exit(1);//[G1-G2...] echelle_local echelle_remote
        TraiterLogoot(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        TraiterWoot(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        TraiterWootO(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        TraiterWootH(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        TraiterSOCT2(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        TraiterRGA(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));

    }
    
    
/*************************************************************************************/    
    static void TraiterLogoot(String groupe, int echelleLocal, int echelleRemote) throws IOException
    {
        traiterFichierLocal("Logoot",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("Logoot",groupe);//traiter tout les fichiers remote.res
        FichierCourbeLocal("Logoot","Logoot"+"-"+groupe+"-local.res",echelleLocal);
        FichierCourberemote("Logoot","Logoot"+"-"+groupe+"-remote.res",echelleRemote);
    }
    
    static void TraiterWoot(String groupe, int echelleLocal, int echelleRemote) throws IOException
    {
        traiterFichierLocal("Woot",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("Woot",groupe);//traiter tout les fichiers remote.res
        
        FichierCourbeLocal("Woot","Woot"+"-"+groupe+"-local.res",echelleLocal);
        FichierCourberemote("Woot","Woot"+"-"+groupe+"-remote.res",echelleRemote);
    }
    
    static void TraiterWootH(String groupe, int echelleLocal, int echelleRemote) throws IOException
    {
        traiterFichierLocal("WootH",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("WootH",groupe);//traiter tout les fichiers remote.res
        
        FichierCourbeLocal("WootH","WootH"+"-"+groupe+"-local.res",echelleLocal);
        FichierCourberemote("WootH","WootH"+"-"+groupe+"-remote.res",echelleRemote);
    }
    static void TraiterWootO(String groupe, int echelleLocal, int echelleRemote) throws IOException
    {
        traiterFichierLocal("WootO",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("WootO",groupe);//traiter tout les fichiers remote.res
        
        FichierCourbeLocal("WootO","WootO"+"-"+groupe+"-local.res",echelleLocal);
        FichierCourberemote("WootO","WootO"+"-"+groupe+"-remote.res",echelleRemote);
    }
    static void TraiterSOCT2(String groupe, int echelleLocal, int echelleRemote) throws IOException
    {
        traiterFichierLocal("SOCT2",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("SOCT2",groupe);//traiter tout les fichiers remote.res
        
        FichierCourbeLocal("SOCT2","SOCT2"+"-"+groupe+"-local.res",echelleLocal);
        FichierCourberemote("SOCT2","SOCT2"+"-"+groupe+"-remote.res",echelleRemote);
    }
    static void TraiterRGA(String groupe, int echelleLocal, int echelleRemote) throws IOException
    {
        traiterFichierLocal("RGA",groupe);//traiter tout les fichiers local.res
        traiterFichierRemote("RGA",groupe);//traiter tout les fichiers remote.res
        
        FichierCourbeLocal("RGA","RGA"+"-"+groupe+"-local.res",echelleLocal);
        FichierCourberemote("RGA","RGA"+"-"+groupe+"-remote.res",echelleRemote);
    }
    
/*****************************************************************************************/    

    static void FichierCourbeLocal(String Algo,String File, int echelle) throws IOException
    {
         
        float Tmoyen = 0;
        int NbrOp = 0;
        PrintWriter ecrivain;
        String LigneRemote;
        
        ecrivain =  new PrintWriter(new BufferedWriter(new FileWriter("../../local/"+Algo+".data")));
        InputStream ips1=new FileInputStream(File);InputStreamReader ipsr1=new InputStreamReader(ips1);BufferedReader br1=new BufferedReader(ipsr1);
   
      try{
            while ((LigneRemote=br1.readLine())!=null)
            {
                for(int i=0 ; i<echelle; i++)
                {
                    if((LigneRemote=br1.readLine())!=null)
                    {
                        Tmoyen += recupValeurTemps(LigneRemote);
                        LigneRemote=br1.readLine();
                    }
                    else
                        break;
                }
                
               Tmoyen = Tmoyen/echelle;
               NbrOp+=echelle;
               ecrivain.println(Tmoyen);
               Tmoyen=0;
            }
             br1.close(); 
             ecrivain.close();
          }		
          catch (Exception e){
                System.out.println(e.toString());
        }
    }
          
    static void FichierCourberemote(String Algo,String File, int echelle) throws IOException
    {
        
        float Tmoyen = 0;
        int NbrOp = 0;
        PrintWriter ecrivain;
        String LigneRemote;
        
        ecrivain =  new PrintWriter(new BufferedWriter(new FileWriter("../../remote/"+Algo+".data")));
        InputStream ips1=new FileInputStream(File);InputStreamReader ipsr1=new InputStreamReader(ips1);BufferedReader br1=new BufferedReader(ipsr1);
   
      try{
            while ((LigneRemote=br1.readLine())!=null)
            {
                for(int i=0 ; i<echelle; i++)
                {
                    if((LigneRemote=br1.readLine())!=null)
                    {
                        Tmoyen += recupValeurTemps(LigneRemote);
                        LigneRemote=br1.readLine();
                    }
                    else
                        break;
                }
                
               Tmoyen = Tmoyen/echelle;
               NbrOp+=echelle;
               ecrivain.println(Tmoyen);
               Tmoyen=0;

            }
             br1.close(); 
             ecrivain.close();
          }		
          catch (Exception e){
                System.out.println(e.toString());
        }
    }
    
    static void traiterFichierLocal(String Algo,String groupe) throws IOException
    {
        PrintWriter ecrivain;
        float Tmoyen = 0,time = 0;
        ArrayList<Float> Fichier = new ArrayList<Float>();
        int j;
        
        String logootlocal0 = Algo+"-"+groupe+"0-local.res";            
        ecrivain =  new PrintWriter(new BufferedWriter(new FileWriter(Algo+"-"+groupe+"-local.res")));
        
        InputStream ips0=new FileInputStream(logootlocal0);InputStreamReader ipsr0=new InputStreamReader(ips0);BufferedReader br0=new BufferedReader(ipsr0);
        String line0;
        
        //initialisation Fichier avec le premier fichier        
        while ((line0=br0.readLine())!=null)
        {
            time = recupValeurTemps(line0);
            Fichier.add(time);
        }

        
        for(int i=1; i<base; i++)
        {
             String logootlocal1 = Algo+"-"+groupe+i+"-local.res";
             InputStream ips1=new FileInputStream(logootlocal1);InputStreamReader ipsr1=new InputStreamReader(ips1);BufferedReader br1=new BufferedReader(ipsr1);
             String line1;
             j=0;   
             while ((line1=br1.readLine())!=null)
             {
            	 time = recupValeurTemps(line1);
                 Fichier.set(j, Fichier.get(j)+time);
                 j++;
             }  
            br1.close(); 
        }
        
        for(int k=0; k<Fichier.size();k++)
            ecrivain.println(Fichier.get(k)/base);                

        ecrivain.close();
    }
    
    static void traiterFichierRemote(String Algo,String groupe) throws IOException
    {
        PrintWriter ecrivain;
        float Tmoyen = 0,time = 0;
        ArrayList<Float> Fichier = new ArrayList<Float>();
        int j;
        
        String logootlocal0 = Algo+"-"+groupe+"0-remote.res";            
        ecrivain =  new PrintWriter(new BufferedWriter(new FileWriter(Algo+"-"+groupe+"-remote.res")));
        
        InputStream ips0=new FileInputStream(logootlocal0);InputStreamReader ipsr0=new InputStreamReader(ips0);BufferedReader br0=new BufferedReader(ipsr0);
        String line0;
        
        //initialisation Fichier avec le premier fichier        
        while ((line0=br0.readLine())!=null)
        {
            time = recupValeurTemps(line0);
            Fichier.add(time);
        }
        
        for(int i=1; i<base; i++)
        {
            String logootlocal1 = Algo+"-"+groupe+i+"-remote.res";
             InputStream ips1=new FileInputStream(logootlocal1);InputStreamReader ipsr1=new InputStreamReader(ips1);BufferedReader br1=new BufferedReader(ipsr1);
             String line1;
             j=0;   
             while ((line1=br1.readLine())!=null)
             {
            	 time = recupValeurTemps(line1);
                 Fichier.set(j, Fichier.get(j)+time);
                 j++;
             }  
            br1.close(); 
        }
        
        for(int k=0; k<Fichier.size();k++)
            ecrivain.println(Fichier.get(k)/base);                

        ecrivain.close();
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