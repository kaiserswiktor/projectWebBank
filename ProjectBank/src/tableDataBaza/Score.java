/**
 * 
 */
package tableDataBaza;

/**
 * @author User
 * TABLE SCORE (ID_SCORE INT (10) NOT NULL PRIMARY KEY,ID_CARD INT (10) NULL,
BALANCE INT(10) NULL ,CONDITION_SCORE VARCHAR(10) NULL);
 */
public class Score {
private int idScore;
private int idCard;
private int balance;
private String ConditionScore;

	public Score(int idScore,int idCard,int balance,String ConditionScore) {
	this.idScore=idScore;
	this.idCard=idCard;
	this.balance=balance;
	this.ConditionScore=ConditionScore;
	}
	public int getIdScore(){
		return idScore;
	}
	public void setIdScore(int idScore){
		this.idScore=idScore;
	}
	public int getIdCard(){
		return idCard;
	}
	public void setIdCard(int idCard){
		this.idCard=idCard;
	}
	public int getBalance(){
		return balance;
	}
	public void setBalance(int balance){
		this.balance=balance;
	}
	public String getConditionScore(){
		return ConditionScore;
	}
	public void setConditionScore(String conditionScore){
		this.ConditionScore=conditionScore;
	}
	@Override
	public String toString(){
		return "idScore-"+idScore+" idCard-"+idCard+" balance-"+balance+" ConditionScore-"+ConditionScore;
	}
}
