package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class UserEntitySO {
    private int idUser;
    private String username;
    private String passHash;
    private boolean isEmployee;
    private int driverIdDriver;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        UserEntitySO that = (UserEntitySO) o;
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
