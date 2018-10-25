package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DriverEntitySO {
    private int idDriver;
    private String name;
    private String surname;
    private String UIN;

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUIN() {
        return UIN;
    }

    public void setUIN(String UIN) {
        this.UIN = UIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverEntitySO that = (DriverEntitySO) o;
        return idDriver == that.idDriver &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(UIN, that.UIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriver, name, surname, UIN);
    }


}
