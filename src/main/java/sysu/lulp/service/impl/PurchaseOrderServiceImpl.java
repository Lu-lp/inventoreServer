package sysu.lulp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.lulp.mapper.PurchaseOrderMapper;
import sysu.lulp.pojo.PurchaseOrder;
import sysu.lulp.pojo.SysUser;
import sysu.lulp.service.PurchaseOrderService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private  final PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderMapper purchaseOrderMapper) {
        this.purchaseOrderMapper = purchaseOrderMapper;
    }

    @Override
    public void savePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception {
        purchaseOrderMapper.insert(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getOrderListByType(int type) {
        Example example = new Example(PurchaseOrder.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("type",type); // type 为1是采购订单, 2是退货单
        List<PurchaseOrder> result = purchaseOrderMapper.selectByExample(example);
        return result;
    }

    @Override
    public void deletePurchaseOrder(int id) {
        purchaseOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderMapper.updateByPrimaryKeySelective(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getOrderListByStatus(int status) {
        Example example = new Example(PurchaseOrder.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("status",status); // status为1是为提交审核 2是待审核 3 是审核成功
        List<PurchaseOrder> result = purchaseOrderMapper.selectByExample(example);
        return result;
    }
}
