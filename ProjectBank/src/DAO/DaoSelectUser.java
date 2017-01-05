/**
 * 
 */
package DAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import requestsDataBaza.DataSource;
import tableDataBaza.User;

/**
 * @author User
 *
 */
public class DaoSelectUser extends DaoSelect {
	public void select() {
		String idUser;
		String firstName;
		String lastName;
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
					rs = st.executeQuery("SELECT ID_USER, FIRST_NAME,LAST_NAME FROM user WHERE E_MAIL='nikita@gmail.com'");
					ArrayList< User> lst = new ArrayList<>();

					while (rs.next()) {
						 idUser = rs.getString(1);
						 firstName = rs.getString(2);
						 lastName = rs.getString(3);
						
					

						System.out.println(idUser+firstName+lastName);}}


				 finally { // ��� 3-�� ����� try
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}
}