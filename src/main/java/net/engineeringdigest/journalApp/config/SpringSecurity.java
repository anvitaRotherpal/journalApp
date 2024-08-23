package net.engineeringdigest.journalApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity) throws Exception{
        http.authorizeRequests()
                .antMatchers("/journal/**", "/user/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest.permitAll()
                .and()
                .HttpBasic()
                http.csrf().disable();

    }
    @Override
    protected void configure(AuthenticationBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder()
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
