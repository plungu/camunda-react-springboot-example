package com.camunda.poc.starter.usecase.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.util.List;

@Profile("ordering")
@Entity(name="pm_item")
public class OrderItem {

    private static final long serialVersionUID = -209110232715280386L;

    private @Version
    @JsonIgnore
    Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "itemsOrdered")
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private List<Order> orders;
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders){
        this.orders = orders;
    }

    @Column(nullable=false)
    private String product;
    @Column(nullable=true)
    private String pmiCode;
    @Column(nullable=true)
    private String pmiDescription;
    @Column(nullable=true)
    private String qrCode;
    @Column(nullable=true)
    private String productImage;
    @Column(nullable=true)
    private Integer quantity;

    public long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPmiCode() {
        return pmiCode;
    }

    public void setPmiCode(String pmiCode) {
        this.pmiCode = pmiCode;
    }

    public String getPmiDescription() {
        return pmiDescription;
    }

    public void setPmiDescription(String pmiDescription) {
        this.pmiDescription = pmiDescription;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
