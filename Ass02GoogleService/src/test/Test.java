package test;

import org.apache.axis2.AxisFault;

import au.edu.swin.waa.GoogleService;

public class Test {
	private static String apiKey = "AIzaSyCJWtL5V-u84zWLx6XNLWnMMqwj8WOcob4";
	private static GoogleService gs;

	/**
	 * @param args
	 * @throws AxisFault
	 */
	public static void main(String[] args) throws AxisFault {
		gs = new GoogleService();
		String isbnTest = "1781106940";
		// System.out.println(gw.getBookDetails("1781106940"));
		System.out.println(gs.getTitle(isbnTest));
	}

	public static void tgetAuthors(String isbn) {
		// System.out.println(gs.getAuthors(isbn));
	}

}
