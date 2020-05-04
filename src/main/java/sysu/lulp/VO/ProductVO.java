package sysu.lulp.VO;


import java.io.Serializable;

public class ProductVO  implements Serializable {
    private Integer productId;
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品品牌
     */
    private String brand;

    /**
     * 商品规格
     */
    private String size;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 售价
     */
    private Long price;

    public ProductVO(Integer productId, String productName, String brand, String size, String description, Integer status, Integer stock, Long price) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.size = size;
        this.description = description;
        this.status = status;
        this.stock = stock;
        this.price = price;
    }

    public ProductVO(){

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
