package net.engineeringdigest.journalApp.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity) throws Exception{
        http.authorizeRequests()
                .antMatchers("/journal/**").authenticated()
                .anyRequest.permitAll()
                .and()
                .HttpBasic()

    }
}
