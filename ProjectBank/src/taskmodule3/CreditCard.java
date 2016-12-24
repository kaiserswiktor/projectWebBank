package taskmodule3;
/**
 * 
 * @author User
 * TABLE CREDIT_CARDS(ID_USER INT(10)  NOT NULL PRIMARY KEY,
ID_CARD INT (10) NULL);
 */
public class CreditCard {
private int idUser;
private int idCard;

public CreditCard(){
	
}
public CreditCard(int idUser,int idCard){
	this.idCard=idCard;
	this.idUser=idUser;
}
public int getIdCard(){
	return idCard;
}
public void setIdCard(int idCard){
	this.idCard=idCard;
}
public int getIdUser(){
	return idUser;
}
public void setIdUser(int idUser){
	this.idUser=idUser;
}
@Override
public String toString(){
	return "idCard-"+idCard+" idUser-"+idUser; 
}
}
