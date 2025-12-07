package edu.sias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security配置类
 * 配置系统的安全策略
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    /**
     * 配置安全过滤链
     * @param http HttpSecurity对象
     * @return SecurityFilterChain对象
     * @throws Exception 配置异常
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 禁用CSRF保护
            .authorizeHttpRequests(authz -> authz
                // 允许所有接口访问（简化版，无权限控制）
                .anyRequest().permitAll()
            )
            .formLogin(form -> form.disable()) // 禁用默认表单登录
            .httpBasic(basic -> basic.disable()); // 禁用基本认证
            
        return http.build();
    }
}