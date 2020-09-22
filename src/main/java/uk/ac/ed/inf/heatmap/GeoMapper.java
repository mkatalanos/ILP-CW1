package uk.ac.ed.inf.heatmap;

import com.mapbox.geojson.Point;

public class GeoMapper {
	int[][] data;
	Point[] corners = { Point.fromLngLat(55.946233, -3.192473), // Forrest Hill
			Point.fromLngLat(55.942617, -3.184319)// Buccleuch St bus stop
	};

	Point[][] vertices;

	GeoMapper(int[][] data) {
		this.data = data;

		this.vertices = new Point[11][11];

		double longDist = (corners[1].longitude() - corners[0].longitude()) / 10;
		double latDist = (corners[1].latitude() - corners[0].latitude()) / 10;

		// Vertix[lat][long]
		for (int lat = 0; lat < 11; lat++) {
			for (int lng = 0; lng < 11; lng++) {
				double longitude = corners[0].longitude() + lng * longDist;
				double latitude = corners[0].latitude() + lat * latDist;

				vertices[lat][lng] = Point.fromLngLat(longitude, latitude);
			}
		}

	}

}
