package uk.ac.ed.inf.heatmap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	
	Integer[][] data;
	Reader(){
	}
	
	
	Integer[][] scanFile(String filename) throws IOException {
		data=new Integer[10][10];
		
		FileReader fr=new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		int line=0;
		String nextLine=br.readLine();
		while (nextLine !=null) {
			String[] substring=nextLine.replace(" ","").split(",");
			for (int i=0; i<10; i++) 
				data[line++][i]=Integer.parseInt(substring[i]);
			
			
			nextLine=br.readLine();
		}
		br.close();
		
		return data;
	}
	
}
