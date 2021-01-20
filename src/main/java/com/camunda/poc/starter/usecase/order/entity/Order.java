package com.camunda.poc.starter.usecase.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Profile("ordering")
@Entity(name="pm_order")
public class Order {

    private static final long serialVersionUID = -209110232715280386L;

    private @Version
    @JsonIgnore
    Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "pm_item_id"),
            inverseJoinColumns = @JoinColumn(name = "pm_order_id"))
    List<OrderItem> itemsOrdered;

    @Column(nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(nullable=true)
    private String orderKey;

    @Column(nullable=true)
    private String comment;

    @Column(nullable=true)
    private boolean started;
    @Column(nullable=true)
    private boolean approved;
    @Column(nullable=true)
    private boolean rejected;

    @Column(nullable=true)
    private String status;

    @Column(nullable=true)
    private String salesManager;

    @Column(nullable=true)
    private String category;

    @Column(nullable=true)
    private String repName;

    @Column(nullable=true)
    private String email;

    @Column(nullable=true)
    private String deliveryAddress;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalesManager() {
        return salesManager;
    }

    public void setSalesManager(String salesManager) {
        this.salesManager = salesManager;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
