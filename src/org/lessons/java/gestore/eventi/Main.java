package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
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
				
				Scanner input = new Scanner(System.in);
				LocalDate dataOdierna = LocalDate.now();
				
				Evento newEvento;
				
				System.out.println("Creo un nuovo evento");
				System.out.println("Titolo:");
				titolo = input.nextLine();
				LocalDate dataEvento = null;
				
				while (dataEvento == null) {
					System.out.println("Data? (dd/MM/yyyy)");
					String dataInput = input.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						dataEvento = LocalDate.parse(dataInput, formatter);
					} catch (DateTimeParseException e) {
						System.out.println("Data non valida, inserire una data nel formato gg/mm/aaaa");
					}
				}
				
				System.out.println("Il numero di posti totali per questo evento è..?");
				numeroPostiTotale = input.nextInt();
				input.nextLine();

				
				try {
					newEvento = new Evento(titolo, dataEvento, numeroPostiTotale, postiPrenotati);
					newEvento.prenota(numeroPostiTotale , postiPrenotati);
					while(!userChoice.equals("no")) {
						System.out.println("Vuole eseguire un'altra prenotazione? Scriva si per continuare, no per chiudere, disdici per disdire");
						userChoice = input.nextLine().toLowerCase().trim();
					
						if(userChoice.equals("si")) {
							newEvento.prenota(numeroPostiTotale , newEvento.getPostiPrenotati());
							System.out.println(newEvento.toString());
						}else if(userChoice.equals("no")) {
							System.out.println("hai deciso di chiudere");
							System.out.println(newEvento.toString());
						}else if(userChoice.equals("disdici")) {
							newEvento.disdici(newEvento.getPostiPrenotati(), newEvento.getData() );
							System.out.println(newEvento.toString());
						}
							
				}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

		}

}
