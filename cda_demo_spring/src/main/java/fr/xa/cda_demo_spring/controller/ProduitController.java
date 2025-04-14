package fr.xa.cda_demo_spring.controller;

import fr.xa.cda_demo_spring.dao.ProduitDao;
import fr.xa.cda_demo_spring.model.Etat;
import fr.xa.cda_demo_spring.model.Produit;
import fr.xa.cda_demo_spring.security.IsUtilisateur;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProduitController {

    @Autowired
    protected ProduitDao produitDao;

    @GetMapping("/produit/{id}")
    public ResponseEntity<Produit> get(@PathVariable int id) {

        Optional<Produit> optionalProduit = produitDao.findById(id);

        if (optionalProduit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalProduit.get(), HttpStatus.OK);
    }

    @GetMapping("/produits")
    @IsUtilisateur
    public List<Produit> getAll() {
        return produitDao.findAll();
    }

    @PostMapping("/produit")
    public ResponseEntity<Produit> save(@RequestBody @Valid Produit produit) {
        if (produit.getEtat() == null) {
            Etat etatNeuf = new Etat();
            etatNeuf.setId(1);
            produit.setEtat(etatNeuf);
        }

        produit.setId(null);
        produitDao.save(produit);

        return new ResponseEntity<>(produit, HttpStatus.CREATED);
    }

    @DeleteMapping("/produit/{id}")
    public ResponseEntity<Produit> delete(@PathVariable int id) {

        Optional<Produit> optionalProduit = produitDao.findById(id);

        if (optionalProduit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        produitDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/produit/{id}")
    public ResponseEntity<Produit> update(
            @PathVariable int id,
            @RequestBody @Valid Produit produit) {

        Optional<Produit> optionalProduit = produitDao.findById(id);

        if (optionalProduit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        produit.setId(id);
        produitDao.save(produit);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
