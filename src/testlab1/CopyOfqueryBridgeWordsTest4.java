package testlab1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test_for_every_dont_know.linkList;
import test_for_every_dont_know.test;

public class CopyOfqueryBridgeWordsTest4 {
  static linkList lnklst=null;
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    String regex="[^\\p{Alpha}]+";
    String localAddress="test3.txt";
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
   lnklst=test.creatlnklst(strArrays);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testSearchBridgeWords() {
    lnklst.searchBridgeWords("the","new");
  }

}
