package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) throws ParseException {
		//cria objeto do tipo Scanner que permite que a entrada de dados padr�o diretamente do teclado ocorra
		Scanner sc = new Scanner(System.in);		
		//criando formata��o padr�o para um tipo date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number:");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in-date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Check-out-date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		//verifica se o checkout � posterior ao checkin, se n�o for mostra a mensagem se n�o instancia o objeto reservation
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date update the reservation: ");
			System.out.println("Check-in-date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.println("Check-out-date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			//chama o m�todo updateDates na classe reservation passando checkin e checkout como parametro e adicionando no atributo error a String que o m�todo retornou
			String error = reservation.updateDates(checkin, checkout);
			//se o updateDates tiver retornado algo diferente de null
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}
			//se o updateDates tiver retornado null
			else {
				System.out.println("Reservation: " + reservation);
			}
		}
		//no final da execu��o encerra o objeto sc de tipo Scanner
		sc.close();
	}

}
