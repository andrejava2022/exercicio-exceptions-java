package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialB = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawL = sc.nextDouble();
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double withdraw = sc.nextDouble();
		Account account = new Account(number,holder,initialB,withdrawL);
		account.withdraw(withdraw);
		System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch(InputMismatchException e) {
			System.out.println();
			System.out.println("Error: Invalid format");
		}
		catch(DomainExceptions e) {
			System.out.println();
			System.out.println("Withdraw error: " + e.getMessage());			
		}
		
	}

}
