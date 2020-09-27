package uk.ac.ed.inf.heatmap;

import java.io.IOException;

import com.mapbox.geojson.FeatureCollection;

//Main Program

public class App {
	public static void main(String[] args) {
		// Note to adjust the resolution of the matrix please adjust the Settings.java
		// file

		int[][] data; // Matrix used to hold the imported data

		// Read the file from the arguments
		try {
			if (args.length > 0) // Check that a file was given
				data = Reader.scanFile(args[0]); // Scan the file and store the data into the matrix
			else {
				System.out.println("Please enter the path to a filename."); // Exit message in the scenario that no file
																			// was given
				return;
			}
		} catch (IOException e) {
			System.out.println("File not found!"); // Exit message in case the file was not found
			return;
		}

		FeatureCollection heatmap = GeoMapper.generateHeatmap(data); // Statically call the GeoMapper class to create a
																		// heatmap

		// Write the heatmap to a geojson
		Writer w = new Writer(heatmap);
		try {
			w.writeToFile(); // Write to file
		} catch (IOException e) {
			System.out.println("Could not write to file!"); // In case the file could not be written output the file to
															// stdout
			System.out.println(heatmap.toJson());
			return;
		}
	}
}
