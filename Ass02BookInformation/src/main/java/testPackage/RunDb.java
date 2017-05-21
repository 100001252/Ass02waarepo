package testPackage;

import java.sql.ResultSet;

import au.sw.*;
import au.sw.Db.DbBookInformation;

public class RunDb {

	public static void main(String[] args) {// ToDO
		try {
			// dbtestIsbnExist();

		} catch (Exception e) {
			System.out.println(e.getMessage());
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
