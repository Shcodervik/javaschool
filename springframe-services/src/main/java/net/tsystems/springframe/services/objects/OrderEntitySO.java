package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Service
public class OrderEntitySO {
    private int idOrder;
    private boolean closed;
    private Date createDt;
    private Date closeDt;

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

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getCloseDt() {
        return closeDt;
    }

    public void setCloseDt(Date closeDt) {
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
