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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import it.uniroma3.spring.repository.UtenteRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private  DataSource dataSource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.csrf().disable()
        .authorizeRequests()
        	.antMatchers("/",
   				 		 "/home")
        				.permitAll()
            .antMatchers(	"/autenticato", 
            				"/protected/**")
            				.authenticated()
            .and()
        .formLogin()
            .loginPage("/login").successForwardUrl("/autenticato")
            .permitAll()
            .and()
        .logout()
	        .invalidateHttpSession(true)
	        .logoutUrl("/logout")
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/")
           .permitAll();
    }
    
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  
	  auth
          .inMemoryAuthentication()
          	.withUser("admin").password("pass").authorities("ADMIN");
      
}
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("pass").roles("ADMIN");
//        
//}
	
//	@Autowired
//	private DataSource dataSource;
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth
//			.jdbcAuthentication()
//				.dataSource(dataSource)
//				.usersByUsernameQuery(
//                        "select username,password,enabled from users where username=?");
//		
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()                                                                
//			.antMatchers("/resources/**", "/signup", "/about").permitAll()                  
//			.antMatchers("/admin/**").hasRole("ADMIN")                                      
//			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            
//			.anyRequest().authenticated()                                                   
//		.and()
//			.formLogin().loginPage("/login").permitAll()
//		.and()
//			.httpBasic();
//	}
	
}