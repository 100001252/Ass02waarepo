package au.edu.swin.waa;

//-----------------------------------------------------------------

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// import org.apache.poi.util.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// import com.google.gson.*;

public class GoogleService {

	private String QueryURL = "";
	private final String googleBase10 = "https://www.googleapis.com/books/v1/volumes?q=isbn:";
	private final String googleBase13 = "https://www.googleapis.com/books/v1/volumes?q=isbn13:";
	private final String myAPIkey = "AIzaSyAGTo-Im7lbyjJrKsDj09u94r2WilW0wZk";
	private final String isbnType = "^978.*";

	String endResults;
	StringBuffer response;
	List<String> procList;
	String Finalinfo = "";
	String Outpt;

	public JSONObject getJsonFormat(String isbn) {

		// /determine the ISBN number format

		if (isbn.matches(isbnType)) {
			QueryURL = googleBase13 + isbn + "&key=" + myAPIkey;
		} else {
			QueryURL = googleBase10 + isbn + "&key=" + myAPIkey;
		}

		System.out.println("get here 1");

		try {
			System.out.println("get here 2");
			// connect to google API
			URI uri = new URI(QueryURL);
			String mm = uri.toString(); // format URI

			System.out.println(mm);

			URL googleAPI = new URL(mm); // make URL

			Scanner scan = new Scanner(googleAPI.openStream());
			String str = new String();
			while (scan.hasNext())
				str += scan.nextLine();
			scan.close();

			// response.append("\n");

			JSONObject objj = new JSONObject(str);
			return objj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * old function
	 *
	 * @param book_id
	 * @return
	 */
	public String getBookDetails(String book_id) {

		// /determine the ISBN number format

		if (book_id.matches(isbnType)) {

			QueryURL = googleBase13 + book_id + "&key=" + myAPIkey;
		} else {

			QueryURL = googleBase10 + book_id + "&key=" + myAPIkey;

		}

		System.out.println("get here 1");

		try {
			System.out.println("get here 2");
			// connect to google API
			URI uri = new URI(QueryURL);
			String mm = uri.toString(); // format URI

			System.out.println(mm);

			URL googleAPI = new URL(mm); // make URL

			Scanner scan = new Scanner(googleAPI.openStream());
			String str = new String();
			while (scan.hasNext())
				str += scan.nextLine();
			scan.close();

			// response.append("\n");

			JSONObject objj = new JSONObject(str);

			if (objj.getInt("totalItems") == 0) {

				Outpt = "totalItems: " + objj.getInt("totalItems")
						+ "\n\n No books Available!";
				System.out.println("get here 4");
			} else {

				System.out.println(" not get here 1");
				Outpt = "totalItems: " + objj.getInt("totalItems");

				JSONArray n = objj.getJSONArray("items");
				Outpt = Outpt
						+ "\n"
						+ "Title: "
						+ n.getJSONObject(0).getJSONObject("volumeInfo")
								.getString("title");
				Outpt = Outpt
						+ "\n"
						+ "Author(s): "
						+ n.getJSONObject(0).getJSONObject("volumeInfo")
								.getJSONArray("authors").getString(0);

				Outpt = Outpt
						+ "\n"
						+ "publishedDate: "
						+ n.getJSONObject(0).getJSONObject("volumeInfo")
								.getString("publishedDate");
				Outpt = Outpt
						+ "\n"
						+ "description: "
						+ n.getJSONObject(0).getJSONObject("volumeInfo")
								.getString("description");

				System.out.println(" not get here 2");
				try {

					Outpt = Outpt
							+ "\n"
							+ "ISBN10: "
							+ n.getJSONObject(0).getJSONObject("volumeInfo")
									.getJSONArray("industryIdentifiers")
									.getJSONObject(0).getString("type");
					Outpt = Outpt
							+ n.getJSONObject(0).getJSONObject("volumeInfo")
									.getJSONArray("industryIdentifiers")
									.getJSONObject(0).getString("identifier");

					Outpt = Outpt
							+ "\n"
							+ "ISBN13: "
							+ n.getJSONObject(0).getJSONObject("volumeInfo")
									.getJSONArray("industryIdentifiers")
									.getJSONObject(1).getString("type");
					Outpt = Outpt
							+ n.getJSONObject(0).getJSONObject("volumeInfo")
									.getJSONArray("industryIdentifiers")
									.getJSONObject(1).getString("identifier");

				} catch (JSONException e) {

				}

				try {

					if (Double.toString(n.getJSONObject(0)
							.getJSONObject("volumeInfo")
							.getDouble("averageRating")) == null) {

						Outpt = Outpt + "\n" + "averageRating: "
								+ "not available";

					} else {
						Outpt = Outpt
								+ "\n"
								+ "averageRating: "
								+ n.getJSONObject(0)
										.getJSONObject("volumeInfo")
										.getDouble("averageRating");
					}

				} catch (JSONException e) {

				}

				Outpt = Outpt
						+ "\n"
						+ "Country: "
						+ n.getJSONObject(0).getJSONObject("saleInfo")
								.getString("country");

				Outpt = Outpt
						+ "\n"
						+ "saleability: "
						+ n.getJSONObject(0).getJSONObject("saleInfo")
								.getString("saleability");
				Outpt = Outpt
						+ "\n"
						+ "isEbook: "
						+ n.getJSONObject(0).getJSONObject("saleInfo")
								.getBoolean("isEbook");

			}

			// print result

		} catch (IOException | URISyntaxException e) {

		} finally {

		}

		return Outpt;

	}

	public String getTitle(String isbn) {

		JSONObject objj = getJsonFormat(isbn);

		if (objj.getInt("totalItems") == 0) {

			Outpt = "totalItems: " + objj.getInt("totalItems")
					+ "\n\n No books Available!";
			System.out.println("get here 4");
		} else {

			System.out.println(" not get here 1");
			Outpt = "totalItems: " + objj.getInt("totalItems");

			JSONArray n = objj.getJSONArray("items");
			return n.getJSONObject(0).getJSONObject("volumeInfo")
					.getString("title");

		}
		return null;
	}

	public Integer getNumberOfAuthors(String isbn) {

		JSONObject objj = getJsonFormat(isbn);
		ArrayList<String> authorlst = new ArrayList<String>();

		if (objj.getInt("totalItems") == 0) {

			Outpt = "totalItems: " + objj.getInt("totalItems")
					+ "\n\n No books Available!";
			System.out.println("get here 4");
		} else {

			System.out.println(" not get here 1");
			Outpt = "totalItems: " + objj.getInt("totalItems");

			JSONArray n = objj.getJSONArray("items");
			System.out.println(n.getJSONObject(0).getJSONObject("volumeInfo")
					.getJSONArray("authors").length());

			// return n.getJSONObject(0).getJSONObject("volumeInfo")
			// .getJSONArray("authors").getString(0);
			return n.getJSONObject(0).getJSONObject("volumeInfo")
					.getJSONArray("authors").length();

		}
		return null;
	}
}// class end

// ------------------------------------------------------

