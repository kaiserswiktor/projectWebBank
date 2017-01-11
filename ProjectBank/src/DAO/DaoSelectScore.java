/**
 * 
 */
package DAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import tableDataBaza.Score;
import tableDataBaza.User;

/**
 * @author User
 *Class request to comparison Score. 
 */
public class DaoSelectScore implements Dao {
	public Score selectDaoScore(int CreditCard )  {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String user = resource.getString("score");
		ResultSet rs = null;
		Connection cn = null;
		Score score= null;
		try {
			cn = DataSource.getInstance().getConnection();// подключение пула
															// Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = null;
			try { // 2 блок
				try { // 3 блок 
					st = cn.prepareStatement(user);
					st.setInt(1, CreditCard);
					rs = st.executeQuery();
				
				while (rs.next()) {
					int ID_SCORE = rs.getInt(3);
					int ID_Card = rs.getInt(2);
					int balance = rs.getInt(4);
					String condition = rs.getString(5);			
					score = new Score(ID_SCORE, ID_Card, balance, condition );
				}
				}
				 finally { // для 3-го блока try
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
			} finally

			{
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
		return score;

	}

	@Override
	public boolean selectCheckUser(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User selectDaoUser(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPayment(int idScore, String typePayment, int sumPayment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBalance(int balance, int idScore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCondition(int idСard,String condition) {
		// TODO Auto-generated method stub
		
	}
}
