/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "supplierpayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplierpayment.findAll", query = "SELECT s FROM Supplierpayment s"),
    @NamedQuery(name = "Supplierpayment.findByPaymentId", query = "SELECT s FROM Supplierpayment s WHERE s.paymentId = :paymentId"),
    @NamedQuery(name = "Supplierpayment.findByPaidAmount", query = "SELECT s FROM Supplierpayment s WHERE s.paidAmount = :paidAmount"),
    @NamedQuery(name = "Supplierpayment.findByDate", query = "SELECT s FROM Supplierpayment s WHERE s.date = :date")})
public class Supplierpayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PaymentId")
    private Integer paymentId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PaidAmount")
    private Double paidAmount;
    @Column(name = "_Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "PurchaseId", referencedColumnName = "PurchaseId")
    @ManyToOne
    private Purchase purchaseId;
    @JoinColumn(name = "SupplierId", referencedColumnName = "SupplierId")
    @ManyToOne
    private Supplier supplierId;

    public Supplierpayment() {
    }

    public Supplierpayment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
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
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplierpayment)) {
            return false;
        }
        Supplierpayment other = (Supplierpayment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Supplierpayment[ paymentId=" + paymentId + " ]";
    }
    
}
