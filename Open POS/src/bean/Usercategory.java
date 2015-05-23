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
@Table(name = "usercategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usercategory.findAll", query = "SELECT u FROM Usercategory u"),
    @NamedQuery(name = "Usercategory.findByUserCategoryId", query = "SELECT u FROM Usercategory u WHERE u.userCategoryId = :userCategoryId"),
    @NamedQuery(name = "Usercategory.findByName", query = "SELECT u FROM Usercategory u WHERE u.name = :name"),
    @NamedQuery(name = "Usercategory.findByRules", query = "SELECT u FROM Usercategory u WHERE u.rules = :rules")})
public class Usercategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserCategoryId")
    private Integer userCategoryId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Rules")
    private String rules;
    @OneToMany(mappedBy = "userCateGoryId")
    private Collection<User> userCollection;

    public Usercategory() {
    }

    public Usercategory(Integer userCategoryId) {
        this.userCategoryId = userCategoryId;
    }

    public Integer getUserCategoryId() {
        return userCategoryId;
    }

    public void setUserCategoryId(Integer userCategoryId) {
        this.userCategoryId = userCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCategoryId != null ? userCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usercategory)) {
            return false;
        }
        Usercategory other = (Usercategory) object;
        if ((this.userCategoryId == null && other.userCategoryId != null) || (this.userCategoryId != null && !this.userCategoryId.equals(other.userCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Usercategory[ userCategoryId=" + userCategoryId + " ]";
    }
    
}
