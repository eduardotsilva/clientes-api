package br.com.eduardo.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/usuarios","/h2-console/**", "/swagger-ui.html","/webjars/**","/swagger-ui.html/**", "/swagger-resources/**","/v2/api-docs").permitAll()
                .antMatchers("/api/clientes/**","/api/servicos-prestados/**").authenticated()
                .anyRequest().denyAll();
        ;
    }
}
