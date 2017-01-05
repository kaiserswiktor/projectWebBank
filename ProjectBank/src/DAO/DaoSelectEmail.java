/**
 * 
 */
package DAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import requestsDataBaza.DataSource;
import tableDataBaza.User;

/**
 * @author User
 * @param <E_MAIL>
 *
 */
public class DaoSelectEmail<E_MAIL> extends DaoSelect {
	public void select() {
		Connection cn = null;
		try {
			cn = DataSource.getInstance().getConnection();// подключение пула Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			Statement st = null;
			try { // 2 блок
				st = cn.createStatement();
				ResultSet rs = null;
				try { // 3 блок
					rs = st.executeQuery("SELECT E_MAIL FROM user;");
					ArrayList< E_MAIL> lst = new ArrayList<>();

					while (rs.next()) {
						String E_mail = rs.getString(1);

						lst.add((E_MAIL) E_mail);
					}

					if (lst.size() > 0) {
						System.out.println(lst);
					} else {
						System.out.println("Not found");
					}

				} finally { // дл€ 3-го блока try
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
			} finally {
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

	}

	@Override
	public void insert() {

	}

	@Override
	public void update() {

	}

	@Override
	public void drop() {

	}

}
