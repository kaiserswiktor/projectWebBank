package DAO;

import java.sql.SQLException;

import tableDataBaza.Score;
import tableDataBaza.User;

/**
 * 
 * @author User
 *
 */
public interface Dao {
	
	public boolean selectCheckUser(String login, String password) throws SQLException;// �������� ������
	public User selectDaoUser(String login, String password);//�������� ������
	public Score selectDaoScore(int CreditCard );//�������� ������
	public void insertPayment( int idScore, String typePayment, int sumPayment);//���������� ������
	public void drop();// �������� ������

}
