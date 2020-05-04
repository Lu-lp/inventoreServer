package sysu.lulp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.annotation.ExceptionProxy;
import sysu.lulp.VO.CustomerVO;
import sysu.lulp.VO.ResultVO;
import sysu.lulp.pojo.Customer;
import sysu.lulp.service.impl.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/lists")
    public ResultVO getCustomersList(){
        List<Customer> customerList = customerService.getAllCustomer();
        List<CustomerVO> temp = new ArrayList<>();
        if(customerList != null && customerList.size() != 0){
            for (Customer customer: customerList) {
                CustomerVO temp2 = new CustomerVO();
                BeanUtils.copyProperties(customer, temp2);
                temp.add(temp2);
            }
        }
        return new ResultVO(200, "获取成功", temp);
    }

    @PostMapping("")
    public ResultVO addCustomer(@RequestBody CustomerVO customerVO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerVO, customer);
        customer.setCreateTime(new Date());
        customer.setCustomerId(null);
        try{
            customerService.saveCustomer(customer);
        }catch (Exception e){
            logger.error(String.valueOf(e));
        }
        return new ResultVO(200, "获取成功", new String("1"));
    }
    @PostMapping("/item")
    public ResultVO updateCustomer(@RequestBody CustomerVO customerVO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerVO, customer);
        customerService.updateCustomer(customer);
        return new ResultVO(200, "获取成功", new String("1"));
    }
}
