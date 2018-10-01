package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "logiweb")
public class UserEntity {
    private int idUser;
    private String username;
    private String passHash;
    private Byte isEmployee;
    private int driverIdDriver;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PassHash")
    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    @Basic
    @Column(name = "IsEmployee")
    public Byte getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Byte isEmployee) {
        this.isEmployee = isEmployee;
    }

    @Basic
    @Column(name = "Driver_idDriver")
    public int getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(int driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser &&
                driverIdDriver == that.driverIdDriver &&
                Objects.equals(username, that.username) &&
                Objects.equals(passHash, that.passHash) &&
                Objects.equals(isEmployee, that.isEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, username, passHash, isEmployee, driverIdDriver);
    }
}
