package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	//criando formata��o padr�o para um tipo date
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//criando construtor padr�o
	public Reservation() {
	}
	
	//criando construtor personalizado com base nos par�metros
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	//retornando o atributo roomNumber
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	//setando um novo valor para o atributo roomNumber
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	//retornando o atributo roomNumber
	public Date getcheckin() {
		return checkin;
	}
	
	//retornando o atributo roomNumber
	public Date getcheckout() {
		return checkout;
	}
	
	//m�todo que calcula a dura��o
	public long duration() {
		//calcula a diferen�a entre o checkin e o checkout utilizando o m�todo getTime para calcular em milisegundos
		long diff = checkin.getTime() - checkout.getTime();
		//converte de milliseconds para tempo em dias e retorna o resultado
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//atualizando o checkin e o checkout
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in"
			+ sdf.format(checkin)
			+ ", check-out"
			+ sdf.format(checkout)
			+ ", "
			+ duration()
			+ " nights";
	}

}
