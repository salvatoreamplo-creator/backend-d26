package salvoamplo.esercitazione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salvoamplo.esercitazione.entities.Dipendente;
import salvoamplo.esercitazione.entities.Prenotazione;

import java.time.LocalDate;

public interface PrenotazioneRepository
        extends JpaRepository<Prenotazione, Long> {

    boolean existsByDipendenteAndDataRichiesta(
            Dipendente dipendente,
            LocalDate dataRichiesta
    );
}
