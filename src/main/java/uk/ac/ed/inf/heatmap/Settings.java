package uk.ac.ed.inf.heatmap;

import com.mapbox.geojson.Point;

public final class Settings {

	public static final int lngDim = 50;
	public static final int latDim = 50;

	public static final Point[] corners = { Point.fromLngLat(-3.192473, 55.946233), // Forrest Hill
			Point.fromLngLat(-3.184319, 55.942617)// Buccleuch St bus stop
	};
}
