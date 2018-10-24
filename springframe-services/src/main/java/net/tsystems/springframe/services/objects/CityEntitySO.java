package net.tsystems.springframe.services.objects;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CityEntitySO {
    private int idCity;
    private String name;

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

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
        CityEntitySO that = (CityEntitySO) o;
        return idCity == that.idCity &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, name);
    }


}
