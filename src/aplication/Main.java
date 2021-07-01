package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Main {

	public static void main(String[] args) {
		//cria objeto do tipo Scanner que permite que a entrada de dados padr�o diretamente do teclado ocorra
		Scanner sc = new Scanner(System.in);		
		//criando formata��o padr�o para um tipo date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//executa todo o c�digo dentro do bloco try se n�o ocorrer alguma exce��o, se ocorrer ela � interrompida e vai para o bloco catch da exce��o em quest�o
		try {
			System.out.println("Room number:");
			int roomNumber = sc.nextInt();
			System.out.println("Check-in-date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Check-out-date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date update the reservation: ");
			System.out.println("Check-in-date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.println("Check-out-date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		//executa o bloco caso tenha ocorrido esta exce��o de data inv�lida
		catch(ParseException e) {
			System.out.println("Invalid date format!");
		}
		//executa o bloco caso tenha ocorrido esta exce��o de argumento inv�lido
		catch(DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		}
		//caso ocorra qualquer outra exce��o que seja inesperada, este bloco catch � executado
		catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		//no final da execu��o encerra o objeto sc de tipo Scanner
		sc.close();
	}

}
