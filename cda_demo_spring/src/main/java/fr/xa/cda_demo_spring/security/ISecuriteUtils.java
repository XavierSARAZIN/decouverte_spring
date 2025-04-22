package fr.xa.cda_demo_spring.security;

public interface ISecuriteUtils {
    String getRole(AppUserDetails userDetails);

    String generateToken(AppUserDetails userDetails);

    String getSubjectFromJwt(String jwt);
}
