package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) throws ParseException {
		//cria objeto do tipo Scanner que permite que a entrada de dados padrão diretamente do teclado ocorra
		Scanner sc = new Scanner(System.in);		
		//criando formatação padrão para um tipo date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number:");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in-date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Check-out-date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		//verifica se o checkout é posterior ao checkin, se não for mostra a mensagem se não instancia o objeto reservation
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
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Erro in reservation: Reservation dates for update must be future!");
			}
			else if(!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}
			
			
		}
		
		sc.close();
	}

}
