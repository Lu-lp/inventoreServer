package sysu.lulp.VO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SupplierVO  implements Serializable {

    private Integer supplierId;

    /**
     * 供应商公司名称
     */
    private String supplierName;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String phoneNumber;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 供应商公司描述
     */
    private String description;
    public SupplierVO(){

    }
    public SupplierVO(Integer supplierId, String supplierName, String contact, String phoneNumber, String address, String description) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contact = contact;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
