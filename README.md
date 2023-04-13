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


<h3>Spring Security na JPA, versão anterior a 5.7.9</h3>

@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
    
        this.userDetailsService = userDetailsService;
        
    }

    @Override
    
    protected void configure(HttpSecurity http) throws Exception {
    
        http.httpBasic().and().authorizeHttpRequests().anyRequest().authenticated().and().csrf().disable();
        
    }

    @Override
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        
    }

    @Bean
    
    public PasswordEncoder passwordEncoder(){
    
        return new BCryptPasswordEncoder();
        
    }
    
}

@Entity

@Table(name = "TB_USER")

public class UserModel implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private UUID userId;
    
    @Column(nullable = false, unique = true)
    
    private String username;
    
    @Column(nullable = false)
    
    private String password;
    
    @Override
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
    
        return null;
        
    }

    @Override
    
    public String getPassword() {
    
        return this.password;
        
    }

    @Override
    
    public String getUsername() {
    
        return this.username;
        
    }

    @Override
    
    public boolean isAccountNonExpired() {
    
        return true;
        
    }

    @Override
    
    public boolean isAccountNonLocked() {
    
        return true;
        
    }

    @Override
    
    public boolean isCredentialsNonExpired() {
    
        return true;
        
    }

    @Override
    
    public boolean isEnabled() {
    
        return true;
        
    }

    public UUID getUserId() {
    
        return userId;
        
    }

    public void setUserId(UUID userId) {
    
        this.userId = userId;
        
    }

    public void setUsername(String username) {
    
        this.username = username;
        
    }

    public void setPassword(String password) {
    
        this.password = password;
        
    }
}

@Repository

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByUsername(String username);
  
}


@Service

public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
    
        this.userRepository = userRepository;
        
    }

    @Override
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        UserModel userModel = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        
        return null;
        
    }
    
}
