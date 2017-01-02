/**
 * 
 */
package tableDataBaza;

/**
 * @author User
 * TABLE PAYMENT (ID_PAYMENT INT (10) NOT NULL PRIMARY KEY,
ID_SCORE INT (10) NULL,TYPE_PAYMENT VARCHAR(10) NULL,SUM_PAYMENT INT(10) NULL);
 */
public class Payment {
   private int idPayment;
   private int idScore;
   private String typePayment;
   private int sumPayment;
	public Payment() {
	}
	public Payment(int idPayment,int idScore,String typePayment,int sumPayment) {
		this.idPayment=idPayment;
		this.idScore=idScore;
		this.typePayment=typePayment;
		this.sumPayment=sumPayment;
	}
	public int getIdPayment(){
		return idPayment;
	}
	public void setIdPayment(int idPayment){
		this.idPayment=idPayment;
	}
	public int getIdScore(){
		return idScore;
	}
	public void setIdScore(int idScore){
		this.idScore=idScore;
	}
	public String getTypePayment(){
		return typePayment;
	}
	public void setTypePayment(String typePayment){
		this.typePayment=typePayment;
	}
	public int getSumPayment(){
		return sumPayment;
	}
	public void setSumPayment(int sumPayment){
		this.sumPayment=sumPayment;
	}
	@Override
	public String toString(){
		return "idPayment-"+idPayment+" idScore-"+idScore+" typePayment-"+typePayment+" sumPayment-"+sumPayment;
	}
}
