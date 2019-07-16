import java.util.Scanner;
public class main {
	
	public static void main(String[] args) {
	int[] Balance = new int[] {1000,5000,4000,3000,2000};
	int max,min,m,n;
	String[] account = {"KornWtp","Fluke","Leo","Frong","Nan"};
	
	int temp = 0; //temporary
	int select , loop = 1 ;
	Bank BankAccount = new Bank();
	Scanner inputNumber = new Scanner(System.in);
	
	while(loop == 1){
		
		System.out.println("1 = KornWtp , 2 = Fluke , 3 = Leo , 4 = Frong , 5 = Nan , 6 = Show All Balance");
	
		do{
			System.out.print("Enter Account : ");
			temp = inputNumber.nextInt();
			if (temp < 1 || temp > 6)
				System.out.println("Error! Try again");
		}while(temp < 1 || temp > 6);
		
		if (temp == 6) {
			max = Balance[0]; min = Balance[0]; m=0; n=0;
			for(int i = 0 ; i < 5 ; i++) {
				System.out.format("%-8s",account[i]);
				System.out.println("   Balance = $" + Balance[i]);
					
				if(max < Balance[i]) { 
					max = Balance[i]; m=i;
				}
				if(min > Balance[i]) {
					min = Balance[i]; n=i;
				}
			}
			System.out.println("The person with highest account balance is " + account[m] + " $"+ max);
			System.out.println("The person with lowest  account balance is " + account[n] + " $"+ min);	
			
			for(int i = 0 ; i < 5 ; i++) {
				System.out.format("%-15s",account[i]);
				int result[] = BankAccount.AccountActivity(i);
				
				if (result[0] == result[1])
					System.out.print("     Longest repeating activity : Deposit = Withdraw");
				if (result[0] < result[1])
					System.out.print("     Longest repeating activity : Withdraw "+ result[1] +" times");
				if (result[0] > result[1])
					System.out.print("     Longest repeating activity : Deposit "+ result[0] +" times");
//				System.out.println(result[0]);
//				System.out.println(result[1]);
				System.out.print("\n");
			}
				
		}
		else {
			System.out.println("Account "+ account[temp-1]);
			do{
				System.out.println("Banlance : 1");
				System.out.println("Deposit  : 2");
				System.out.println("Withdraw : 3");
				System.out.print("Press : ");
				select = inputNumber.nextInt();
				if (select < 1 || select > 3)
					System.out.println("Error! Try again");
			}while(select < 1 || select > 3);
			
			
			switch(select) {
				case 1 : BankAccount.ShowBalance(Balance[temp-1]); break;
				case 2 : Balance[temp-1] = BankAccount.deposit(Balance[temp-1],temp-1);   break;
				case 3 : Balance[temp-1] = BankAccount.withdraw(Balance[temp-1],temp-1);  break;
			
			}
			
			
		}
		System.out.print("\n");	
	}
	}
}
