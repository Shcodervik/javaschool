package net.tsystems.springframe.database;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order", schema = "logiweb")
public class OrderEntity {
    private int idOrder;
    private Byte closed;
    private Timestamp createDt;
    private Timestamp closeDt;

    @Id
    @Column(name = "idOrder")
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "Closed")
    public Byte getClosed() {
        return closed;
    }

    public void setClosed(Byte closed) {
        this.closed = closed;
    }

    @Basic
    @Column(name = "CreateDT")
    public Timestamp getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Timestamp createDt) {
        this.createDt = createDt;
    }

    @Basic
    @Column(name = "CloseDT")
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
        return idOrder == that.idOrder &&
                Objects.equals(closed, that.closed) &&
                Objects.equals(createDt, that.createDt) &&
                Objects.equals(closeDt, that.closeDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, closed, createDt, closeDt);
    }
}
