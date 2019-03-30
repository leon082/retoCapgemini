/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Leon
 */
@Entity
@Table(name = "customer_product", catalog = "mybank", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerProduct.findAll", query = "SELECT c FROM CustomerProduct c")
    , @NamedQuery(name = "CustomerProduct.findById", query = "SELECT c FROM CustomerProduct c WHERE c.id = :id")
    , @NamedQuery(name = "CustomerProduct.findByCreationDate", query = "SELECT c FROM CustomerProduct c WHERE c.creationDate = :creationDate")
    , @NamedQuery(name = "CustomerProduct.findByTerminationDate", query = "SELECT c FROM CustomerProduct c WHERE c.terminationDate = :terminationDate")
    , @NamedQuery(name = "CustomerProduct.findByBalance", query = "SELECT c FROM CustomerProduct c WHERE c.balance = :balance")
    , @NamedQuery(name = "CustomerProduct.findByStatus", query = "SELECT c FROM CustomerProduct c WHERE c.status = :status")
    , @NamedQuery(name = "CustomerProduct.findByProductNumber", query = "SELECT c FROM CustomerProduct c WHERE c.productNumber = :productNumber")})
public class CustomerProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "termination_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationDate;
    @Basic(optional = false)
    @Column(name = "balance")
    private long balance;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "product_number")
    private String productNumber;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;

    public CustomerProduct() {
    }

    public CustomerProduct(Integer id) {
        this.id = id;
    }

    public CustomerProduct(Integer id, Date creationDate, long balance, String status, String productNumber) {
        this.id = id;
        this.creationDate = creationDate;
        this.balance = balance;
        this.status = status;
        this.productNumber = productNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerProduct)) {
            return false;
        }
        CustomerProduct other = (CustomerProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication29.CustomerProduct[ id=" + id + " ]";
    }
    
}
