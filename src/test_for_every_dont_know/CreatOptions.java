package test_for_every_dont_know;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreatOptions {
  public static String [] RetrnStringarrays(String localAddress)//¶ÁÈ¡ÎÄ±¾
  {
    String regex="[^\\p{Alpha}]+";
    String wordstmp;
    String[] strArrays = null;
   try
   {
       FileInputStream fis = new FileInputStream(localAddress);
       InputStreamReader dis = new InputStreamReader(fis);
       BufferedReader reader = new BufferedReader(dis);
       String strSentence="",strtemp;
        while( (strtemp = reader.readLine()) != null )  
        {
            strSentence=strSentence+strtemp;
        }
        dis.close();
       
        strArrays=strSentence.split(regex);
       
    }catch(IOException e)
    {
        System.out.println(e);
    }
    return strArrays;
  }
}
