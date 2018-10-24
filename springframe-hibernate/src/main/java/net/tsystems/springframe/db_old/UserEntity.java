package net.tsystems.springframe.db_old;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    private int idUser;
    private String username;
    private String passHash;
    private Byte isEmployee;
    private DriverEntity driverIdDriver;

    @Id
    @Column(name = "idUser", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "Username", nullable = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PassHash", nullable = true, length = 256)
    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    @Basic
    @Column(name = "IsEmployee", nullable = true)
    public Byte getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Byte isEmployee) {
        this.isEmployee = isEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (idUser != that.idUser) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (passHash != null ? !passHash.equals(that.passHash) : that.passHash != null) return false;
        if (isEmployee != null ? !isEmployee.equals(that.isEmployee) : that.isEmployee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passHash != null ? passHash.hashCode() : 0);
        result = 31 * result + (isEmployee != null ? isEmployee.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "Driver_idDriver", referencedColumnName = "idDriver", nullable = true)
    public DriverEntity getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(DriverEntity driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }
}
