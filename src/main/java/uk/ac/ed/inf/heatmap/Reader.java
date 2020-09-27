package uk.ac.ed.inf.heatmap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that holds the function that reads and parses files
 * 
 * @author Marios Katalanos
 * 
 *
 */
public final class Reader {
	/**
	 * This method attempts to open a file, which then parses line by line and puts
	 * it in a 2x2 matrix with dimensions specified by the Settings.java file
	 * 
	 * @param filename The file name to be read.
	 * @return A 2x2 matrix with dimensions specified by Settings.java which
	 *         contains the data from the file. In case of incomplete data it fills
	 *         the spot with -1.
	 * @throws IOException In case the file is not found
	 */
	public static int[][] scanFile(String filename) throws IOException {
		int[][] data = new int[Settings.latDim][Settings.lngDim]; // data[lat][lng]

		// Initialize with -1 in case there's data missing from the file
		for (int lat = 0; lat < Settings.latDim; lat++)
			for (int lng = 0; lng < Settings.lngDim; lng++)
				data[lat][lng] = -1;

		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		int line = 0;
		String nextLine = br.readLine();
		while (nextLine != null && line < Settings.latDim) {
//			String[] substring = nextLine.replace(" ", "").replaceAll("[^0-9]+", " ").split(" ");
			String[] substring = nextLine.split("[^0-9]+");

			for (String s : substring)
				System.out.println(s);
			int itLength = Math.min(substring.length, Settings.lngDim);
			for (int i = 0; i < itLength; i++)
				data[line][i] = Integer.parseInt(substring[i]);

			line++;
			nextLine = br.readLine();
		}
		br.close();

		return data;
	}

}
