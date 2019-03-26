package win.ccav.tacmal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import win.ccav.tacmal.service.UserRepositoryUserDetailsService;

@Configuration
@EnableWebSecurity
public class TacoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepositoryUserDetailsService userRepositoryUserDetailsService;
    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userRepositoryUserDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/design","/orders").hasRole("USER").
                antMatchers("/", "/**").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/design");
    }
}
