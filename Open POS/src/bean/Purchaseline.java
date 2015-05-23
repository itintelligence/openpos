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
@Table(name = "purchaseline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchaseline.findAll", query = "SELECT p FROM Purchaseline p"),
    @NamedQuery(name = "Purchaseline.findByQuantity", query = "SELECT p FROM Purchaseline p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Purchaseline.findByUnitPrice", query = "SELECT p FROM Purchaseline p WHERE p.unitPrice = :unitPrice"),
    @NamedQuery(name = "Purchaseline.findById", query = "SELECT p FROM Purchaseline p WHERE p.id = :id")})
public class Purchaseline implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Quantity")
    private Double quantity;
    @Column(name = "UnitPrice")
    private Double unitPrice;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "PurchaseId", referencedColumnName = "PurchaseId")
    @ManyToOne
    private Purchase purchaseId;

    public Purchaseline() {
    }

    public Purchaseline(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchaseline)) {
            return false;
        }
        Purchaseline other = (Purchaseline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Purchaseline[ id=" + id + " ]";
    }
    
}
