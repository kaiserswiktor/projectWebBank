/**
 * 
 */
package DAO;

import tableDataBaza.Score;

/**
 * @author User
 *
 */
public abstract class DaoScore implements Dao {
	public abstract void updateBalance(int balance, int idScore);

	public abstract void updateCondition(int id—ard, String condition);

	public abstract Score selectDaoScore(int CreditCard);
}
