/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfilEcrivain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.annolab.tt4j.TreeTaggerWrapper;


public class Essai {
    
    static TreeMap <String,Integer> Occurence = new TreeMap<String,Integer>();
    ArrayList<String> splitArray=new ArrayList<String> ();
    BufferedReader lecteurAvecBuffer = null;
    String ligne;
    
    static String [] segmentation (String ligne)
    {
         //String ligne1="";
         String str [] ={",",".","?","!","...","…","-","(",")",";",":","\n"};
       for( int k=0;k<str.length;k++)
    {
        
        ligne=ligne.replace(str[k]," "+str[k]); 
      
    }
        return ligne.split(" "); 

    }
    
    
public static void Treetag (String texte)
{
    try
      {
	lecteurAvecBuffer =  new BufferedReader;
        (new FileReader(texte));
      }
    catch(IOException ioe)
      {
	System.out.println("Erreur d'ouverture");
      }
    while ((ligne = lecteurAvecBuffer.readLine()) != null)
    {
   
   List list1=Arrays.asList(segmentation(ligne)); 
   splitArray.addAll(list1);
   
   
    }
     System.setProperty("treetagger.home", "C:\\treetagger");
                TreeTaggerWrapper tt = new TreeTaggerWrapper<String>();
                try {
                        tt.setModel("C:\\TreeTagger\\lib\\french-utf8.par");
                        tt.setHandler(new TokenHandler<String>() {
                                public void token(String token, String pos, String lemma) {
                                        System.out.println(token + "\t" + pos + "\t" + lemma);
                                        Analyse(lemma);
                                                                                           }
                        });
                        tt.process(splitArray);
                        
                }
        catch (TreeTaggerException ex) {
            Logger.getLogger(classeprincipale.class.getName()).log(Level.SEVERE, null, ex);
        }                finally {
                        tt.destroy();
                                 }
   
    Set listKeys=Occurence.keySet();
    Iterator iterateur=listKeys.iterator();

    while(iterateur.hasNext())
    {
    Object key= iterateur.next();
    System.out.println (key+"=>"+Occurence.get(key));
    }
                           
     
    lecteurAvecBuffer.close();
  }
    
}
    
    
    
public static void listeRepertoire ( File repertoire ) {
        if ( repertoire.isDirectory ( ) ) {
                File[] list = repertoire.listFiles();
                if (list != null){
	                for ( int i = 0; i < list.length; i++) {
	                        System.out.println(list[i].getName());
	                } 
                } else {
                	System.err.println(repertoire+ " : Erreur de lecture.");
                }
        } 
                                                        }
    


  
    
    public static void Analyse (String word)       
    {  
        Integer occ;
        occ=Occurence.get(word);
        if(occ==null)
        {
            Occurence.put(word,1);
        }  
        else
        {
            Occurence.put(word,occ+1);
        }
        
    }
    
     public static void main(String[] argv) throws IOException{
    
    File rep = new File("Zola");
    listeRepertoire(rep);
  
    
     
                                                                }
     



