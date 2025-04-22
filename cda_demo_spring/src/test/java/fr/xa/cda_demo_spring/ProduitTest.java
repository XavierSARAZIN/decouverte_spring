package fr.xa.cda_demo_spring;

import fr.xa.cda_demo_spring.model.Produit;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProduitTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory =
                Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void createValidProduit_shouldBeValid() {
        Produit produitTest = new Produit();
        produitTest.setNom("Test");
        produitTest.setPrix(10);

        Set<ConstraintViolation<Produit>> violations = validator.validate(produitTest);
        //PAS BESOIN DE Assertion.assertTrue car import static !!
        assertTrue(violations.isEmpty());
    }

    @Test
    void createProduitWithInvalidName_shouldNotBeValid() {
        Produit produitTest = new Produit();
        produitTest.setPrix(10);

        Set<ConstraintViolation<Produit>> violations = validator.validate(produitTest);

        assertEquals(1, violations.size());
    }

    @Test
    void createProduitWithoutName_shouldNotBeValid() {

        Produit produitTest = new Produit();
        Set<ConstraintViolation<Object>> violations = validator.validate(produitTest);

        boolean notBlankViolationExist = constraintExist(
                violations, "nom", "jakarta.validation.constraints.NotBlank");

        assertTrue(notBlankViolationExist);

    }

    @Test
    void createProduitWithNegativePrice_shouldNotBeValid() {

        Produit produitTest = new Produit();
        produitTest.setPrix(-10);
        Set<ConstraintViolation<Object>> violations = validator.validate(produitTest);

        boolean decimalMinViolationExist = constraintExist(
                violations, "prix", "jakarta.validation.constraints.DecimalMin");

        assertTrue(decimalMinViolationExist);
    }

    private boolean constraintExist(Set<ConstraintViolation<Object>> violations, String fieldName, String constraintName) {
        return violations.stream()
                .filter(v -> v.getPropertyPath().toString().equals(fieldName))
                .map(v -> v.getConstraintDescriptor().getAnnotation().annotationType().getName())
                .anyMatch(s -> s.equals(constraintName));
    }
}
