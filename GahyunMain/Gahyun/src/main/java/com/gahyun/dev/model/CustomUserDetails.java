package com.gahyun.dev.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




public class CustomUserDetails implements UserDetails{
	private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(UserDto user) {
    	System.out.println("커스텀유저디테일의 user값: " + user); // 추가된 로그
    	if (user == null) {
            throw new IllegalArgumentException("UserDto cannot be null");
        }
       
        if (user.getUserid() == null) {
            throw new IllegalArgumentException("UserDto userid cannot be null");
        }
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("UserDto password cannot be null");
        }
        this.username = user.getUserid();
        this.password = user.getPassword();
        this.authorities = List.of(() -> "ROLE_USER");
  
    }
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
