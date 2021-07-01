package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

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
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		//verifica se o checkout n�o est� ocorrendo antes do checkin
		if(!checkout.after(checkin)) {
			//lan�a esta exce��o caso entre no if
			throw new DomainException("Check-out date must be after check-in date");
		}
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
		long diff = checkout.getTime() - checkin.getTime();
		//converte de milliseconds para tempo em dias e retorna o resultado
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//atualizando o checkin e o checkout
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		//verifica se a data para o checkin � antes da data atual ou se a data de checkout � antes da data atual
		if(checkin.before(now) || checkout.before(now)) {
			//lan�a esta exce��o caso entre no if
			throw new DomainException("Reservation dates for update must be future!");
		}
		//verifica se o checkout n�o est� ocorrendo antes do checkin
		if(!checkout.after(checkin)) {
			//lan�a esta exce��o caso entre no if
			throw new DomainException("Check-out date must be after check-in date");
		}
		//atualiza o checkin e o checkout
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
