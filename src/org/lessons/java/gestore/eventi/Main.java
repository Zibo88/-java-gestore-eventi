package org.lessons.java.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	
		
				String titolo = "";
				int numeroPostiTotale = 30;
				int postiPrenotati = 0;
				String userChoice ="";
				int postiDisponibili = 0;
				String prezzo = "0";
				String ora="";
				
				
				
				Scanner input = new Scanner(System.in);
				LocalDate dataOdierna = LocalDate.now();
				
				Evento newEvento;
				Concerto newConcerto = null;
				
				System.out.println("A che evento vuoi partecipare?");
				titolo = input.nextLine().toLowerCase().trim();
				
				LocalDate dataEvento = LocalDate.now();
				
				
					
					System.out.println("Data? (dd/MM/yyyy)");
					String dataInput = input.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					
					try {
						dataEvento = LocalDate.parse(dataInput, formatter);
					} catch (DateTimeParseException e) {
						System.out.println("Data non valida, inserire una data nel formato gg/mm/aaaa");
					}
			
				
				if(titolo.equals("concerto")) {
					System.out.println("a che ora è l'evento? hh:mm");
					ora = input.next();
					DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH:mm").withLocale(Locale.ITALIAN);
					LocalTime oraFormattata = LocalTime.parse(ora, formatterH);
					System.out.println(oraFormattata);
					
				}
				
				System.out.println("Il numero di posti totali per questo evento è..?");
				numeroPostiTotale = input.nextInt();
				input.nextLine();
				System.out.println(numeroPostiTotale);
				
				if(titolo.equals("concerto")) {
					System.out.println("il prezzo è di");
					prezzo = input.nextLine();
					System.out.println(prezzo);
				}
				
				try {
					if(titolo.equals("concerto")) {
						newConcerto = new Concerto(titolo, dataEvento, numeroPostiTotale, postiPrenotati,ora, prezzo );
						newConcerto.prenota(numeroPostiTotale, postiPrenotati);
						newConcerto.setTitolo(titolo);
						newConcerto.setPrezzo(prezzo);
						newConcerto.setData(dataEvento);
				}
					newEvento = new Evento(titolo, dataEvento, numeroPostiTotale, postiPrenotati);
					newEvento.prenota(numeroPostiTotale , postiPrenotati);
					
					
					while(!userChoice.equals("no")) {
						System.out.println("Vuole eseguire un'altra prenotazione? Scriva si per continuare, no per chiudere, disdici per disdire");
						userChoice = input.nextLine().toLowerCase().trim();
					
						if(userChoice.equals("si")) {
							newEvento.prenota(numeroPostiTotale , newEvento.getPostiPrenotati());
							postiDisponibili = numeroPostiTotale - newEvento.getPostiPrenotati();
							if(titolo.equals("concerto") && newConcerto != null) {
								System.out.println(newConcerto.prezzoFormattato(prezzo));
							}
							System.out.println(newEvento.toString()  + "posti disponibili" + postiDisponibili);
							
							

						}else if(userChoice.equals("no")) {
							System.out.println("hai deciso di chiudere");
							postiDisponibili = numeroPostiTotale - newEvento.getPostiPrenotati();
							if(titolo.equals("concerto") && newConcerto != null) {
								System.out.println((newConcerto.toString() + newConcerto.prezzoFormattato(prezzo) +" "+ newConcerto.getOra() + " " + newEvento.getData().format(formatter) ));
							}else {
								System.out.println(newEvento.toString() + "posti disponibili" + postiDisponibili);
							}
							
						}else if(userChoice.equals("disdici")) {
							newEvento.disdici(newEvento.getPostiPrenotati(), newEvento.getData() );
							postiDisponibili = numeroPostiTotale - newEvento.getPostiPrenotati();
							System.out.println(newEvento.toString()  + "posti disponibili" + " " + postiDisponibili);
							
						}
							
				}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

		}

}
