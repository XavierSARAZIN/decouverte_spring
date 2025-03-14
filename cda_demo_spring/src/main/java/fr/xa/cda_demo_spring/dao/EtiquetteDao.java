package fr.xa.cda_demo_spring.dao;

import fr.xa.cda_demo_spring.model.Etiquette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetteDao extends JpaRepository<Etiquette, Integer> {
}
