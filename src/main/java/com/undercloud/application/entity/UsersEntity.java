package com.undercloud.application.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.processing.Generated;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Users")
public class UsersEntity implements UserDetails {

    //users not null
    @Id
    private String id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String avatarUrl;
    @NotBlank
    private String bannerUrl;
    //opcional
    private String bio;
    @NotBlank
    private String COUNTRY;
    @NotBlank
    private String STATE;

    public UsersEntity (String login, String password){
        this.login = login;
        this.password = password;
    }


    //verificar as roles que usuaario tem
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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
}
