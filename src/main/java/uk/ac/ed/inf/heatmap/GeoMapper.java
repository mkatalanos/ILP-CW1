package uk.ac.ed.inf.heatmap;

import java.util.List;

import java.util.ArrayList;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;

public class GeoMapper {
	private static Point[] corners = { Point.fromLngLat(-3.192473,55.946233), // Forrest Hill
			Point.fromLngLat(-3.184319,55.942617)// Buccleuch St bus stop
	};

	static Point[][] vertices;
	static {
		vertices = new Point[11][11];
		double longDist = (corners[1].longitude() - corners[0].longitude()) / 10;
		double latDist = (corners[1].latitude() - corners[0].latitude()) / 10;

		// Vertex[lat][long]
		for (int lat = 0; lat < 11; lat++) {
			for (int lng = 0; lng < 11; lng++) {
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
		for (int lat = 0; lat < 10; lat++) {
			for (int lng = 0; lng < 10; lng++) {
				heatmap.add(fg.generateFeature(lng, lat));
			}
		}
		
		FeatureCollection collection=FeatureCollection.fromFeatures(heatmap);
		return collection;
	}

}
