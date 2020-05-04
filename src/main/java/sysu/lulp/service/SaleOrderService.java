package sysu.lulp.service;

import sysu.lulp.pojo.PurchaseOrder;
import sysu.lulp.pojo.SaleOrder;

import java.util.List;

public interface SaleOrderService {
    public void saveSaleOrder(SaleOrder saleOrder) throws Exception;

    public List<SaleOrder> getOrderListByType(int type);

    public void deleteSaleOrder(int id);

    public void updateSaleOrder(SaleOrder saleOrder);

    public List<SaleOrder> getOrderListByStatus(int status);
}
