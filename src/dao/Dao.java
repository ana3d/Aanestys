package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Vote;

public class Dao {

	private Connection yhdista() throws SQLException, Exception {
		Connection yhteys = null;
		String username = "CHANGE ME";
		String password = "CHANGE ME";
		String JDBCAjuri = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://CHANGE ME";

		try {
			Class.forName(JDBCAjuri); // ajurin m‰‰ritys

			// otetaan yhteys tietokantaan
			yhteys = DriverManager.getConnection(url, username, password);

		} catch (SQLException sqlE) {
			System.err.println("Tietokantayhteyden avaaminen ei onnistunut. "
					+ url + "\n" + sqlE.getMessage() + " " + sqlE.toString()
					+ "\n");
			sqlE.printStackTrace();
			throw (sqlE);
		} catch (Exception e) {
			System.err.println("TIETOKANTALIITTYN VIRHETILANNE: "
					+ "JDBC:n omaa tietokanta-ajuria ei loydy.\n\n"
					+ e.getMessage() + " " + e.toString() + "\n");
			e.printStackTrace();
			System.out.print("\n");
			throw (e);
		}

		return yhteys;
	}

	public ArrayList<Vote> haeKaikkiTiedot() throws SQLException, Exception {
		ArrayList<Vote> data = null;
		Vote vote = null;
		String sql = "SELECT * FROM vote ORDER BY id DESC";
		PreparedStatement preparedStatement = null; // suoritettava SQL-lause
		ResultSet tulokset = null; // SQL-kyselyn tulokset
		Connection conn = null;
		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);
				tulokset = preparedStatement.executeQuery();
				if (tulokset != null) {
					conn.close(); // sulje yhteys kantaan
					if (data == null) {
						data = new ArrayList<Vote>();
					}
					while (tulokset.next()) {
						try {
							vote = new Vote();
							vote.setId(tulokset.getInt("id"));
							vote.setSubject(tulokset.getString("subject"));
							vote.setCount(tulokset.getInt("count"));
							vote.setVote_yes(tulokset.getInt("vote_yes"));
							vote.setVote_no(tulokset.getInt("vote_no"));
							data.add(vote);

						} catch (Exception e) {
							// TODO: handle exception
							System.out.print("hops");
						}

					}
					tulokset.close();
				} else {
					conn.close();
					data = null;
				}
			}

		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return data;
	}

	public void lisaaAanestys(Vote vote) throws SQLException, Exception {

		String sql = "INSERT INTO vote(subject, count, vote_yes, vote_no) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement;
		Connection conn = null;
		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);

				preparedStatement.setString(1, vote.getSubject());
				preparedStatement.setInt(2, vote.getCount());
				preparedStatement.setInt(3, vote.getVote_yes());
				preparedStatement.setInt(4, vote.getVote_no());
				preparedStatement.execute(); // Ajetaan SQL lause

			}

		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					throw e;
				}
			}
		}

	}

	public void updateVote(int id, String type) throws SQLException, Exception {

		String sql = "UPDATE vote SET count = ?, vote_yes = ? , vote_no = ? WHERE id = ?";
		PreparedStatement preparedStatement;
		Connection conn = null;

		Vote vote = haeRivi(id);

		int new_count, new_vote_yes, new_vote_no;
		new_count = vote.getCount() + 1;

		if (type.equalsIgnoreCase("yes")) {
			new_vote_yes = vote.getVote_yes() + 1;
			new_vote_no = vote.getVote_no();
		} else {
			new_vote_no = vote.getVote_no() + 1;
			new_vote_yes = vote.getVote_yes();
		}

		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, new_count);
				preparedStatement.setInt(2, new_vote_yes);
				preparedStatement.setInt(3, new_vote_no);
				preparedStatement.setInt(4, id);
				preparedStatement.execute(); // Ajetaan SQL lause

			}

		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					throw e;
				}
			}
		}

	}

	public Vote haeRivi(int id) throws SQLException, Exception {

		Vote data = null;
		String sql = "SELECT id, subject, count, vote_yes, vote_no FROM vote WHERE id = ? ";
		PreparedStatement preparedStatement = null; // suoritettava SQL-lause
		ResultSet tulokset = null; // SQL-kyselyn tulokset
		Connection conn = null;
		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				tulokset = preparedStatement.executeQuery();
				if (tulokset != null) {
					conn.close(); // sulje yhteys kantaan

					while (tulokset.next()) {
						data = new Vote();
						data.setId(tulokset.getInt("id"));
						data.setSubject(tulokset.getString("subject"));
						data.setCount(tulokset.getInt("count"));
						data.setVote_yes(tulokset.getInt("vote_yes"));
						data.setVote_no(tulokset.getInt("vote_no"));

					}
					tulokset.close();
				} else {
					conn.close();
					data = null;
				}
			}

		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return data;
	}

}
