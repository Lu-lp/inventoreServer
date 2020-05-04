package sysu.lulp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sysu.lulp.VO.ResultVO;
import sysu.lulp.VO.SupplierVO;
import sysu.lulp.pojo.Supplier;
import sysu.lulp.service.impl.SupplierServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierServiceImpl supplierService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public SupplierController(SupplierServiceImpl supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("lists")
    public ResultVO getSuppliersList(){
        List<Supplier> supplierList = supplierService.getAllSupplier();
        List<SupplierVO> temp = new ArrayList<>();
        if(supplierList != null && supplierList.size() != 0){
            for ( Supplier supplier: supplierList) {
                SupplierVO temp2 = new SupplierVO();
                BeanUtils.copyProperties(supplier, temp2);
                temp.add(temp2);
            }
        }
        return new ResultVO(200, "获取成功", temp);
    }

    @PostMapping("")
    public ResultVO addSupplier(@RequestBody SupplierVO supplierVO){
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierVO,supplier);
        supplier.setSupplierId(null);
        supplier.setCreateTime(new Date());
        try{
            supplierService.saveSupplier(supplier);
        }catch (Exception e){
            logger.error(String.valueOf(e));
        }
        return new ResultVO(200, "添加成功", new String("1"));
    }
    @PostMapping("/item")
    public ResultVO updateSupplier(@RequestBody SupplierVO supplierVO){
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierVO,supplier);
        supplierService.updateSupplier(supplier);
        return new ResultVO(200, "更新成功", new String("1"));
    }

}
