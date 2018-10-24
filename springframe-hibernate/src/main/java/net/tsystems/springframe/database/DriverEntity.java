package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class DriverEntity {
    private int idDriver;
    private String name;
    private String surname;
    private String UIN;

    @Id
    @Column(name = "idDriver", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "Surname", nullable = true, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "UIN", nullable = true, length = 45)
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

        DriverEntity that = (DriverEntity) o;

        if (idDriver != that.idDriver) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (UIN != null ? !UIN.equals(that.UIN) : that.UIN != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDriver;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (UIN != null ? UIN.hashCode() : 0);
        return result;
    }
}
