package sysu.lulp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sysu.lulp.VO.PurchaseOrderVO;
import sysu.lulp.VO.ResultVO;
import sysu.lulp.pojo.Product;
import sysu.lulp.pojo.PurchaseOrder;
import sysu.lulp.service.impl.ProductServiceImpl;
import sysu.lulp.service.impl.PurchaseOrderServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {
    private Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);

    private final PurchaseOrderServiceImpl purchaseOrderService;

    private final ProductServiceImpl productService;
    @Autowired
    public PurchaseOrderController(PurchaseOrderServiceImpl purchaseOrderService, ProductServiceImpl productService) {
        this.purchaseOrderService = purchaseOrderService;
        this.productService = productService;
    }
    @PostMapping("")
    public ResultVO addOrder(@RequestBody PurchaseOrderVO purchaseOrderVO){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(purchaseOrderVO,purchaseOrder);
        purchaseOrder.setStatus(1);
        purchaseOrder.setType(1);
        purchaseOrder.setCreateTime(new Date());
        purchaseOrder.setOrderNumber(new Date());
        purchaseOrder.setPurchaseOrderId(null);
        try{
            purchaseOrderService.savePurchaseOrder(purchaseOrder);
        }catch (Exception e){
            logger.warn(String.valueOf(e));
        }
        logger.info("添加采购订单成功");
        return new ResultVO(200, "添加采购订单成功", new String("1"));
    }
    @GetMapping("/orderList")
    public ResultVO getOrderList(@RequestParam(name = "type") int type){
        List<PurchaseOrder> purchaseOrderList = purchaseOrderService.getOrderListByType(type);
        List<PurchaseOrderVO> purchaseOrderVOList = new ArrayList<>();
        if(purchaseOrderList != null && purchaseOrderList.size() != 0){
            for (PurchaseOrder purchaseOrder: purchaseOrderList) {
                PurchaseOrderVO temp = new PurchaseOrderVO();
                BeanUtils.copyProperties(purchaseOrder,temp);
                purchaseOrderVOList.add(temp);
            }
        }
        logger.info("获取类型为[{}]的订单",type);
        return new ResultVO(200, "获取采购订单成功", purchaseOrderVOList);
    }
    @GetMapping("/orderList/audit")
    public ResultVO getWaitingAuditOrderList(@RequestParam(name = "status") int status){
        List<PurchaseOrder> purchaseOrderList = purchaseOrderService.getOrderListByStatus(status);
        logger.info("获取状态为[{}]的订单",status);
        List<PurchaseOrderVO> purchaseOrderVOList = new ArrayList<>();
        if(purchaseOrderList != null && purchaseOrderList.size() != 0){
            for (PurchaseOrder purchaseOrder: purchaseOrderList) {
                PurchaseOrderVO temp = new PurchaseOrderVO();
                BeanUtils.copyProperties(purchaseOrder,temp);
                purchaseOrderVOList.add(temp);
            }
        }
        return new ResultVO(200, "添加采购订单成功", purchaseOrderVOList);

    }
    @DeleteMapping("")
    public ResultVO deleteOrder(@RequestParam(name = "id")int id){
        purchaseOrderService.deletePurchaseOrder(id);
        logger.info("删除订单成功");
        return new ResultVO(200, "删除采购订单成功",new String("1"));
    }
    @PostMapping("/item")
    public ResultVO updateOrder(@RequestBody PurchaseOrderVO purchaseOrderVO){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(purchaseOrderVO, purchaseOrder);
        // 如果订单状态为3 代表审核成功 进行相应的库存增减
        logger.info("更新销售单状态为[{}]",purchaseOrder.getStatus());
        if(purchaseOrder.getStatus() == 3 && purchaseOrder.getAuditResult() == null){
            purchaseOrder.setAuditTime(new Date());
            Product product = productService.getProductById(purchaseOrder.getProductId());
            if(purchaseOrder.getType() == 1){
                product.setStock(product.getStock() + purchaseOrder.getNumber());
            }else{
                product.setStock(product.getStock() - purchaseOrder.getNumber());
            }
            productService.updateProduct(product);
            purchaseOrder.setRukuTime(new Date());
        }
        purchaseOrder.setAuditResult(null);
        purchaseOrderService.updatePurchaseOrder(purchaseOrder);
        return new ResultVO(200, "更新销售订单成功",new String("1"));
    }
}
