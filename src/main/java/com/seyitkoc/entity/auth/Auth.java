package com.seyitkoc.entity.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.seyitkoc.entity.user.User;
import com.seyitkoc.enums.AuthRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "auths")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Auth implements UserDetails {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "auth")
    @ToString.Exclude
    @JsonBackReference
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AuthRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

}
