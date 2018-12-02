/*
 * Copyright (c) 2018.
 */

package net.tsystems.springframe.configuration.auth;

import net.tsystems.springframe.services.objects.UserEntitySO;
import net.tsystems.springframe.services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Service("customUserDetailsService")
public class CustomUserDetailsService {//implements UserDetailsService {
/*
    @Autowired
    public UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserEntitySO user = userService.getUserByUsername(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("Username not found");
        }

        username = user.getUsername();
        String password = user.getPassHash();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection<? extends GrantedAuthority> authorities = getGrantedAuthorities(user);

        return new org.springframework.security.core.userdetails.User(
                username,
                password,
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                authorities);
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserEntitySO user)
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if(!user.isEmployee()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"));
        }
        else{
            if(user.getDriverIdDriver()!=null){
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            else{
                authorities.add(new SimpleGrantedAuthority("ROLE_GUEST"));
            }
        }

        return authorities;
    }*/

}
