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
	public void updateBalance( int balance, int idScore);//��������� �������
	public void updateCondition(int id�ard,String condition);//��������� ��������� �����
	public void drop();// �������� ������.
	

}
