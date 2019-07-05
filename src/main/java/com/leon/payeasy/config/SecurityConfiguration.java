package com.leon.payeasy.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Saiful Leon
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                //.antMatchers("/welcome").access("hasRole('ROLE_USER')")
                .antMatchers("/dashboard").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/employee").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/allowance").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/deduction").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/basicsalary").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/employee2pay").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/department").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/emptype").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/jobtitle").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/paytype").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/basicyear").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/dashboard").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/dashboard").access("hasRole('ROLE_ADMIN')")
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().loginPage("/login").loginProcessingUrl("/perform_login")
                .successForwardUrl("/loginsuccess").usernameParameter("usename")
                .passwordParameter("userpassword").failureUrl("/login")
                .and().logout().logoutUrl("/logout")
                .logoutSuccessUrl("/").invalidateHttpSession(true)
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        //System.out.println("in security.............");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select emailid, password, status from UserRole where emailid=? and status='True'")
                .authoritiesByUsernameQuery("select emailid,role from UserRole where emailid=?");
    }

}
