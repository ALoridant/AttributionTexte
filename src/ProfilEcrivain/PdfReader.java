/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfilEcrivain;


import com.itextpdf.text.pdf.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.util.*;
 
public class PdfReader {
 
    public static void main(String[] args) {
 
    	// TODO, add your application code
    	System.out.println("Lecteur PDF de mesexemples.com!");
    	System.out.println (ReadPDF("test.pdf"));
    }
        private static String ReadPDF(String pdf_url)
    {
        StringBuilder str=new StringBuilder();
        try
        {
 
         PdfReader reader = new PdfReader(pdf_url);
        int n = reader.getNumberOfPages();
         for(int i=1;i<n;i++)
         {
            String str2=PdfTextExtractor.getTextFromPage(reader, i);
            str.append(str2);
           System.out.println(str);
         }
        }catch(Exception err)
        {
            err.printStackTrace();
        }
        return String.format("%s", str);
    }
}
