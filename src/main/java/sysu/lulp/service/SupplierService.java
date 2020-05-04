package sysu.lulp.service;

import sysu.lulp.pojo.Supplier;

import java.util.List;

public interface SupplierService {

    public void saveSupplier(Supplier supplier) throws Exception;

    public void updateSupplier(Supplier supplier) ;

    public List<Supplier> getAllSupplier();
}
