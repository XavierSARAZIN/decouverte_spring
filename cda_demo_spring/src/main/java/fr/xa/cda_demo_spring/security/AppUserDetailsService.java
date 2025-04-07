package fr.xa.cda_demo_spring.security;

import fr.xa.cda_demo_spring.dao.UtilisateurDao;
import fr.xa.cda_demo_spring.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UtilisateurDao utilisateurDao;
   

    @Autowired
    public AppUserDetailsService(UtilisateurDao utilisateurDao) {

        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findByEmail(email);

        if (optionalUtilisateur.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        return new AppUserDetails(optionalUtilisateur.get());
    }
}
