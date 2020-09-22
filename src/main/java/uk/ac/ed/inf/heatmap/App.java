package uk.ac.ed.inf.heatmap;

//Main Program

public class App {
	public static void main(String[] args) {

		String s = "1, 2 , 3 , 4 , 5 ,6 ";
		System.out.println(s);

		String[] ss = s.replace(" ", "").split(",");

		for (String s1 : ss)
			System.out.println(s1);
	}
}
