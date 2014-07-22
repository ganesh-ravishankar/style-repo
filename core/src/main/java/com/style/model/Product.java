package com.style.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

/**
 * This class represents the basic "product" object in VSU that allows for
 * managing product
 * 
 * @auther ganesh
 * @author mathi
 */
@Entity
@Table(name = "vsu_product")
@Indexed
@XmlRootElement
public class Product extends BaseObject implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private String id;
    private String productName;
    private boolean isComboProduct;
    private String gender;
    private Set<ProductPrice> productPrices = new HashSet<ProductPrice>();
    private ProductPrice price = new ProductPrice();

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name="is_combo_product")
    public boolean isComboProduct() {
        return isComboProduct;
    }

    public void setComboProduct(boolean isComboProduct) {
        this.isComboProduct = isComboProduct;
    }

    @Column(name="gender")
    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ProductPrice.class, mappedBy = "product", fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderBy("id")
    @Fetch(value = FetchMode.SELECT)
    public Set<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Set<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Transient
    public ProductPrice getPrice() {
        if(!getProductPrices().isEmpty()){
            for(ProductPrice productPrice : getProductPrices()){
                price = productPrice;
                break;
            }
        }
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this,
                ToStringStyle.DEFAULT_STYLE).append("productName",
                this.productName);
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }

        final Product product = (Product) o;

        return !(id != null ? !id.equals(product.getId())
                : product.getId() != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (id != null ? id.hashCode() : 0);
    }

}
