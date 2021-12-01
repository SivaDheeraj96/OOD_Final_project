package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class FileUtil {
	
	
	 
 public static List<String>  getFileData(String fileName) throws Exception{
	 FileReader fr = null;
	 BufferedReader br = null;
	 try {
		 fr = new FileReader(fileName);
		 br = new BufferedReader(fr);
//		 while (br) {
//			 
//		 }
	 }
	 catch(Exception e) {
		 System.err.println();
		 throw e;
	 }
	 return null;
 }
 
 
 static BufferedReader getFileReader(String filename) {
	 File f  = new File(filename);
	 if(!f.exists()) {
		 try {
		 f.createNewFile();
		 }
		 catch(Exception e) {
			 System.err.println("error creating file");
		 }
	 }
	  BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(filename));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		  return br;
	  }
 public void writeToFile(String filename, List<String> dataList) throws IOException {
		try (FileWriter fw = new FileWriter(filename, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {

			for (String data : dataList) {
				out.println(data);
			}
		} catch (IOException e) {
			throw new IOException(e);
		
		}
}

 
}


