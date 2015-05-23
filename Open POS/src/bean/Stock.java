/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByBarCode", query = "SELECT s FROM Stock s WHERE s.barCode = :barCode"),
    @NamedQuery(name = "Stock.findByQuantity", query = "SELECT s FROM Stock s WHERE s.quantity = :quantity")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BarCode")
    private String barCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Quantity")
    private Double quantity;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "PurchaseId", referencedColumnName = "PurchaseId")
    @ManyToOne
    private Purchase purchaseId;

    public Stock() {
    }

    public Stock(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barCode != null ? barCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.barCode == null && other.barCode != null) || (this.barCode != null && !this.barCode.equals(other.barCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Stock[ barCode=" + barCode + " ]";
    }
    
}
