package uk.ac.ed.inf.heatmap;

import com.mapbox.geojson.Point;

/**
 * This class holds the constant settings used throughout the program
 * 
 * @author Marios Katalanos
 *
 */
public final class Settings {

	/**
	 * Used to restrict instantiation.
	 */
	private Settings() {
	}

	/**
	 * Determines the dimensions of the generated heatmap.
	 */
	public static final int lngDim = 10;
	public static final int latDim = 10;

	/**
	 * Determines the area which the generated heatmap is restricted to. Use
	 * opposite corners Top-Left with Bottom-Right.
	 */
	public static final Point[] corners = { Point.fromLngLat(-3.192473, 55.946233), // Forrest Hill
			Point.fromLngLat(-3.184319, 55.942617)// Buccleuch St bus stop
	};
}
