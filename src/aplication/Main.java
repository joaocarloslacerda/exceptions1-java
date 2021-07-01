package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Main {

	public static void main(String[] args) {
		//cria objeto do tipo Scanner que permite que a entrada de dados padrão diretamente do teclado ocorra
		Scanner sc = new Scanner(System.in);		
		//criando formatação padrão para um tipo date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//executa todo o código dentro do bloco try se não ocorrer alguma exceção, se ocorrer ela é interrompida e vai para o bloco catch da exceção em questão
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
		//executa o bloco caso tenha ocorrido esta exceção de data inválida
		catch(ParseException e) {
			System.out.println("Invalid date format!");
		}
		//executa o bloco caso tenha ocorrido esta exceção de argumento inválido
		catch(DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		}
		//caso ocorra qualquer outra exceção que seja inesperada, este bloco catch é executado
		catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		//no final da execução encerra o objeto sc de tipo Scanner
		sc.close();
	}

}
