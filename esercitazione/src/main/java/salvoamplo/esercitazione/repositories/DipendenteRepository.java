package salvoamplo.esercitazione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salvoamplo.esercitazione.entities.Dipendente;

public interface DipendenteRepository
        extends JpaRepository<Dipendente, Long> {
}
