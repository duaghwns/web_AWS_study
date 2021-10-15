package hojoon.web_AWS_study.config.auth;

import hojoon.web_AWS_study.domain.User.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityEnablerConfiguration {
    private final CustomOAuth2UserService customOAuth2UserService;

    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                    .headers().frameOptions().disable()
                .and()
                    .authorizeRequests().antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**")
                    .permitAll().antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}
