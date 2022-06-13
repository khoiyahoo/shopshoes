/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByUID", query = "SELECT a FROM Account a WHERE a.uID = :uID")
    , @NamedQuery(name = "Account.findByUser", query = "SELECT a FROM Account a WHERE a.user = :user")
    , @NamedQuery(name = "Account.findByPass", query = "SELECT a FROM Account a WHERE a.pass = :pass")
    , @NamedQuery(name = "Account.findByIsSell", query = "SELECT a FROM Account a WHERE a.isSell = :isSell")
    , @NamedQuery(name = "Account.findByIsAdmin", query = "SELECT a FROM Account a WHERE a.isAdmin = :isAdmin")
    , @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email")
    , @NamedQuery(name = "Account.findByCode", query = "SELECT a FROM Account a WHERE a.code = :code")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uID")
    private Integer uID;
    @Column(name = "user")
    private String user;
    @Column(name = "pass")
    private String pass;
    @Column(name = "isSell")
    private Integer isSell;
    @Column(name = "isAdmin")
    private Integer isAdmin;
    @Column(name = "email")
    private String email;
    @Column(name = "code")
    private String code;
    @OneToMany(mappedBy = "sellID")
    private Collection<Product> productCollection;
    @OneToMany(mappedBy = "accountID")
    private Collection<Cart> cartCollection;

    public Account() {
    }

    public Account(Integer uID) {
        this.uID = uID;
    }

    public Integer getUID() {
        return uID;
    }

    public void setUID(Integer uID) {
        this.uID = uID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getIsSell() {
        return isSell;
    }

    public void setIsSell(Integer isSell) {
        this.isSell = isSell;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uID != null ? uID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.uID == null && other.uID != null) || (this.uID != null && !this.uID.equals(other.uID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shop.model.jpa.Account[ uID=" + uID + " ]";
    }
    
}
