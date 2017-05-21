package testPackage;

import java.sql.ResultSet;

import au.sw.*;
import au.sw.Db.DbBookInformation;

public class RunDb {

	public static void main(String[] args) {// ToDO
		try {
			// dbtestIsbnExist();
			// dbtestRating();
			dbtestavialble();

		} catch (Exception e) {
			System.out.println(e.getMessage());
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
