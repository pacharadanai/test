import java.util.Scanner;

public class Bank {
	
	String[][] transactions = new String[5][100]; int j = 0;
	Scanner getin = new Scanner(System.in);
	
	void ShowBalance(int money){
		
		System.out.println("Balance = $" + money);
	}
	
	int withdraw(int money,int i){
		System.out.print("amount = $ ");
		int amout = getin.nextInt();
		if(money >= amout) {
			money -= amout;
			transactions[i][j]="W"; j++;
			System.out.println("Withdrawal Success");
			System.out.println("Balance = "+money);
		}
		else {
			System.out.println("Insufficient funds!");
		}
		return money;
	}
	
	int deposit(int money,int i){
		System.out.print("amount = $ ");
		int amout = getin.nextInt();
		if(amout < 0) {
			System.out.println("ERROR!!!");
		}
		else {
			money += amout;
			transactions[i][j]="D"; j++;
			System.out.println("Deposit Success");
			System.out.println("Balance = "+money);
		}
			
	return money;
		
	}
	
	int[] AccountActivity(int i){
		int statusD=0,statusW=0;
		for(int j = 0 ; j < 50 ; j++) {
			if (transactions[i][j] != null)
				System.out.print(transactions[i][j]);
			if (transactions[i][j] == "D")
				statusD++;
			if (transactions[i][j] == "W")
				statusW++;
		}
//		System.out.println(statusD);
//		System.out.println(statusW);
		return new int[] {statusD,statusW};
	}
	

}