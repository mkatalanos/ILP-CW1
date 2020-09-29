package uk.ac.ed.inf.heatmap;

import java.util.List;

import java.util.ArrayList;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;

/**
 * This is the class that contains the code that actually creates a heatmap. The
 * heatmap is defined between the corners in Settings.java, to adjust them
 * please change them there.
 * 
 * @author Marios Katalanos
 *
 */
public class GeoMapper {

	/**
	 * Corners to which the heatmap is constraint. It's just a reference to
	 * Settings.corners
	 */
	private static Point[] corners = Settings.corners;

	/**
	 * This the vertices matrix. It contains Points to every vertex needed to create
	 * the heatmap. It's contents can be referenced using the indexes lat - for
	 * latitude and lng - for longitude in the form vertices[lat][lng] It has
	 * dimensions (Settings.latDim+1 x Settings.lngDim+1)
	 */
	static Point[][] vertices;
	static {
		vertices = new Point[Settings.latDim + 1][Settings.lngDim + 1];
		double longDist = (corners[1].longitude() - corners[0].longitude()) / Settings.lngDim; // Finds the distance
																								// between two single
																								// vertices.
		double latDist = (corners[1].latitude() - corners[0].latitude()) / Settings.latDim; // Finds the height between
																							// two single vertices.

		// Starting from top left corner add appropriate distance to each point.
		for (int lat = 0; lat < Settings.latDim + 1; lat++) {
			for (int lng = 0; lng < Settings.lngDim + 1; lng++) {
				double longitude = corners[0].longitude() + lng * longDist;
				double latitude = corners[0].latitude() + lat * latDist;

				vertices[lat][lng] = Point.fromLngLat(longitude, latitude);
			}
		}
	}

	// Private Constructor to make sure that the class can't get instantiated.
	private GeoMapper() {
	}

	/**
	 * Static method that generates heatmap based on a data matrix.
	 * 
	 * @param data A 2x2 integer matrix with dimensions (Settings.latDim x
	 *             Settings.lngDim).
	 * @return A heatmap in the form of a FeatureCollection.
	 */
	public static FeatureCollection generateHeatmap(int[][] data) {
		List<Feature> heatmap = new ArrayList<>();
		FeatureGenerator fg = new FeatureGenerator(vertices, data);

		for (int lat = 0; lat < Settings.latDim; lat++) {
			for (int lng = 0; lng < Settings.lngDim; lng++) {
				heatmap.add(fg.generateFeature(lng, lat));
			}
		}

		FeatureCollection collection = FeatureCollection.fromFeatures(heatmap);
		return collection;
	}

}
