package sysu.lulp.service;

import sysu.lulp.pojo.Customer;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(Customer customer) throws Exception;

    public void updateCustomer(Customer customer) ;

    public List<Customer> getAllCustomer();
}
