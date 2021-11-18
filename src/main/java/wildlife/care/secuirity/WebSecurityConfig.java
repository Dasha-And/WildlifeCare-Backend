package wildlife.care.secuirity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired private LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/create_nationalPark",
                        "/update_nationalPark", "/delete_nationalPark",
                        "/nationalPark", "/nationalPark_all", "/create_species", "/update_species", "/delete_species").hasRole("SUPERADMIN")
                .antMatchers("/create_animal",
                        "/update_animal", "/delete_animal", "/create_worker").hasRole("ADMIN")
                .antMatchers("/create_vaccine").hasAnyRole("ADMIN", "VETERINARIAN")
                .antMatchers("/").permitAll()
                .and().formLogin().successHandler(loginSuccessHandler)
                .permitAll().and()
                .logout()
                .permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
