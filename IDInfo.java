import java.util.Random;

public class IDInfo {
	private int IDNum;
	private String name;
	private int Month;
	private int Year;
	private int Day;
	private String Type;
	private double Acc_Balance;
	
	//initalize all the User info.
	public IDInfo(){
		IDNum = 0000000;
		name = "No name";
		Month = 1;
		Year = 1994;
		Day = 1;
		Type = "Checking";
		Acc_Balance = 0.0;
	}
	
	//initalize with all the information added.
	public IDInfo(int IDNumber, String IDName, int IDMonth, int IDDay, int IDYear, String IDType, double deposit){
		IDNum = IDNumber;
		name = IDName;
		Month = IDMonth;
		Year = IDYear;
		Day = IDDay;
		Type = IDType;
		Acc_Balance = deposit;
	}
	
	//set ID number
	public void setIDNum(int Num){
		IDNum = Num;
	}
	
	//set User Name 
	public void setName(String IDName){
		name = IDName;
	}
	
	//set DOB
	public void setBirth(int IDMonth, int IDDay, int IDYear){
			Month = IDMonth;
			Day = IDDay;
			Year = IDYear;
	}
	
	//set account type
	public void setType(String IDType){
		Type = IDType;
	}
	
	//get ID Number 
	public int getIDNum(){
		return this.IDNum;
	}
	
	public String getIDName(){
		return "User Name: " + name;
	}
	public String getIDBirthday(){
		return "DOB: " + Month + "/" + Day + "/" + Year;
	}
	public String getIDType(){
		return "Account Type: " + Type;
	}

	
	//print out user information.
	public void getIDInfo(){
		System.out.printf("ID Number: %07d \n", IDNum);
		System.out.println("User Name: " + name);
		System.out.print("DOB: "+Month);
		System.out.printf("/%02d/",Day);
		System.out.println(Year);
		System.out.println(Type);
	}
	
	
	
	/**************************************
	*Account balance
	**************************************/
	
	//return account balance.
	public double getBalance(){
		return Acc_Balance;
	}
	
	//calculate account balance after deposit
	public double deposit(double deposit) {
		
        if (deposit < 0) {
           // System.out.print("Error");
            return Acc_Balance;
        } 
		else{
        	Acc_Balance += deposit;
        	return Acc_Balance;
		}
    }
	
	//calculate account balance after withdraw
	public double withdrawal(double withdrawal) {
		
        if (withdrawal < 0 || withdrawal > Acc_Balance) {
            //System.out.print("Error");
            return Acc_Balance;
        } 
		else{
        	Acc_Balance -= withdrawal;
        	return Acc_Balance;
		}
    }

	
	public String ShowError(){
		return "Error";
	}
}