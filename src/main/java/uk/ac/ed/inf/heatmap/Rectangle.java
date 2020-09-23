package uk.ac.ed.inf.heatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mapbox.geojson.Point;
import com.mapbox.geojson.Polygon;

public class Rectangle {

	String color;
	Polygon shape;

	Rectangle(int value, int lat, int lng) {
		List<List<Point>> corners = new ArrayList<>();

		corners.add(Arrays.asList(new Point[] { vertices[lat][lng], vertices[lat][lng + 1] }));
		corners.add(Arrays.asList(new Point[] { vertices[lat + 1][lng], vertices[lat + 1][lng + 1] }));

		this.shape = Polygon.fromLngLats(corners);

	}

}
