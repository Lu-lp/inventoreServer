package sysu.lulp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.lulp.mapper.SaleOrderMapper;
import sysu.lulp.pojo.PurchaseOrder;
import sysu.lulp.pojo.SaleOrder;
import sysu.lulp.service.SaleOrderService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {
    private final SaleOrderMapper saleOrderMapper;

    @Autowired
    public SaleOrderServiceImpl(SaleOrderMapper saleOrderMapper) {
        this.saleOrderMapper = saleOrderMapper;
    }

    @Override
    public void saveSaleOrder(SaleOrder saleOrder) throws Exception {
        saleOrderMapper.insert(saleOrder);
    }

    @Override
    public List<SaleOrder> getOrderListByType(int type) {
        Example example = new Example(SaleOrder.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("type",type); // type 为1是销售订单, 2是退货单
        List<SaleOrder> result = saleOrderMapper.selectByExample(example);
        return result;
    }

    @Override
    public void deleteSaleOrder(int id) {
        saleOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateSaleOrder(SaleOrder saleOrder) {
        saleOrderMapper.updateByPrimaryKeySelective(saleOrder);
    }

    @Override
    public List<SaleOrder> getOrderListByStatus(int status) {
        Example example = new Example(SaleOrder.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("status",status); // status为1是为提交审核 2是待审核 3 是审核成功
        List<SaleOrder> result = saleOrderMapper.selectByExample(example);
        return result;
    }
}
