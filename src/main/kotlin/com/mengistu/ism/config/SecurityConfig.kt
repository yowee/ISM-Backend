package com.mengistu.ism.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .authorizeRequests { authorizeRequests ->
                    authorizeRequests
                            .antMatchers("api/public/**").permitAll()
                            .antMatchers("api/private/**").authenticated()
                }
                .csrf { csrf -> csrf.disable() } //Disable CSRF protection (only for demonstration)

        //Configure Firebase Authentication
        http.oauth2Login(Customizer.withDefaults())

        return http.build()
    }
}
