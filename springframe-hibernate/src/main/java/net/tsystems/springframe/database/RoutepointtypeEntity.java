package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "routepointtype")
public class RoutepointtypeEntity {
    private int idRpType;
    private String rpType;

    @Id
    @Column(name = "idRPType", nullable = false)
    public int getIdRpType() {
        return idRpType;
    }

    public void setIdRpType(int idRpType) {
        this.idRpType = idRpType;
    }

    @Basic
    @Column(name = "RPType", nullable = true, length = 45)
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

        RoutepointtypeEntity that = (RoutepointtypeEntity) o;

        if (idRpType != that.idRpType) return false;
        if (rpType != null ? !rpType.equals(that.rpType) : that.rpType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRpType;
        result = 31 * result + (rpType != null ? rpType.hashCode() : 0);
        return result;
    }
}
