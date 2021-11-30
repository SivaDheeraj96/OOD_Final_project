package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class FileUtil {
	
	
 static BufferedReader getFileReader(String filename) throws FileNotFoundException {
	  BufferedReader br = new BufferedReader(new FileReader(filename));
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


