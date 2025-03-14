package fr.xa.cda_demo_spring.controller;

import fr.xa.cda_demo_spring.dao.EtiquetteDao;
import fr.xa.cda_demo_spring.model.Etiquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class EtiquetteController {

    @Autowired
    protected EtiquetteDao etiquetteDao;

    @GetMapping("/etiquette/{id}")
    public ResponseEntity<Etiquette> get(@PathVariable int id) {

        Optional<Etiquette> optionalEtiquette = etiquetteDao.findById(id);

        if (optionalEtiquette.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalEtiquette.get(), HttpStatus.OK);
    }

    @GetMapping("/etiquettes")
    public List<Etiquette> getAll() {
        return etiquetteDao.findAll();
    }

    @PostMapping("/etiquette")
    public ResponseEntity<Etiquette> save(@RequestBody Etiquette etiquette) {
        etiquetteDao.save(etiquette);

        return new ResponseEntity<>(etiquette, HttpStatus.CREATED);
    }

    @DeleteMapping("/etiquette/{id}")
    public ResponseEntity<Etiquette> delete(@PathVariable int id) {

        Optional<Etiquette> optionalEtiquette = etiquetteDao.findById(id);

        if (optionalEtiquette.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        etiquetteDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/etiquette/{id}")
    public ResponseEntity<Etiquette> update(
            @PathVariable int id,
            @RequestBody Etiquette etiquette) {

        Optional<Etiquette> optionalEtiquette = etiquetteDao.findById(id);

        if (optionalEtiquette.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        etiquette.setId(id);
        etiquetteDao.save(etiquette);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
