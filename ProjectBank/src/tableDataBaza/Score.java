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
private String conditionScore;
public Score() {
}
	public Score(int idScore,int idCard,int balance,String conditionScore) {
	this.idScore=idScore;
	this.idCard=idCard;
	this.balance=balance;
	this.conditionScore=conditionScore;
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
	public String getconditionScore(){
		return conditionScore;
	}
	public void setconditionScore(String conditionScore){
		this.conditionScore=conditionScore;
	}
	@Override
	public String toString(){
		return "idScore-"+idScore+" idCard-"+idCard+" balance-"+balance+" conditionScore-"+conditionScore;
	}
}
