package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class sortIPs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> ipList = new ArrayList<String>();
	    ipList.add("123.4.245.23");
	    ipList.add("104.244.253.29");
	    ipList.add("1.198.3.93");
	    ipList.add("32.183.93.40");
	    ipList.add("104.30.244.2");
	    ipList.add("104.244.4.1");
	    ipList.add("123.4.245.23");
	    ipList.add("104.244.253.29");
	    ipList.add("1.198.3.93");
	    ipList.add("32.183.93.40");
	    ipList.add("104.30.244.2");
	    ipList.add("104.244.4.1");
	    ipList.add("32.183.93.40");
	    ipList.add("104.30.244.2");
	    ipList.add("104.244.4.1");
	    ipList.add("32.183.93.40");
	    ipList.add("104.30.244.2");
	    ipList.add("104.244.4.1");
	    Collections.sort(ipList, new Comparator<String>() {
	        public int compare(String o1, String o2) {
	            String[] ips1 = o1.split("\\.");
	            String updatedIp1 = String.format("%3s.%3s.%3s.%3s",
	                                                  ips1[0],ips1[1],ips1[2],ips1[3]);
	            String[] ips2 = o2.split("\\.");
	            String updatedIp2 = String.format("%3s.%3s.%3s.%3s",
	                                                  ips2[0],ips2[1],ips2[2],ips2[3]);
	            return updatedIp1.compareTo(updatedIp2);
	        }
	    });
		int count=1;
	    //print the sorted IP
		Iterator it= ipList.iterator();
		
	    for(int i=0; i<ipList.size();i++){	    
	        System.out.println(ipList.get(i));
	          }
//	   if(ipList){
//		   
//	   }
	      
	       
	    }
	    
	}


