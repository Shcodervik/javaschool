package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "routepointtype", schema = "logiweb")
public class RoutepointtypeEntity {
    private int idRpType;
    private String rpType;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idRPType")
    public int getIdRpType() {
        return idRpType;
    }

    public void setIdRpType(int idRpType) {
        this.idRpType = idRpType;
    }

    @Basic
    @Column(name = "RPType")
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
        return idRpType == that.idRpType &&
                Objects.equals(rpType, that.rpType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRpType, rpType);
    }
}
