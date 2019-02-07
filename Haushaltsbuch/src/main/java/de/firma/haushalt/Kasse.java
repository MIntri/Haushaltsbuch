package de.firma.haushalt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import de.firma.haushalt.Model.Zahlung;

public class Kasse {

	private String name;
	private double kassenbestand;
	private ArrayList<Zahlung> einzahlungen;
	private ArrayList<Zahlung> auszahlungen;
	private ArrayList<String> kategorien;

	public Kasse() {
		name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM YYYY")).toString();
		einzahlungen = new ArrayList<Zahlung>();
		auszahlungen = new ArrayList<Zahlung>();
		kategorien = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getKassenbestand() {
		return kassenbestand;
	}

	public void setKassenbestand(double kassenbestand) {
		this.kassenbestand = kassenbestand;
	}

	public ArrayList<Zahlung> getEinzahlungen() {
		return einzahlungen;
	}

	public void setEinzahlungen(ArrayList<Zahlung> einzahlungen) {
		this.einzahlungen = einzahlungen;
	}

	public ArrayList<Zahlung> getAuszahlungen() {

		return auszahlungen;
	}

	public void setAuszahlungen(ArrayList<Zahlung> auszahlungen) {
		this.auszahlungen = auszahlungen;
	}

	public void einzahlen(Zahlung zahlung) {
		if (!kategorien.contains(zahlung.getKategorie()))
			kategorien.add(zahlung.getKategorie());
		zahlung.setDatum(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY")).toString());
		einzahlungen.add(zahlung);
		kassenbestand += zahlung.getBetrag();
	}

	public void auszahlen(Zahlung zahlung) {
		if (!kategorien.contains(zahlung.getKategorie()))
			kategorien.add(zahlung.getKategorie());
		auszahlungen.add(zahlung);
		kassenbestand -= zahlung.getBetrag();
	}

	public Kasse Uebersicht() {
		Kasse kasse = new Kasse();
		kasse.name = this.name;
		kasse.kassenbestand=this.kassenbestand;
		
		kasse.setAuszahlungen(addAuszahlungen(auszahlungen));
		kasse.setEinzahlungen(addAuszahlungen(einzahlungen));
		return kasse;
	}

	private ArrayList<Zahlung> addAuszahlungen(ArrayList<Zahlung> rawZahlungen) {
		ArrayList<Zahlung> sumAuszahlungen = new ArrayList<>();
		boolean calculated=false;

		for (String kategorie : kategorien) {
			calculated=false;
			Zahlung sumZahlung = new Zahlung();
			sumZahlung.setKategorie(kategorie);
			
			for (Zahlung zahlung : rawZahlungen) {
				if (zahlung.getKategorie().equalsIgnoreCase(kategorie)){
					calculated=true;
					sumZahlung.setBetrag(sumZahlung.getBetrag() + zahlung.getBetrag());
				}
			}
			if(calculated)
				sumAuszahlungen.add(sumZahlung);

		}
		return sumAuszahlungen;
	}

	public String bla() {
		return "foobar";
	}

}
