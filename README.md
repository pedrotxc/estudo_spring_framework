<h1> Parking Control API </h1>

Spring Boot

Spring MVC

Spring Data JPA

Spring Validation

Spring Security

<h3>Spring Security em memória, versão anterior a 5.7.9</h3>

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    
    protected void configure(HttpSecurity http) throws Exception {
    
        http.httpBasic().and().authorizeHttpRequests().anyRequest().permitAll();

        http.httpBasic().and().authorizeHttpRequests().anyRequest().authenticated().and().csrf().disable();
        
    }

    @Override
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
        auth.inMemoryAuthentication().withUser("michelli").password(passwordEncoder().encode("607080")).roles("ADMIN");
        
    }

    @Bean
    
    public PasswordEncoder passwordEncoder(){
    
        return new BCryptPasswordEncoder();
       
  }
  
}
