package uk.ac.ed.inf.heatmap;

import java.io.IOException;

//Main Program

public class App {
	public static void main(String[] args) {
		int[][] data;
		Reader r = new Reader();
		try {
			data = r.scanFile(args[0]);

		} catch (IOException e) {
			System.out.println("File not found!");
			return;
		}
	
		
		GeoMapper gm=new GeoMapper(data);
		
		
		
	}
}
