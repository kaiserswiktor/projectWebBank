package requestsDataBaza;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import DAO.DaoSelectEmail;
import DAO.DaoSelectPassword;
import tableDataBaza.User;

public class Main {
	public static  void main(String args[])
			throws IOException, PropertyVetoException, SQLException, InstantiationException, IllegalAccessException {
		DaoSelectEmail m= new DaoSelectEmail();	
		m.select();
	
		/*Connection cn = null;
		//cn = Connect.getConnection();
		cn = DataSource.getInstance().getConnection();
		try {
			Statement st = null;
			try { // 2 ����
				st = cn.createStatement();
				ResultSet rs = null;
				try { // 3 ����
					rs = st.executeQuery("SELECT * FROM user ");
					ArrayList<User> lst = new ArrayList<>();

					while (rs.next()) {
						int idUser = rs.getInt(1);
						String firstName = rs.getString(2);
						String lastName = rs.getString(3);
						String eMail = rs.getString(4);
						String password = rs.getString(5);
						String role = rs.getString(6);

						lst.add(new User(idUser, firstName, lastName, eMail, password, role));
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
			 
		} finally {
			/*
			 * ������� Connection, ���� �� ��� ������
			 
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					System.err.println("Connection close error: " + e);
				}
			}
		}

	}*/

}
}