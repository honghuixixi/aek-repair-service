package com.aek.ebey.repair.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aek.common.core.serurity.JwtAuthenticationEntryPoint;
import com.aek.common.core.serurity.JwtAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf()
                .disable()
                
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                
                // don't create session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/webjars/**")
                .permitAll()
                .antMatchers("/newrepair/repRepairMessage/send")
                .permitAll()
                .antMatchers("/newrepair/data/getRepairLargeScreenData")
                .permitAll()
                .antMatchers("/newrepair/data/getRepairData")
                .permitAll()
                .antMatchers("/newrepair/data/getRepairDataMonth")
                .permitAll()
                .antMatchers("/swagger-resources/**")
                .permitAll()
                .antMatchers("/v2/api-docs")
                .permitAll()
                .antMatchers("/images/*.jpg")
                .permitAll()
                .antMatchers("/images/*.png")
                .permitAll()
                .antMatchers("/**/*.js")
                .permitAll()
                .antMatchers("/**/*.css")
                .permitAll()
                .antMatchers("/**/*.woff")
                .permitAll()
                .antMatchers("/**/*.woff2")
                .permitAll()
                .antMatchers("/**/*.jsp")
                .permitAll()
                .antMatchers("/**/*.html")
                .permitAll()
                .antMatchers("/favicon.ico")
                .permitAll()
                .anyRequest()
                .authenticated();
        
        // Custom JWT based security filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        
        // disable page caching
        httpSecurity.headers().cacheControl();
    }
}