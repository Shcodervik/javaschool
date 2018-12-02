package net.tsystems.springframe.services.objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class UserEntitySO implements UserDetails {
    private int idUser;
    private String username;
    private String passHash;
    private boolean isEmployee;
    private DriverEntitySO driverIdDriver;


    /**
     * @param passString is using as just a string without encoding
     * */
    private String passString;

    public String getPassString() {
        return passString;
    }

    public void setPassString(String passString) {
        this.passString = passString;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        username = this.getUsername();
        String password = this.getPassHash();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection<? extends GrantedAuthority> authorities = getGrantedAuthorities(this);

        return authorities;
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
    }


    @Override
    public String getPassword() {
        return this.getPassHash();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public DriverEntitySO getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(DriverEntitySO driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntitySO that = (UserEntitySO) o;
        return idUser == that.idUser &&
                isEmployee == that.isEmployee &&
                Objects.equals(username, that.username) &&
                Objects.equals(passHash, that.passHash) &&
                Objects.equals(driverIdDriver, that.driverIdDriver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, username, passHash, isEmployee, driverIdDriver);
    }
}
