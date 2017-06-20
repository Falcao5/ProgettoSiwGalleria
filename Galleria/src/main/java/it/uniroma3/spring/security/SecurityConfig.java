package it.uniroma3.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/",
				"/home")
		.permitAll()
		.antMatchers("/protected/**")
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login").successForwardUrl("/protected/autenticato")
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

}