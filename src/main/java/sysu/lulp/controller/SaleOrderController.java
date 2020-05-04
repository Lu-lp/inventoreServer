package sysu.lulp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sysu.lulp.VO.ResultVO;
import sysu.lulp.VO.SaleOrderVO;
import sysu.lulp.pojo.Product;
import sysu.lulp.pojo.SaleOrder;
import sysu.lulp.service.impl.ProductServiceImpl;
import sysu.lulp.service.impl.SaleOrderServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/saleOrder")
public class SaleOrderController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderController.class);

    private final SaleOrderServiceImpl saleOrderService;

    private final ProductServiceImpl productService;

    @Autowired
    public SaleOrderController(SaleOrderServiceImpl saleOrderService, ProductServiceImpl productService) {
        this.saleOrderService = saleOrderService;
        this.productService = productService;
    }
    @PostMapping("")
    public ResultVO addOrder(@RequestBody SaleOrderVO saleOrderVO){
        SaleOrder saleOrder = new SaleOrder();
        BeanUtils.copyProperties(saleOrderVO,saleOrder);
        saleOrder.setStatus(1);
        saleOrder.setType(1);
        saleOrder.setCreateTime(new Date());
        saleOrder.setOrderNumber(new Date());
        saleOrder.setSaleOrderId(null);
        try{
            saleOrderService.saveSaleOrder(saleOrder);
        }catch (Exception e){
            logger.warn(String.valueOf(e));
        }
        logger.info("添加销售订单成功");
        return new ResultVO(200, "添加销售订单成功", new String("1"));
    }

    @GetMapping("/orderList")
    public ResultVO getOrderList(@RequestParam(name = "type") int type){
        List<SaleOrder> saleOrderList = saleOrderService.getOrderListByType(type);
        List<SaleOrderVO> saleOrderVOList = new ArrayList<>();
        if(saleOrderList != null && saleOrderList.size() != 0){
            for (SaleOrder saleOrder: saleOrderList) {
                SaleOrderVO temp = new SaleOrderVO();
                BeanUtils.copyProperties(saleOrder,temp);
                saleOrderVOList.add(temp);
            }
        }
        logger.info("获取类型为[{}]的销售订单",type);
        return new ResultVO(200, "获取销售订单成功", saleOrderVOList);
    }

    @GetMapping("/orderList/audit")
    public ResultVO getWaitingAuditOrderList(@RequestParam(name = "status") int status){
        List<SaleOrder> saleOrderList = saleOrderService.getOrderListByStatus(status);
        logger.info("获取状态为[{}]的销售订单",status);
        List<SaleOrderVO> saleOrderVOList = new ArrayList<>();
        if(saleOrderList != null && saleOrderList.size() != 0){
            for (SaleOrder saleOrder: saleOrderList) {
                SaleOrderVO temp = new SaleOrderVO();
                BeanUtils.copyProperties(saleOrder,temp);
                saleOrderVOList.add(temp);
            }
        }
        return new ResultVO(200, "添加采购订单成功", saleOrderVOList);
    }
    @DeleteMapping("")
    public ResultVO deleteOrder(@RequestParam(name = "id")int id){
        saleOrderService.deleteSaleOrder(id);
        logger.info("删除订单成功");
        return new ResultVO(200, "删除销售订单成功",new String("1"));
    }

    @PostMapping("/item")
    public ResultVO updateOrder(@RequestBody SaleOrderVO saleOrderVO){
        SaleOrder saleOrder = new SaleOrder();
        BeanUtils.copyProperties(saleOrderVO, saleOrder);
        // 如果订单状态为3 代表审核成功 进行相应的库存增减
        logger.info("更新销售单状态为[{}]",saleOrder.getStatus());
        if(saleOrder.getStatus() == 3 && saleOrder.getAuditResult() == null){
            saleOrder.setAuditTime(new Date());
            Product product = productService.getProductById(saleOrder.getProductId());
            if(saleOrder.getType() == 1){
                product.setStock(product.getStock() - saleOrder.getNumber());
            }else{
                product.setStock(product.getStock() + saleOrder.getNumber());
            }
            productService.updateProduct(product);
            saleOrder.setRukuTime(new Date());
        }
        saleOrder.setAuditResult(null);
        saleOrderService.updateSaleOrder(saleOrder);
        return new ResultVO(200, "更新销售订单成功",new String("1"));
    }
}
