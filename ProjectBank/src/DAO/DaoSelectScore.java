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

import requestsDataBaza.DataSource;
import tableDataBaza.CreditCard;
import tableDataBaza.Score;

/**
 * @author User
 *
 */
public class DaoSelectScore {
	public Score daoScore(int CreditCard )  {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String user = resource.getString("score");
		ResultSet rs = null;
		Connection cn = null;
		Score score= null;
		CreditCard creditCard=null;
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
					int ID_SCORE = rs.getInt(1);
					int ID_Card = rs.getInt(3);
					int balance = rs.getInt(4);
					String condition = rs.getString(5);			
					score = new Score(CreditCard, CreditCard, CreditCard, user );
					 System.out.println(ID_SCORE+"-"+ID_Card+"-"+balance+"-"+condition);
				}
				}
				 finally { // дл€ 3-го блока try
					/*
					 * закрыть ResultSet, если он был открыт или ошибка
					 * произошла во врем€ чтени€ из него данных
					 */
					if (rs != null) { // был ли создан ResultSet
						rs.close();
					} else {
						System.err.println("ошибка во врем€ чтени€ из Ѕƒ");
					}
				}
			} finally

			{
				/*
				 * закрыть Statement, если он был открыт или ошибка произошла во
				 * врем€ создани€ Statement
				 */
				if (st != null) { // дл€ 2-го блока try
					st.close();
				} else {
					System.err.println("Statement не создан");
				}
			}
		} catch (SQLException e) { // дл€ 1-го блока try
			System.err.println("DB connection error: " + e);
			/*
			 * вывод сообщени€ о всех SQLException
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
}
