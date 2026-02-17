package salvoamplo.esercitazione.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import salvoamplo.esercitazione.entities.Viaggio;
import salvoamplo.esercitazione.exceptions.NotFoundException;
import salvoamplo.esercitazione.repositories.ViaggioRepository;

@RestController
@RequestMapping("/viaggi")
public class ViaggiController {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @PatchMapping("/{id}/stato")
    public Viaggio cambiaStato(
            @PathVariable Long id,
            @RequestParam boolean completato) {

        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Viaggio non trovato"));

        viaggio.setCompletato(completato);
        return viaggioRepository.save(viaggio);
    }
}
