package tr.com.erhankarakaya.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tr.com.erhankarakaya.web.bll.service.AdminServiceImpl;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AdminServiceImpl adminService;

  @Override
  protected void configure(AuthenticationManagerBuilder registry) throws Exception {
    registry.userDetailsService(adminService)
        .passwordEncoder(passwordEncoder());
  }


  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/","/index").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/admin/login").failureUrl("/admin/login?error")
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/admin")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("admin/login?logout")
        .permitAll();
  }

  @Override
  public void configure(WebSecurity webSecurity) {
    webSecurity.ignoring()
        .antMatchers("/vendor/**")
        .antMatchers("/less/**")
        .antMatchers("/js/**")
        .antMatchers("/img/**")
        .antMatchers("/css/**")
        .antMatchers("/panel/**");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
