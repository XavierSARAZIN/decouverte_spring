package fr.xa.cda_demo_spring.controller;

import fr.xa.cda_demo_spring.dao.ProduitDao;
import fr.xa.cda_demo_spring.model.Etat;
import fr.xa.cda_demo_spring.model.Produit;
import fr.xa.cda_demo_spring.security.AppUserDetails;
import fr.xa.cda_demo_spring.security.IsUtilisateur;
import fr.xa.cda_demo_spring.security.SecuriteUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProduitController {


    protected ProduitDao produitDao;
    protected SecuriteUtils securiteUtils;

    @Autowired
    public ProduitController(ProduitDao produitDao, SecuriteUtils securiteUtils) {
        this.produitDao = produitDao;
        this.securiteUtils = securiteUtils;
    }

    @GetMapping("/produit/{id}")
    @IsUtilisateur
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
    @IsUtilisateur
    public ResponseEntity<Produit> save(@RequestBody @Valid Produit produit,
                                        @AuthenticationPrincipal AppUserDetails userDetails) {
        produit.setCreateur(userDetails.getUtilisateur());

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
    @IsUtilisateur
    public ResponseEntity<Produit> delete(@PathVariable int id,
                                          @AuthenticationPrincipal AppUserDetails userDetails) {

        Optional<Produit> optionalProduit = produitDao.findById(id);

        if (optionalProduit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        produitDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/produit/{id}")
    @IsUtilisateur
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
