package be.vdab.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class CreateSecurityFilter extends WebSecurityConfigurerAdapter {

	private final static String ADMINISTRATOR = "administrator";
	private final static String USER = "user";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring()
		.antMatchers("/images/**")
		.antMatchers("/styles/**")
		.antMatchers("/scripts/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http
		.formLogin()
		
		.loginPage("/login")
		.and()
		.logout()
		.logoutSuccessUrl("/logout")
		
		.and()
		.authorizeRequests()
		.antMatchers("/brouwers/toevoegen")
		.hasAuthority(ADMINISTRATOR)
		
		.antMatchers("/brouwers/*", "/brouwers")
		.hasAnyAuthority(ADMINISTRATOR, USER);
		
		
	}
}
