package salvoamplo.esercitazione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salvoamplo.esercitazione.entities.Viaggio;

public interface ViaggioRepository
        extends JpaRepository<Viaggio, Long> {
}
