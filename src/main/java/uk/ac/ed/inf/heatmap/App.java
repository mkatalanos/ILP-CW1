package uk.ac.ed.inf.heatmap;

import java.io.IOException;

import com.mapbox.geojson.FeatureCollection;

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

		FeatureCollection heatmap = GeoMapper.generateHeatmap(data);

//		for(int[] line: data) {
//			for (int x : line)
//				System.out.printf("%d ",x);
//			System.out.println();
//		}
//		
//		System.out.println(heatmap.toJson());
		Writer w = new Writer(heatmap);
		try {
			w.writeToFile();
		} catch (IOException e) {
			System.out.println("COULD NOT MAKE FILE!");
		}
	}
}
