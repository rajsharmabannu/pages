package org.dell.kube.pages;

import java.util.Objects;

public class Page {
    public Long id;
    public String businessName;
    public Long categoryId;
    public String address;
    public String contactNumber;

    public Page(Long id, String businessName, String address, Long categoryId, String contactNumber) {
        this.id = id;
        this.businessName = businessName;
        this.categoryId = categoryId;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Page() {
    }

    public Page(String businessName, String address, Long categoryId, String contactNumber) {
        this.businessName = businessName;
        this.categoryId = categoryId;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return Objects.equals(id, page.id) &&
                Objects.equals(businessName, page.businessName) &&
                Objects.equals(categoryId, page.categoryId) &&
                Objects.equals(address, page.address) &&
                Objects.equals(contactNumber, page.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, businessName, categoryId, address, contactNumber);
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", businessName='" + businessName + '\'' +
                ", categoryId=" + categoryId +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
