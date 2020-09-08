package br.com.samsung.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.samsung.security.jwt.JwtConfigurer;
import br.com.samsung.security.jwt.JwtTokenProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManager();
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		    .disable()
		    .csrf()
		    .disable()
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		    .and()
		    .authorizeRequests()
		    .antMatchers("/auth/signin" , "/api/docs/**" , "swagger-ui.html**")
		    .permitAll().
		    antMatchers("/api/**")
		    .authenticated().
		    antMatchers("/users").
		    denyAll().and().apply(new JwtConfigurer(tokenProvider));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		String result = bCryptPasswordEncoder.encode("admin123");		
		auth.inMemoryAuthentication().withUser("admin").password(result).roles("ADMIN");
	}	
	
}
