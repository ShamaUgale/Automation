package sort;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class rearrangeWords {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 File ip= new File("C:\\Users\\shama.ugale\\Desktop\\Roots.txt");
 FileWriter wr= new FileWriter("C:\\Users\\shama.ugale\\Desktop\\unique.txt");
 BufferedWriter w= new BufferedWriter(wr);
// String txt=ip.toString();
// System.out.println(txt);
 BufferedReader r= new BufferedReader(new FileReader(ip));
 String text = null;
 Set set= new HashSet();
 while ((text = r.readLine()) !=null) {
    //   System.out.println(text);
       String[] temp= text.split("[ ]");
       for(int i=0; i<temp.length;i++){
    //   System.out.println(temp[i]);
       if(temp[i].matches("[a-zA-Z]+")){
       set.add(temp[i]);
      
//       w.write(temp[i]);
//     w.newLine();
      
       }
     
       }
        
	}
 Iterator it= set.iterator();
 while(it.hasNext()){
	
	 w.write(it.next().toString());
	 w.newLine();
 }
 System.out.println(set);
 System.out.println(set.contains("torso"));
 System.out.println(set.size());

}
	public static boolean isAnagram(String firstWord, String secondWord) {
	     char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
	     char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}
	
	public static void anagrams() throws IOException{
		File ip= new File("C:\\Users\\shama.ugale\\Desktop\\Roots.txt");
		 
		// String txt=ip.toString();
		// System.out.println(txt);
		 BufferedReader r= new BufferedReader(new FileReader(ip));
		 String text = null;
		 Set set= new HashSet();
		 while ((text = r.readLine()) !=null) {
		       System.out.println(text);
		       isAnagram("","");
		       isAnagram("","");
		       //just adding comments
		       //judst another line
		       
		       
		       }
		     
		       }
		        
	}

