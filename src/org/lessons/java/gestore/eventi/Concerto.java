package org.lessons.java.gestore.eventi;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {
	
	private final DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("HH:mm").withLocale(Locale.ITALY);
	private LocalTime ora;
	private BigDecimal prezzo;
	public Concerto(String titolo, LocalDate data, int numeroPostiTotale, int postiPrenotati, String ora,
			String prezzo) throws Exception {
		super(titolo, data, numeroPostiTotale, postiPrenotati);
		this.ora = dataFormattata(ora);
		this.prezzo = setPrezzo(prezzo);
	}
	public LocalTime getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = dataFormattata(ora);
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public BigDecimal setPrezzo(String prezzoUtente) {
		BigDecimal prezzo = new BigDecimal(prezzoUtente);
		return prezzo;
	}
	
	
	public LocalTime dataFormattata(String data) {
		LocalTime orarioFormatatto = LocalTime.parse(data,formattatore);
		return orarioFormatatto;
	}
	
	public String prezzoFormattato(String prezzoUtente ) {
		BigDecimal prezzo = new BigDecimal(prezzoUtente);
	    return NumberFormat.getCurrencyInstance(Locale.ITALY).format(prezzo);
	}
	
	@Override
	public String toString() {
		return "Concerto [ ora=" + ora + ", prezzo=" + prezzo + ", getOra()="
				+ getOra() + ", getPrezzo()=" + getPrezzo() + "]";
	}
	
	
	
}
