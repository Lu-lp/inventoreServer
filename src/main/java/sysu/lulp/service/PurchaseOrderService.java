package sysu.lulp.service;

import sysu.lulp.pojo.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

    public void savePurchaseOrder(PurchaseOrder purchaseOrder) throws Exception;

    public List<PurchaseOrder> getOrderListByType(int type);

    public void deletePurchaseOrder(int id);

    public void updatePurchaseOrder(PurchaseOrder purchaseOrder);

    public List<PurchaseOrder> getOrderListByStatus(int status);
}
