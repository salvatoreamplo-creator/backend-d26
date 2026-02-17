package salvoamplo.esercitazione.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvoamplo.esercitazione.entities.Dipendente;
import salvoamplo.esercitazione.entities.Prenotazione;
import salvoamplo.esercitazione.entities.Viaggio;
import salvoamplo.esercitazione.exceptions.BadRequestException;
import salvoamplo.esercitazione.exceptions.NotFoundException;
import salvoamplo.esercitazione.payloads.PrenotazioneRequest;
import salvoamplo.esercitazione.repositories.DipendenteRepository;
import salvoamplo.esercitazione.repositories.PrenotazioneRepository;
import salvoamplo.esercitazione.repositories.ViaggioRepository;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Prenotazione creaPrenotazione(PrenotazioneRequest body) {

        Dipendente dipendente = dipendenteRepository
                .findById(body.getDipendenteId())
                .orElseThrow(() -> new NotFoundException("Dipendente non trovato"));

        Viaggio viaggio = viaggioRepository
                .findById(body.getViaggioId())
                .orElseThrow(() -> new NotFoundException("Viaggio non trovato"));

        if (prenotazioneRepository
                .existsByDipendenteAndDataRichiesta(
                        dipendente,
                        body.getDataRichiesta())) {
            throw new BadRequestException(
                    "Il dipendente ha già una prenotazione per questa data"
            );
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(body.getDataRichiesta());
        prenotazione.setNote(body.getNote());

        return prenotazioneRepository.save(prenotazione);
    }
}
