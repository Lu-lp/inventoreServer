package sysu.lulp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.lulp.mapper.SupplierMapper;
import sysu.lulp.pojo.Supplier;
import sysu.lulp.service.SupplierService;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierMapper supplierMapper;

    @Autowired
    public SupplierServiceImpl(SupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }

    @Override
    public void saveSupplier(Supplier supplier) throws Exception {
        supplierMapper.insert(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierMapper.updateByPrimaryKeySelective(supplier);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierMapper.selectAll();
    }
}
