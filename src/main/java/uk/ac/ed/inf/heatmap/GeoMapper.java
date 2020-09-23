package uk.ac.ed.inf.heatmap;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.Polygon;

public class GeoMapper {
	private static Point[] corners = { Point.fromLngLat(55.946233, -3.192473), // Forrest Hill
			Point.fromLngLat(55.942617, -3.184319)// Buccleuch St bus stop
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


	public static Polygon[][] generateHeatmap(int[][] data) {
		Polygon[][] heatmap = new Polygon[10][10];

		//
		for (int lat = 0; lat < 10; lat++) {
			for (int lng = 0; lng < 10; lng++) {
//				heatmap[lat][lng] = new Rectangle(data[lat][lng],lat,lng);
			}
		}

		return heatmap;
	}

//	Polygon generatePoly(int value, int lat, int lng) {
//		
//		List<List<Point>> corners=new ArrayList<>();
//		
//		corners.add(Arrays.asList(new Point[]{vertices[lat][lng],vertices[lat][lng+1]}));
//		corners.add(Arrays.asList(new Point[]{vertices[lat+1][lng],vertices[lat+1][lng+1]}));
//		
//		
//		Polygon rect=Polygon.fromLngLats(corners);
//		rect.
//		
//		return rect;
//	}

}
