package com.paynefulapps.simpleimageserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun apiFilter(http: HttpSecurity): SecurityFilterChain {
        return http
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
            .formLogin()
                .disable()
            .authorizeRequests {
                it.antMatchers("/image/**").permitAll()
            }
            .build()
    }
}
