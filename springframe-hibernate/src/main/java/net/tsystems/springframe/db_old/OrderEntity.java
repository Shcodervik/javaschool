package net.tsystems.springframe.db_old;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order")
public class OrderEntity {
    private int idOrder;
    private Byte closed;
    private Timestamp createDt;
    private Timestamp closeDt;

    @Id
    @Column(name = "idOrder", nullable = false)
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "Closed", nullable = true)
    public Byte getClosed() {
        return closed;
    }

    public void setClosed(Byte closed) {
        this.closed = closed;
    }

    @Basic
    @Column(name = "CreateDT", nullable = true)
    public Timestamp getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Timestamp createDt) {
        this.createDt = createDt;
    }

    @Basic
    @Column(name = "CloseDT", nullable = true)
    public Timestamp getCloseDt() {
        return closeDt;
    }

    public void setCloseDt(Timestamp closeDt) {
        this.closeDt = closeDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (idOrder != that.idOrder) return false;
        if (closed != null ? !closed.equals(that.closed) : that.closed != null) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;
        if (closeDt != null ? !closeDt.equals(that.closeDt) : that.closeDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + (closed != null ? closed.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        result = 31 * result + (closeDt != null ? closeDt.hashCode() : 0);
        return result;
    }
}
