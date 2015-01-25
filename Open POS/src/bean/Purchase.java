/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Administrator
 */
@Entity
@Table(name = "purchase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p"),
    @NamedQuery(name = "Purchase.findByPurchaseId", query = "SELECT p FROM Purchase p WHERE p.purchaseId = :purchaseId"),
    @NamedQuery(name = "Purchase.findByDate", query = "SELECT p FROM Purchase p WHERE p.date = :date"),
    @NamedQuery(name = "Purchase.findByDiscount", query = "SELECT p FROM Purchase p WHERE p.discount = :discount")})
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PurchaseId")
    private Integer purchaseId;
    @Column(name = "_Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Discount")
    private Double discount;
    @OneToMany(mappedBy = "purchaseId")
    private Collection<Supplierpayment> supplierpaymentCollection;
    @OneToMany(mappedBy = "purchaseId")
    private Collection<Purchaseline> purchaselineCollection;
    @OneToMany(mappedBy = "purchaseId")
    private Collection<Stock> stockCollection;
    @JoinColumn(name = "SupplierId", referencedColumnName = "SupplierId")
    @ManyToOne
    private Supplier supplierId;

    public Purchase() {
    }

    public Purchase(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @XmlTransient
    public Collection<Supplierpayment> getSupplierpaymentCollection() {
        return supplierpaymentCollection;
    }

    public void setSupplierpaymentCollection(Collection<Supplierpayment> supplierpaymentCollection) {
        this.supplierpaymentCollection = supplierpaymentCollection;
    }

    @XmlTransient
    public Collection<Purchaseline> getPurchaselineCollection() {
        return purchaselineCollection;
    }

    public void setPurchaselineCollection(Collection<Purchaseline> purchaselineCollection) {
        this.purchaselineCollection = purchaselineCollection;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseId != null ? purchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.purchaseId == null && other.purchaseId != null) || (this.purchaseId != null && !this.purchaseId.equals(other.purchaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Purchase[ purchaseId=" + purchaseId + " ]";
    }
    
}
