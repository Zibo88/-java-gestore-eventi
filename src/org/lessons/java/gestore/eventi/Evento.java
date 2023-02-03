package org.lessons.java.gestore.eventi;

import java.time.LocalDate;

public class Evento {

	private String titolo="";
	private LocalDate data;
	private int numeroPostiTotale = 200;
	private int postiPrenotati = 0;
	
	public Evento(String titolo, LocalDate data, int numeroPostiTotale, int postiPrenotati) throws Exception {
		super();
		this.titolo = titolo;
		validateTitolo(titolo);
		this.data = data;
		validateDate(data);
		this.numeroPostiTotale = numeroPostiTotale;
		validateNumeroPosti(numeroPostiTotale);
		this.postiPrenotati = postiPrenotati;
	}
	
	public void validateTitolo(String titolo) throws Exception {
		if(titolo.length() > 0 ) {
			this.titolo = titolo;
		} else if(titolo.length() == 0 ){
			throw new Exception("il titolo dell'evento deve avere almeno un carattere");
		}
			
	}
	
	
	public void validateDate(LocalDate data) throws Exception {
		
		if( data.isEqual(LocalDate.now()) || data.isAfter(LocalDate.now())){
			this.data = data;
		}else if(this.data.isBefore(LocalDate.now())) {
			throw new Exception("la data inserita non è precedente a odierna");
		}
	}
	
	public void validateNumeroPosti(int numeroPostiTotale) throws Exception {
		if(numeroPostiTotale == 0 ) {
			throw new Exception("numero di posti prenotati supera il numero di posti disponibili");
		}
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumeroPostiTotale() {
		return numeroPostiTotale;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public void prenota() throws Exception {
		
		if(numeroPostiTotale > postiPrenotati || data.isEqual(LocalDate.now()) || data.isAfter(LocalDate.now())) {
			this.postiPrenotati++;
			System.out.println("prenotazione confermata");
		}else if(numeroPostiTotale == postiPrenotati){
			throw new Exception("Non ci sono più posti disponibile, mi dispiace");
		}else if(data.isBefore(LocalDate.now())) {
			throw new Exception("La data è pregressa alla data odierna");
		}
	}
	
	
//	per accedere ai messaggi .getMessage();
	public void disdici() throws Exception {
		if(postiPrenotati > 0 || data.isEqual(LocalDate.now())) {
			this.postiPrenotati--;
			System.out.println("prenotazione eliminata");
		}else if(postiPrenotati == 0) {
			throw new Exception("Non ci sono prenotazioni");
		}else if(data.isAfter(LocalDate.now())) {
			throw new Exception("La data è gia passata");
		}
	}

}
