package DAO;

import tableDataBaza.User;

/**
 * 
 * @author User
 *
 */
public interface Dao {
	public User daoUser(String login, String password);
	public void insert();// ���������� ������

	public void update();// ��������� ������

	public void select();// �������� ������

	public void drop();// �������� ������

}
