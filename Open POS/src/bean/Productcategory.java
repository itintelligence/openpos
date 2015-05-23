/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "productcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productcategory.findAll", query = "SELECT p FROM Productcategory p"),
    @NamedQuery(name = "Productcategory.findByProductCategoryId", query = "SELECT p FROM Productcategory p WHERE p.productCategoryId = :productCategoryId"),
    @NamedQuery(name = "Productcategory.findByCategoryName", query = "SELECT p FROM Productcategory p WHERE p.categoryName = :categoryName")})
public class Productcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductCategoryId")
    private Integer productCategoryId;
    @Basic(optional = false)
    @Column(name = "CategoryName")
    private String categoryName;
    @OneToMany(mappedBy = "productCategoryId")
    private Collection<Product> productCollection;

    public Productcategory() {
    }

    public Productcategory(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Productcategory(Integer productCategoryId, String categoryName) {
        this.productCategoryId = productCategoryId;
        this.categoryName = categoryName;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCategoryId != null ? productCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productcategory)) {
            return false;
        }
        Productcategory other = (Productcategory) object;
        if ((this.productCategoryId == null && other.productCategoryId != null) || (this.productCategoryId != null && !this.productCategoryId.equals(other.productCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Productcategory[ productCategoryId=" + productCategoryId + " ]";
    }
    
}
