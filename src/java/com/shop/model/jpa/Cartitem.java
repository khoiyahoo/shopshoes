/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "cartitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartitem.findAll", query = "SELECT c FROM Cartitem c")
    , @NamedQuery(name = "Cartitem.findByCartitemid", query = "SELECT c FROM Cartitem c WHERE c.cartitemid = :cartitemid")
    , @NamedQuery(name = "Cartitem.findByAmount", query = "SELECT c FROM Cartitem c WHERE c.amount = :amount")})
public class Cartitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cartitemid")
    private Integer cartitemid;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "productid", referencedColumnName = "pid")
    @ManyToOne
    private Product productid;
    @JoinColumn(name = "cartid", referencedColumnName = "cartid")
    @ManyToOne
    private Cart cartid;

    public Cartitem() {
    }

    public Cartitem(Integer cartitemid) {
        this.cartitemid = cartitemid;
    }

    public Cartitem(Integer cartitemid, int amount) {
        this.cartitemid = cartitemid;
        this.amount = amount;
    }

    public Integer getCartitemid() {
        return cartitemid;
    }

    public void setCartitemid(Integer cartitemid) {
        this.cartitemid = cartitemid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    public Cart getCartid() {
        return cartid;
    }

    public void setCartid(Cart cartid) {
        this.cartid = cartid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartitemid != null ? cartitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartitem)) {
            return false;
        }
        Cartitem other = (Cartitem) object;
        if ((this.cartitemid == null && other.cartitemid != null) || (this.cartitemid != null && !this.cartitemid.equals(other.cartitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shop.model.jpa.Cartitem[ cartitemid=" + cartitemid + " ]";
    }
    
}
