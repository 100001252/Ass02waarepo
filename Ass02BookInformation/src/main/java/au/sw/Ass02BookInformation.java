package au.sw;

import java.sql.ResultSet;

public class Ass02BookInformation {
	// book has to be available in australia and rating between 3 to 5
	public boolean isRatingInRange(String isbn) {
		// is rating between 3 to 5
		boolean result = false;
		try {
			Db.DbBookInformation dbinfo = new Db("").new DbBookInformation();
			return dbinfo.isRatingInRange(isbn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public boolean isAvailableInAustralia(String isbn) {
		boolean result = false;
		try {
			Db.DbBookInformation dbinfo = new Db("").new DbBookInformation();
			return dbinfo.isAvailableInAustralia(isbn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public boolean validateAllThree(String isbn) {
		boolean result = false;
		try {
			if (isRatingInRange(isbn) && isAvailableInAustralia(isbn)
					&& isIsbnExist(isbn)) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public String validateAllThreeMessage(String isbn) {
		String message = "";
		try {
			if (!isIsbnExist(isbn)) {
				message = "This isbn does not exist in our bookshop";
				return message;

			}
			if (!isRatingInRange(isbn)) {
				message += "Rating for this book is less than 3 we cannot process.";
			}
			if (!isAvailableInAustralia(isbn)) {
				message += "This book is not available in australia.";
			}

			return message;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;

	}

	public boolean isIsbnExist(String isbn) {
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