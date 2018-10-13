package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoutepointtypeEntitySO {
    private int idRpType;
    private String rpType;

    public int getIdRpType() {
        return idRpType;
    }

    public void setIdRpType(int idRpType) {
        this.idRpType = idRpType;
    }

    public String getRpType() {
        return rpType;
    }

    public void setRpType(String rpType) {
        this.rpType = rpType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutepointtypeEntitySO that = (RoutepointtypeEntitySO) o;
        return idRpType == that.idRpType &&
                Objects.equals(rpType, that.rpType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRpType, rpType);
    }
}
