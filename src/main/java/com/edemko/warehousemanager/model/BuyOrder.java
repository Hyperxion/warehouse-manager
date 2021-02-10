package com.edemko.warehousemanager.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "buy_orders")
public class BuyOrder {

    //filled by user based on invoice orderId
    @Id
    @Column(name = "buy_order_id")
    private long id;

    private String comment;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id")//nullable = false, insertable = false, updatable = false
    private Owner owner;

    private double weight;
    private String upsTracking;
    private Date dateSent;
    private Date dateReceived;
    private Paid paid;
    private Status status;

    //Many BuyOrders can have only one user
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")//, insertable = false, updatable = false
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getUpsTracking() {
        return upsTracking;
    }

    public void setUpsTracking(String upsTracking) {
        this.upsTracking = upsTracking;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Paid getPaid() {
        return paid;
    }

    public void setPaid(Paid paid) {
        this.paid = paid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof BuyOrder)) return false;
//        BuyOrder buyOrder = (BuyOrder) o;
//        return id != null && id.equals(((BuyOrder) o).getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, comment, price, consignee, weight, upsTracking, dateSent, dateReceived, paid, status, user);
//    }
}
