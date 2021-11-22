package wildlife.care.secuirity;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import wildlife.care.model.UserDetailsImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("ROLE_SUPERADMIN")) {
            redirectURL = "/nationalParks";
        } else if (userDetails.hasRole("ROLE_ADMIN")) {
            redirectURL = "/animals";
        } else if (userDetails.hasRole("ROLE_RANGER")) {
            redirectURL = "/animals";
        } else if (userDetails.hasRole("ROLE_VETERINARIAN")) {
            redirectURL = "/vaccines";
        }

        response.sendRedirect(redirectURL);

    }

}
