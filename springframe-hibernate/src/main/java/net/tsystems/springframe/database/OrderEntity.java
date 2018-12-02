/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.database;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class OrderEntity {
    private int idOrder;
    private Byte closed;
    private Timestamp createDT;
    private Timestamp closeDT;

    @Id
    @Column(name = "idOrder", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Timestamp getCreateDT() {
        return createDT;
    }

    public void setCreateDT(Timestamp createDt) {
        this.createDT = createDt;
    }

    @Basic
    @Column(name = "CloseDT", nullable = true)
    public Timestamp getCloseDT() {
        return closeDT;
    }

    public void setCloseDT(Timestamp closeDt) {
        this.closeDT = closeDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (idOrder != that.idOrder) return false;
        if (closed != null ? !closed.equals(that.closed) : that.closed != null) return false;
        if (createDT != null ? !createDT.equals(that.createDT) : that.createDT != null) return false;
        if (closeDT != null ? !closeDT.equals(that.closeDT) : that.closeDT != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + (closed != null ? closed.hashCode() : 0);
        result = 31 * result + (createDT != null ? createDT.hashCode() : 0);
        result = 31 * result + (closeDT != null ? closeDT.hashCode() : 0);
        return result;
    }
}
