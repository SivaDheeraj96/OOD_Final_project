package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {
	
	
	 
 public static List<String>  getFileData(String fileName) {
	 FileReader fr = null;
	 BufferedReader br = null;
	 List<String> data = new ArrayList<String>();
	 try {
		 fr = new FileReader(fileName);
		 br = new BufferedReader(fr);
		 while (br.ready()) {
			 String line = br.readLine();
			 data.add(line);
		 }
	 }
	 catch(Exception e) {
		 System.err.println("Exception while reading the file");
		 e.printStackTrace();
	 }
	 finally {
		 try {
			fr.close();
			br.close();
		} catch (IOException e) {
			System.err.print("error while closing the buffer");
			e.printStackTrace();
		}
	 }
	 return data;
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


