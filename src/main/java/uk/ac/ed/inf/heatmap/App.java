package uk.ac.ed.inf.heatmap;

import java.io.IOException;

import com.mapbox.geojson.FeatureCollection;

//Main Program

public class App {

	public static void main(String[] args) {
		int[][] data;
		Reader r = new Reader();
		try {
			if(args.length>0)
				data = r.scanFile(args[0]);
			else {
				System.out.println("Please enter the path to a filename.");
				return;
			}
			
		} catch (IOException e) {
			System.out.println("File not found!");
			return;
		}

		FeatureCollection heatmap = GeoMapper.generateHeatmap(data);

		Writer w = new Writer(heatmap);
		try {
			w.writeToFile();
		} catch (IOException e) {
			System.out.println("COULD NOT MAKE FILE!");
		}
	}
}
