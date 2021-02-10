package com.edemko.warehousemanager.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sell_orders")
public class SellOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sell_order_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stock_item_id")//, nullable = false, insertable = false, updatable = false
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private StockItem stock;

    private String customer;
    private Date dateSold;
    private double shipping;
    private double price;
    private double costs;
    private double profit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")//, nullable = false, insertable = false, updatable = false
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StockItem getStock() {
        return stock;
    }

    public void setStock(StockItem stock) {
        this.stock = stock;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
