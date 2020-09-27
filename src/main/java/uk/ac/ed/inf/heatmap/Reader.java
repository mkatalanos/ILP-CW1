package uk.ac.ed.inf.heatmap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	static int[][] scanFile(String filename) throws IOException {
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
			String[] substring = nextLine.replace(" ", "").split(",");
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
