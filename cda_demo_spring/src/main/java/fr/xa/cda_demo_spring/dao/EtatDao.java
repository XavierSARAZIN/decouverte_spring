package fr.xa.cda_demo_spring.dao;

import fr.xa.cda_demo_spring.model.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatDao extends JpaRepository<Etat, Integer> {
}
