/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductId")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "ProductName")
    private String productName;
    @JoinColumn(name = "ProductCategoryId", referencedColumnName = "ProductCategoryId")
    @ManyToOne
    private Productcategory productCategoryId;
    @JoinColumn(name = "UnitId", referencedColumnName = "UnitId")
    @ManyToOne
    private Unit unitId;
    @OneToMany(mappedBy = "productId")
    private Collection<Purchaseline> purchaselineCollection;
    @OneToMany(mappedBy = "productId")
    private Collection<Stock> stockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Salesline> saleslineCollection;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Productcategory getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Productcategory productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
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

    @XmlTransient
    public Collection<Salesline> getSaleslineCollection() {
        return saleslineCollection;
    }

    public void setSaleslineCollection(Collection<Salesline> saleslineCollection) {
        this.saleslineCollection = saleslineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Product[ productId=" + productId + " ]";
    }
    
}
