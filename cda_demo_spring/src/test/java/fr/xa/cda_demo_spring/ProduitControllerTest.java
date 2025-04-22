package fr.xa.cda_demo_spring;

import fr.xa.cda_demo_spring.controller.ProduitController;
import fr.xa.cda_demo_spring.mock.MockProduitDao;
import fr.xa.cda_demo_spring.mock.MockSecuriteUtils;
import fr.xa.cda_demo_spring.model.Produit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ProduitControllerTest {

    @Test
    void callGetWithExistingProduct_shouldSend200ok() {

        ProduitController produitController = new ProduitController(
                new MockProduitDao(), new MockSecuriteUtils()
        );

        ResponseEntity<Produit> reponse = produitController.get(1);
        Assertions.assertEquals(HttpStatus.OK, reponse.getStatusCode());
    }

    @Test
    void callGetWithNoExistingProduct_shouldSend200ok() {

        ProduitController produitController = new ProduitController(
                new MockProduitDao(), new MockSecuriteUtils()
        );

        ResponseEntity<Produit> reponse = produitController.get(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());
    }
}
