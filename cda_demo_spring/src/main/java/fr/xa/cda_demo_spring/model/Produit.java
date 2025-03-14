package fr.xa.cda_demo_spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false)
    protected String nom;
    @NotBlank

    @Column(length = 10, nullable = false, unique = true)
    @Length(max = 10, min = 3)
    @NotBlank
    protected String code;

    @Column(columnDefinition = "TEXT")
    protected String description;

    @DecimalMin(value = "0.1")
    protected float prix;

    @ManyToOne
    @JoinColumn(nullable = false)
    protected Etat etat;

    @ManyToMany
    @JoinTable(
            name = "etiquette_produit",
            inverseJoinColumns = @JoinColumn(name = "etiquette_id")
    )
    protected List<Etiquette> etiquettes = new ArrayList<>();
}

