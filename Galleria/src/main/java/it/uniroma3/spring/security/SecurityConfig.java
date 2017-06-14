package it.uniroma3.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private DataSource dataSource;

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    	auth
//    		.jdbcAuthentication()
//    			.dataSource(dataSource)
//    			.withDefaultSchema()
//    			.withUser("user").password("password").roles("USER").and()
//    			.withUser("admin").password("password").roles("USER", "ADMIN");
//    	
//    }
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder()).
		withUser("user").password("password1").roles("USER")
		.and()
		.usersByUsernameQuery("SELECT username,password,1 FROM users where username=?")
		.authoritiesByUsernameQuery("SELECT username,authority FROM authorities where username=?");
		
	}
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http
    		
        	.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")			// Non è necessario specificare la failurePage. Di default la pagina di failure è /login?error
            .defaultSuccessUrl("/index")
            .permitAll();
    	
//        http
//        	.authorizeRequests()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin().loginPage("/login").failureUrl("/registrati")
//            .permitAll()
//            .and()
//            .logout()
//            .permitAll();
    }
    
    @Bean 
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}