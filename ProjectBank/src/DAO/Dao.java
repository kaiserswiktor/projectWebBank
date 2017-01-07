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
	
	public boolean selectCheckUser(String login, String password) throws SQLException;// проверка данных
	public User selectDaoUser(String login, String password);//просмотр данных
	public Score selectDaoScore(int CreditCard );//просмотр данных
	public void insertPayment( int idScore, String typePayment, int sumPayment);//добавление данных
	public void drop();// удаление данных.

}
