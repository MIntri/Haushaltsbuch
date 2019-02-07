package de.firma.haushalt.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;;


@JsonInclude(Include.NON_NULL)
public class Zahlung {
	private String type;
	private String kategorie;
	private double betrag;
	private String memo;
	private String datum;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getBetrag() {
		return betrag;
	}
	public void setBetrag(Double betrag) {
		this.betrag = betrag;
	}
	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	
}
