package backend.spring.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name="endUser")
@AllArgsConstructor
@NoArgsConstructor
public class User /*implements UserDetails*/ {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    private String firstname;

    private String lastname;


    @Column(
            columnDefinition = "TEXT"
    )
    private String email;

    private String password;

    @Enumerated(
            EnumType.STRING
    )
    private  Role role;

  /*  @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of (new SimpleGrantedAuthority (role.name ()));
    }

    @Override
    public String getUsername() {
        return email;
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


   */
}