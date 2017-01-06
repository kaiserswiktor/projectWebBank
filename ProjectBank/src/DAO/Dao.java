package DAO;

import tableDataBaza.User;

/**
 * 
 * @author User
 *
 */
public interface Dao {
	public User daoUser(String login, String password);
	public void insert();// добавление данных

	public void update();// изменение данных

	public void select();// просмотр данных

	public void drop();// удаление данных

}
