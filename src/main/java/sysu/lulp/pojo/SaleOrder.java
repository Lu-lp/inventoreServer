package sysu.lulp.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "sale_order")
public class SaleOrder {
    @Id
    @Column(name = "sale_order_id")
    private Integer saleOrderId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 客户id
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 客户名称
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 订单号
     */
    @Column(name = "order_number")
    private Date orderNumber;

    /**
     * 单价
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 总价
     */
    @Column(name = "total_price")
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
    @Column(name = "audit_result")
    private Integer auditResult;

    /**
     * 审核时间
     */
    @Column(name = "audit_time")
    private Date auditTime;

    /**
     * 入库人/出库人
     */
    private String rukuren;

    /**
     * 入库时间/出库时间
     */
    @Column(name = "ruku_time")
    private Date rukuTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 订单类型：1销售or0退货
     */
    private Integer type;

    /**
     * @return sale_order_id
     */
    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    /**
     * @param saleOrderId
     */
    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    /**
     * 获取商品id
     *
     * @return product_id - 商品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品id
     *
     * @param productId 商品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取客户id
     *
     * @return customer_id - 客户id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id
     *
     * @param customerId 客户id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取客户名称
     *
     * @return customer_name - 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置客户名称
     *
     * @param customerName 客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取订单号
     *
     * @return order_number - 订单号
     */
    public Date getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单号
     *
     * @param orderNumber 订单号
     */
    public void setOrderNumber(Date orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取单价
     *
     * @return unit_price - 单价
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置单价
     *
     * @param unitPrice 单价
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取数量
     *
     * @return number - 数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置数量
     *
     * @param number 数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取总价
     *
     * @return total_price - 总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价
     *
     * @param totalPrice 总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取状态{0:待审核；1: 审核成功待入库;2: 订单完成; -1: 订单取消}
     *
     * @return status - 状态{0:待审核；1: 审核成功待入库;2: 订单完成; -1: 订单取消}
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态{0:待审核；1: 审核成功待入库;2: 订单完成; -1: 订单取消}
     *
     * @param status 状态{0:待审核；1: 审核成功待入库;2: 订单完成; -1: 订单取消}
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取审核人
     *
     * @return auditor - 审核人
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     * 设置审核人
     *
     * @param auditor 审核人
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    /**
     * 获取审核结果
     *
     * @return audit_result - 审核结果
     */
    public Integer getAuditResult() {
        return auditResult;
    }

    /**
     * 设置审核结果
     *
     * @param auditResult 审核结果
     */
    public void setAuditResult(Integer auditResult) {
        this.auditResult = auditResult;
    }

    /**
     * 获取审核时间
     *
     * @return audit_time - 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取入库人/出库人
     *
     * @return rukuren - 入库人/出库人
     */
    public String getRukuren() {
        return rukuren;
    }

    /**
     * 设置入库人/出库人
     *
     * @param rukuren 入库人/出库人
     */
    public void setRukuren(String rukuren) {
        this.rukuren = rukuren;
    }

    /**
     * 获取入库时间/出库时间
     *
     * @return ruku_time - 入库时间/出库时间
     */
    public Date getRukuTime() {
        return rukuTime;
    }

    /**
     * 设置入库时间/出库时间
     *
     * @param rukuTime 入库时间/出库时间
     */
    public void setRukuTime(Date rukuTime) {
        this.rukuTime = rukuTime;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取订单类型：1销售or0退货
     *
     * @return type - 订单类型：1销售or0退货
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置订单类型：1销售or0退货
     *
     * @param type 订单类型：1销售or0退货
     */
    public void setType(Integer type) {
        this.type = type;
    }
}