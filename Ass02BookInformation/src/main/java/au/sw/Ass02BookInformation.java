package au.sw;

import java.sql.ResultSet;

import au.sw.Db.DbBookInformation;

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

	public String getAllDetailBook(String isbn) {
		String output = "";
		try {
			DbBookInformation di = new Db().new DbBookInformation();
			ResultSet rs = di.getAllDetailBook("1234566616");

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
			return output;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;

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

	public boolean isEbookAvailable(String isbn) {
		boolean result = false;
		try {
			Db.DbBookInformation dbinfo = new Db("").new DbBookInformation();
			return dbinfo.isEbookAvailable(isbn);

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
			if (isRatingInRange(isbn) && isEbookAvailable(isbn)
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

			} else if (!isRatingInRange(isbn)) {
				message += "Rating for this book is less than 3 we cannot process.";
			} else if (!isAvailableInAustralia(isbn) && !isEbookAvailable(isbn)) {
				message += "This book is not available in australia and Ebook is not availble for this book.";
			} else {
				message = getAllDetailBook(isbn);
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