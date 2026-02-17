package salvoamplo.esercitazione.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import salvoamplo.esercitazione.entities.Dipendente;
import salvoamplo.esercitazione.payloads.DipendenteRequest;
import salvoamplo.esercitazione.repositories.DipendenteRepository;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @GetMapping
    public List<Dipendente> listaDipendenti() {
        return dipendenteRepository.findAll();
    }

    @PostMapping
    public Dipendente creaDipendente(@RequestBody DipendenteRequest body) {

        Dipendente d = new Dipendente();
        d.setUsername(body.getUsername());
        d.setNome(body.getNome());
        d.setCognome(body.getCognome());
        d.setEmail(body.getEmail());

        return dipendenteRepository.save(d);
    }

}
