package sysu.lulp.mapper;

import org.springframework.stereotype.Component;
import sysu.lulp.pojo.Customer;
import sysu.lulp.utils.MyMapper;

@Component
public interface CustomerMapper extends MyMapper<Customer> {
}