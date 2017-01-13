/**
 * 
 */
package DAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author User request to add Payment
 */
public class DaoInsertPaymentImpl {
	public void insertPayment(int idScore, String typePayment, int sumPayment) {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String payment = resource.getString("payment");
		Connection cn = null;
		try {
			cn = DataSource.getInstance().getConnection();// подключение пула Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement st = null;
			try { // 2 блок
				try { // 3 блок
					st = cn.prepareStatement(payment);
					// st.setInteger(1, idPayment);
					st.setInt(1, idScore);
					st.setString(2, typePayment);
					st.setInt(3, sumPayment);
					st.executeUpdate();
					/*
					 * if (st != null) { st.close();}
					 */
				} finally

				{
					/*
					 * закрыть Statement, если он был открыт или ошибка
					 * произошла во время создания Statement
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
		} finally {

		}
	}
}
