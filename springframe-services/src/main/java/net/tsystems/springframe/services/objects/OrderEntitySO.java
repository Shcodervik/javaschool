package net.tsystems.springframe.services.objects;

import java.sql.Timestamp;
import java.util.Objects;

public class OrderEntitySO {
    private int idOrder;
    private Byte closed;
    private Timestamp createDt;
    private Timestamp closeDt;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Byte getClosed() {
        return closed;
    }

    public void setClosed(Byte closed) {
        this.closed = closed;
    }

    public Timestamp getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Timestamp createDt) {
        this.createDt = createDt;
    }

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
        OrderEntitySO that = (OrderEntitySO) o;
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
