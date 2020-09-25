package uk.ac.ed.inf.heatmap;

import com.mapbox.geojson.FeatureCollection;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	FeatureCollection heatmapToWrite;
	
	Writer(FeatureCollection heatmap){
	this.heatmapToWrite=heatmap;	
	}
	
	
	void writeToFile() throws IOException{
		String path="heatmap.geojson";
		
		FileWriter fw = new FileWriter(path,false);
		fw.write(this.heatmapToWrite.toJson());
		
		fw.close();
	}
	
	
}
