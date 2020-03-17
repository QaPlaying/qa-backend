package com.qa.fun.qa;

import com.qa.fun.qa.auth.PermissionsReader;
import com.qa.fun.qa.common.utils.XmlUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired @Qualifier("dbUserDetails")
	private UserDetailsService userDetailsService;

	@Autowired
	private PermissionsReader permissionsReader;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry registry = http.authorizeRequests().antMatchers("/", "/search", "/home").permitAll();
		List<Pair<String, String>> permissions = permissionsReader.readPermissions();
		
		for (Pair<String, String> permission : permissions) {
			registry = ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)registry.antMatchers(permission.getKey())).hasRole(permission.getValue());
		}
		
		((HttpSecurity)registry.and()).formLogin();
	}


	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
