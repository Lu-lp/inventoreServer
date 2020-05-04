package sysu.lulp.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PurchaseOrderVO implements Serializable {

    private Integer purchaseOrderId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;


    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态{0:待审核；1: 审核成功待入库;2: 订单完成; -1: 订单取消}
     */
    private Integer status;

    /**
     * 审核人
     */
    private String auditor;

    /**
     * 审核结果
     */
    private Integer auditResult;

    /**
     * 审核时间
     */
    private Date auditTime;
    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */

    private Date createTime;

    /**
     * 订单类型：1采购or0退货
     */
    private Integer type;

    public PurchaseOrderVO() {
    }

    public PurchaseOrderVO(Integer purchaseOrderId, Integer productId, String productName, Integer supplierId, String supplierName, BigDecimal unitPrice, Integer number, BigDecimal totalPrice, String description, Integer status, String auditor, Integer auditResult, Date auditTime, String creator, Date createTime, Integer type) {
        this.purchaseOrderId = purchaseOrderId;
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.unitPrice = unitPrice;
        this.number = number;
        this.totalPrice = totalPrice;
        this.description = description;
        this.status = status;
        this.auditor = auditor;
        this.auditResult = auditResult;
        this.auditTime = auditTime;
        this.creator = creator;
        this.createTime = createTime;
        this.type = type;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Integer getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Integer auditResult) {
        this.auditResult = auditResult;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
