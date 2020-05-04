package sysu.lulp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.annotation.ExceptionProxy;
import sysu.lulp.VO.ProductVO;
import sysu.lulp.VO.ResultVO;
import sysu.lulp.pojo.Product;
import sysu.lulp.pojo.SysUser;
import sysu.lulp.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/lists")
    public ResultVO getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        List<ProductVO> temp = new ArrayList<>();
        if(productList != null && productList.size() != 0){
            for (Product product : productList) {
                ProductVO temp2 = new ProductVO();
                BeanUtils.copyProperties(product, temp2);
                temp.add(temp2);
            }
        }
        return new ResultVO(200, "获取成功", temp);
    }

    @PostMapping("")
    public ResultVO addProduct(@RequestBody ProductVO productVO){
        Product temp = new Product();
        BeanUtils.copyProperties(productVO,temp);
        logger.info("新增商品id:[{}]", temp.getProductId());
        temp.setProductId(null);
        temp.setCreateTime(new Date());
        try{
            productService.saveProduct(temp);
        }catch (Exception e){
            logger.warn(String.valueOf(e));
        }
        logger.info("添加商品成功");
        return new ResultVO(200, "添加商品成功", new String("1"));
    }

    @PostMapping("/item")
    public ResultVO updateProduct(@RequestBody ProductVO productVO){
        Product temp = new Product();
        BeanUtils.copyProperties(productVO,temp);
        productService.updateProduct(temp);
        return new ResultVO(200, "获取成功", new String("1"));
    }
}
