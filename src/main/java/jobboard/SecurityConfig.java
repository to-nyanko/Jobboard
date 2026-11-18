package jobboard;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/jobs/create", "/jobs/*/delete").authenticated()
				.requestMatchers("/jobs","/jobs/{id}","/h2-console/**").permitAll()
				.anyRequest().authenticated()
			)

			.formLogin(form -> form
				.defaultSuccessUrl("/jobs", true)
				.permitAll()
			)
			
			.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
			.headers(headers -> headers.frameOptions(frame -> frame.disable()));
			
		return http.build();
	}

}
