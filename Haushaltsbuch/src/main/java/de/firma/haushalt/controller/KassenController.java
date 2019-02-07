package de.firma.haushalt.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.firma.haushalt.Kasse;
import de.firma.haushalt.Model.Zahlung;

@RestController
@RequestMapping("/kasse")
public class KassenController {

	private static final Kasse kasse = new Kasse();

	@RequestMapping(value = "/zahlung", method = RequestMethod.POST)
	public Kasse zahlung(@RequestBody Zahlung zahlung) {

		if (zahlung.getType().equalsIgnoreCase("einzahlung")) {
			kasse.einzahlen(zahlung);
		} else if (zahlung.getType().equalsIgnoreCase("auszahlung")) {
			kasse.auszahlen(zahlung);
		}
		return kasse;
	}

	@RequestMapping(value = "/uebersicht", method = RequestMethod.GET)
	public Kasse uebersicht(@RequestParam(value = "monat") String monat){
		if(monat.equalsIgnoreCase("Februar"))
			return kasse.Uebersicht();
		else
			return null;
	}
}
