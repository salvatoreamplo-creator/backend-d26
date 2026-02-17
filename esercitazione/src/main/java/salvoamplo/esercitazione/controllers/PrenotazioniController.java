package salvoamplo.esercitazione.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salvoamplo.esercitazione.entities.Prenotazione;
import salvoamplo.esercitazione.payloads.PrenotazioneRequest;
import salvoamplo.esercitazione.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    public Prenotazione creaPrenotazione(
            @RequestBody PrenotazioneRequest body) {
        return prenotazioneService.creaPrenotazione(body);
    }
}
