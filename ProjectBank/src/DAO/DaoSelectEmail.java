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
			cn = DataSource.getInstance().getConnection();// ����������� ���� Connection
		} catch (SQLException | PropertyVetoException e1) {
			e1.printStackTrace();
		}
		try {
			Statement st = null;
			try { // 2 ����
				st = cn.createStatement();
				ResultSet rs = null;
				try { // 3 ����
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

				} finally { // ��� 3-�� ����� try
					/*
					 * ������� ResultSet, ���� �� ��� ������ ��� ������
					 * ��������� �� ����� ������ �� ���� ������
					 */
					if (rs != null) { // ��� �� ������ ResultSet
						rs.close();
					} else {
						System.err.println("������ �� ����� ������ �� ��");
					}
				}
			} finally {
				/*
				 * ������� Statement, ���� �� ��� ������ ��� ������ ��������� ��
				 * ����� �������� Statement
				 */
				if (st != null) { // ��� 2-�� ����� try
					st.close();
				} else {
					System.err.println("Statement �� ������");
				}
			}
		} catch (SQLException e) { // ��� 1-�� ����� try
			System.err.println("DB connection error: " + e);
			/*
			 * ����� ��������� � ���� SQLException
			 */
		} finally {
			/*
			 * ������� Connection, ���� �� ��� ������
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
