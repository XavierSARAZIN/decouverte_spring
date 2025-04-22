package fr.xa.cda_demo_spring.mock;

import fr.xa.cda_demo_spring.security.AppUserDetails;
import fr.xa.cda_demo_spring.security.ISecuriteUtils;

public class MockSecuriteUtils implements ISecuriteUtils {

    @Override
    public String getRole(AppUserDetails userDetails) {
        return "";
    }

    @Override
    public String generateToken(AppUserDetails userDetails) {
        return "";
    }

    @Override
    public String getSubjectFromJwt(String jwt) {
        return "";
    }
}
