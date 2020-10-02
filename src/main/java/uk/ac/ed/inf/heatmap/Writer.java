package uk.ac.ed.inf.heatmap;

import com.mapbox.geojson.FeatureCollection;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This is the class that holds the functionallity that writes the file.
 * 
 * @author Marios Katalanos
 *
 */
public class Writer {
	FeatureCollection heatmapToWrite;

	/**
	 * Constructor for Writer.
	 * 
	 * @param heatmap The heatmap that will be written to a file.
	 */
	Writer(FeatureCollection heatmap) {
		this.heatmapToWrite = heatmap;
	}

	/**
	 * Method that writes the heatmap to a file.
	 * 
	 * @throws IOException In the case the file can't be written.
	 */
	void writeToFile() throws IOException {
		String path = "heatmap.geojson";

		FileWriter fw = new FileWriter(path, false);
		fw.write(this.heatmapToWrite.toJson());

		fw.close();
	}

}
