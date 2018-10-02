package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "logiweb")
public class CityEntity {
    private int idCity;
    private String name;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idCity")
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return idCity == that.idCity &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, name);
    }
}
