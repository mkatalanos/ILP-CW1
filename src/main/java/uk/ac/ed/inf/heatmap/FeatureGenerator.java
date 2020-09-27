package uk.ac.ed.inf.heatmap;

import com.mapbox.geojson.Polygon;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;

import java.util.ArrayList;
import java.util.List;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Geometry;

/**
 * This is class is used to generate the features that are used in GeoMapper. It
 * contains private methods that are used as tools for aiding the creation of
 * such features. It also contains a function that is used for actually creating
 * a feature.
 * 
 * @author Marios Katalanos
 *
 */
public class FeatureGenerator {

	private Point[][] vertices; // vertices[lat][lng]
	private int[][] data;

	/**
	 * Constructor for FeatureGenerator
	 * 
	 * @param vertices A 2x2 matrix which contains points which could become
	 *                 vertices. Has dimensions from Settings.java increased by one
	 *                 to account for the outer right and bottom edges.
	 * @param data     A 2x2 matrix with dimensions from Settings.java which
	 *                 contains the data to be visualised.
	 */
	FeatureGenerator(Point[][] vertices, int[][] data) {
		this.vertices = vertices;
		this.data = data;
	}

	/**
	 * This method maps a value to a color. If a value does not map to anything
	 * black is used.
	 * 
	 * @param x The value to be mapped
	 * @return A string that contains the color in the form '#rrggbb'
	 */
	private String colorFromData(int x) {
		String s = "";
		if (0 <= x && x < 32)
			s = "#00ff00";
		else if (32 <= x && x < 64)
			s = "#40ff00";
		else if (64 <= x && x < 96)
			s = "#80ff00";
		else if (96 <= x && x < 128)
			s = "#c0ff00";
		else if (128 <= x && x < 160)
			s = "#ffc000";
		else if (160 <= x && x < 192)
			s = "#ff8000";
		else if (192 <= x && x < 224)
			s = "#ff4000";
		else if (224 <= x && x < 256)
			s = "#ff0000";
		else
			s = "#000000";
		return s;
	}

	private List<Point> generateLine(int lng, int lat, int side) {
		List<Point> points = new ArrayList<>();

		switch (side) {
		case 0: // TOP
			points.add(vertices[lat][lng]);
			points.add(vertices[lat][lng + 1]);
			break;
		case 1: // RIGHT
			points.add(vertices[lat][lng + 1]);
			points.add(vertices[lat + 1][lng + 1]);
			break;
		case 2: // BOTTOM
			points.add(vertices[lat + 1][lng + 1]);
			points.add(vertices[lat + 1][lng]);
			break;
		case 3: // LEFT
			points.add(vertices[lat + 1][lng]);
			points.add(vertices[lat][lng]);
			break;
		default: // NEVER CALLED
			return null;
		}

		return points;
	}

	private Polygon generatePolygon(int lng, int lat) {
		List<Point> lines = new ArrayList<>();
		for (int side = 0; side <= 3; side++) {
			lines.addAll(generateLine(lng, lat, side));
		}

		LineString outer = LineString.fromLngLats(lines);
		Polygon poly = Polygon.fromOuterInner(outer);

		return poly;
	}

	protected Feature generateFeature(int lng, int lat) {
		String color = colorFromData(this.data[lat][lng]);
		Polygon poly = generatePolygon(lng, lat);
		Feature f = Feature.fromGeometry((Geometry) poly);
		f.addNumberProperty("fill-opacity", 0.75);
		f.addStringProperty("rgb-string", color);
		f.addStringProperty("fill", color);

		return f;
	}
}
