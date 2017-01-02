package requestsDataBaza;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.DaoScore;
import tableDataBaza.Score;

public class ReguestGetScore extends DaoScore  {

	@Override
	public void getScore() {
		Connection cn = null;
		//cn = Connect.getConnection();
		try {
			cn = DataSource.getInstance().getConnection();
		} catch (SQLException | PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Statement st = null;
			try { // 2 блок
				st = cn.createStatement();
				ResultSet rs = null;
				try { // 3 блок
					rs = st.executeQuery("SELECT * FROM score ");
					ArrayList<Score> lst = new ArrayList<>();

					while (rs.next()) {
						int ID_SCORE = rs.getInt(1);
						int ID_CARD = rs.getInt(2);
						int BALANCE = rs.getInt(3);
						String CONDITION_SCORE = rs.getString(4);
						
						lst.add(new Score(ID_SCORE, ID_CARD, BALANCE, CONDITION_SCORE));
					}

					if (lst.size() > 0) {
						System.out.println(lst);
					} else {
						System.out.println("Not found");
					}

				} finally { // для 3-го блока try
					/*
					 * закрыть ResultSet, если он был открыт или ошибка
					 * произошла во время чтения из него данных
					 */
					if (rs != null) { // был ли создан ResultSet
						rs.close();
					} else {
						System.err.println("ошибка во время чтения из БД");
					}
				}
			} finally {
				/*
				 * закрыть Statement, если он был открыт или ошибка произошла во
				 * время создания Statement
				 */
				if (st != null) { // для 2-го блока try
					st.close();
				} else {
					System.err.println("Statement не создан");
				}
			}
		} catch (SQLException e) { // для 1-го блока try
			System.err.println("DB connection error: " + e);
			/*
			 * вывод сообщения о всех SQLException
			 */
		} finally {
			/*
			 * закрыть Connection, если он был открыт
			 */
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					System.err.println("Connection close error: " + e);
				}
			}
		}

	}

	@Override
	public void addPayment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		
	}

		
	}


