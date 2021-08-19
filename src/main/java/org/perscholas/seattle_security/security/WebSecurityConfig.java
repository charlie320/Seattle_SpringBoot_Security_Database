package org.perscholas.seattle_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@SuppressWarnings("deprecation")
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder()
//				.username("testUser1")
//				.password("testPass1")
//				.roles("USER")
//				.build());
//		users.add(User.withDefaultPasswordEncoder()
//				.username("testUser2")
//				.password("testPass2")
//				.roles("USER")
//				.build());
//		return new InMemoryUserDetailsManager(users);
//	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF is disabled for simplification and demonstration.
		// Do not use this configuration for production.
		http.csrf().disable()
		// Allows all requests access to the /login URL
		.authorizeRequests().antMatchers("/login").permitAll()
		// Specifies that we would like to use a custom form to login
		.and().formLogin().loginPage("/login").permitAll()
		// Specifies that any authenticated user can access all URLs
		.and().authorizeRequests().anyRequest().authenticated()
		.and()
		// Upon logout, invalidate the session and clear authentication
		.logout().invalidateHttpSession(true).clearAuthentication(true)
		// Specifies Logout URL
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		// Forward to /logoutsuccess upon logout and allow all requests
		.logoutSuccessUrl("/logoutSuccess").permitAll();
	}
	
}