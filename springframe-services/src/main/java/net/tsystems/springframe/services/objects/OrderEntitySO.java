package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Service
public class OrderEntitySO {
    private int idOrder;
    private boolean closed;
    private Date createDT;
    private Date closeDT;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public boolean getClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Date getCreateDT() {
        return createDT;
    }

    public void setCreateDT(Date createDt) {
        this.createDT = createDt;
    }

    public Date getCloseDT() {
        return closeDT;
    }

    public void setCloseDT(Date closeDt) {
        this.closeDT = closeDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntitySO that = (OrderEntitySO) o;
        return idOrder == that.idOrder &&
                Objects.equals(closed, that.closed) &&
                Objects.equals(createDT, that.createDT) &&
                Objects.equals(closeDT, that.closeDT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, closed, createDT, closeDT);
    }
}
