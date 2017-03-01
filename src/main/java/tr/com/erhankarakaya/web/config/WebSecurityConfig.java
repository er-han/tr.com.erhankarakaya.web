package tr.com.erhankarakaya.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by erhan.karakaya on 3/1/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .authorizeRequests()
        .antMatchers("/","/index").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/admin/login")
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
}
