package sysu.lulp.VO;


import java.io.Serializable;

public class CustomerVO implements Serializable {

    private Integer customerId;

    /**
     * 客户公司名称
     */
    private String customerName;

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
     * 客户公司描述
     */
    private String description;

    public CustomerVO(Integer customerId, String customerName, String contact, String phoneNumber, String address, String description) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contact = contact;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
    }
    public CustomerVO(){

    }
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
