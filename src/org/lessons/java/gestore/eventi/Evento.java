package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo="";
	private LocalDate data;
	private int numeroPostiTotale = 200;
	private int postiPrenotati = 4;
	
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
		
		if( data.isEqual(LocalDate.now()) || data.isAfter(LocalDate.now()) ){
			this.data = data;
		}else if(this.data.isBefore(LocalDate.now()) || data.equals("")) {
			throw new Exception("la data inserita non permette prenotazioni");
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
	
	public void prenota(int numeroPostiTotale , int postiPrenotati) throws Exception {
		
		
		if (numeroPostiTotale - postiPrenotati >= postiPrenotati) {
			   postiPrenotati += this.postiPrenotati;
			   this.postiPrenotati++;
			   System.out.println("prenotazione confermata");
			} else {
			   throw new Exception("Non ci sono abbastanza posti disponibili");
			}
	}
	

	
//	per accedere ai messaggi .getMessage();
	public void disdici(int postiPrenotati, LocalDate data) throws Exception {
		if(postiPrenotati > 0 || this.data.isEqual(LocalDate.now())) {
			this.postiPrenotati--;
			System.out.println("prenotazione eliminata");
		}else if(postiPrenotati == 0) {
			throw new Exception("Non ci sono prenotazioni");
		}else if(this.data.isAfter(LocalDate.now())) {
			throw new Exception("La data è gia passata");
		}
	}

	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + data + ", numeroPostiTotale=" + numeroPostiTotale
				+ ", postiPrenotati=" + postiPrenotati + ", getTitolo()=" + getTitolo() + ", getData()=" + getData()
				+ ", getNumeroPostiTotale()=" + getNumeroPostiTotale() + ", getPostiPrenotati()=" + getPostiPrenotati()
				+ "]";
	}

//	@Override
//	public String toString() {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String dataFormattata = data.format(formatter);
//		return "Titolo: " + titolo + ", Data: " + dataFormattata;
//	}
	
	

}
