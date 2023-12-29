package com.github.alinaberlin.restate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Property {

    @Id
    private Long id;
    private String address;
    private  PropertyType type;

    private  double price;
    private double area;
    private int bedrooms;
    private int bathrooms;
    private Date listingDate;

    public Property(Long id, String address, PropertyType type, double price, double area, int bedrooms, int bathrooms, Date listingDate) {
        this.id = id;
        this.address = address;
        this.type = type;
        this.price = price;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.listingDate = listingDate;
    }

    public Property() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(getPrice(), property.getPrice()) == 0 && Double.compare(getArea(), property.getArea()) == 0 && getBedrooms() == property.getBedrooms() && getBathrooms() == property.getBathrooms() && Objects.equals(getId(), property.getId()) && Objects.equals(getAddress(), property.getAddress()) && getType() == property.getType() && Objects.equals(getListingDate(), property.getListingDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getType(), getPrice(), getArea(), getBedrooms(), getBathrooms(), getListingDate());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", area=" + area +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", listingDate=" + listingDate +
                '}';
    }
}
