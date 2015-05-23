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
@Table(name = "salesline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salesline.findAll", query = "SELECT s FROM Salesline s"),
    @NamedQuery(name = "Salesline.findByQuantity", query = "SELECT s FROM Salesline s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Salesline.findByUnitPrice", query = "SELECT s FROM Salesline s WHERE s.unitPrice = :unitPrice"),
    @NamedQuery(name = "Salesline.findById", query = "SELECT s FROM Salesline s WHERE s.id = :id")})
public class Salesline implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Quantity")
    private Double quantity;
    @Basic(optional = false)
    @Column(name = "UnitPrice")
    private double unitPrice;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "SalesId", referencedColumnName = "SalesId")
    @ManyToOne(optional = false)
    private Sales salesId;

    public Salesline() {
    }

    public Salesline(Integer id) {
        this.id = id;
    }

    public Salesline(Integer id, double unitPrice) {
        this.id = id;
        this.unitPrice = unitPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
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

    public Sales getSalesId() {
        return salesId;
    }

    public void setSalesId(Sales salesId) {
        this.salesId = salesId;
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
        if (!(object instanceof Salesline)) {
            return false;
        }
        Salesline other = (Salesline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Salesline[ id=" + id + " ]";
    }
    
}
