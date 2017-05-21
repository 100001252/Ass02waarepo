package au.sw;

import java.sql.ResultSet;

public class Ass02BookInformation {
	// book has to be available in australia and rating between 3 to 5
	public boolean isRatingInRange(String isbn) {
		boolean result = false;
		try {
			Db.DbBookInformation dbinfo = new Db("").new DbBookInformation();
			return dbinfo.isIsbnExist(isbn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}