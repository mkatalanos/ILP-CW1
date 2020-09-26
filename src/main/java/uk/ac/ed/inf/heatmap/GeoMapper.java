package uk.ac.ed.inf.heatmap;

import java.util.List;

import java.util.ArrayList;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;

public class GeoMapper {
	private static Point[] corners = Settings.corners;

	static Point[][] vertices;
	static {
		vertices = new Point[Settings.latDim+1][Settings.lngDim+1];
		double longDist = (corners[1].longitude() - corners[0].longitude()) / Settings.lngDim;
		double latDist = (corners[1].latitude() - corners[0].latitude()) / Settings.latDim;

		// Vertex[lat][long]
		for (int lat = 0; lat < Settings.latDim+1; lat++) {
			for (int lng = 0; lng < Settings.lngDim+1; lng++) {
				double longitude = corners[0].longitude() + lng * longDist;
				double latitude = corners[0].latitude() + lat * latDist;

				vertices[lat][lng] = Point.fromLngLat(longitude, latitude);
			}
		}
	}

	public static FeatureCollection generateHeatmap(int[][] data) {
		List<Feature> heatmap = new ArrayList<>();
		FeatureGenerator fg = new FeatureGenerator(vertices, data);
		//
		for (int lat = 0; lat < Settings.latDim; lat++) {
			for (int lng = 0; lng < Settings.lngDim; lng++) {
				heatmap.add(fg.generateFeature(lng, lat));
			}
		}
		
		FeatureCollection collection=FeatureCollection.fromFeatures(heatmap);
		return collection;
	}

}
