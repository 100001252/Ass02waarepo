package testPackage;

import java.sql.ResultSet;

import au.edu.swin.waa.Ass02BookSoap;
import au.sw.*;
import au.sw.Db.DbBookInformation;

public class RunDb {

	public static void main(String[] args) {// ToDO
		try {
			// dbtestIsbnExist();
			// dbtestRating();
			// dbtestavialble();
			// testAllthreemessage();
			testdbGetbookInfo();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testdbGetbookInfo() {
		try {
			DbBookInformation di = new Db().new DbBookInformation();
			ResultSet rs = di.getAllDetailBook("1234566616");
			String output = "";
			while (rs.next()) {
				output += rs.getString("title") + "/#"
						+ rs.getString("authorList") + "/#"
						+ rs.getString("isbn") + "/#"
						+ rs.getString("publisher") + "/#"
						+ rs.getString("publishDate") + "/#"
						+ rs.getString("rating") + "/#"
						+ rs.getInt("availabilityaus") + "/#"
						+ rs.getInt("ebook");
			}
			Ass02BookSoap booksoap = new Ass02BookSoap();
			boolean insert = booksoap.orderBookByBpel(2, output);
			System.out.println(insert + "  output=" + output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testAllthreemessage() {
		try {
			Ass02BookInformation bi = new Ass02BookInformation();
			String isbn = "1234566666";
			boolean a = bi.validateAllThree(isbn);
			String b = bi.validateAllThreeMessage(isbn);
			System.out.println("true/fals: " + a + "|#message=" + b);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void dbtestavialble() {
		try {
			DbBookInformation dbinfo = new Db().new DbBookInformation();
			System.out.println(dbinfo.isAvailableInAustralia("1234566636"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void dbtestRating() {
		try {
			DbBookInformation dbinfo = new Db().new DbBookInformation();
			System.out.println(dbinfo.isRatingInRange("1234566666"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void dbtestIsbnExist() {
		try {
			DbBookInformation dbinfo = new Db().new DbBookInformation();
			System.out.println(dbinfo.isIsbnExist("1234777777"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
