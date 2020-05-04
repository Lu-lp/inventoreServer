package sysu.lulp.service;

import sysu.lulp.pojo.Product;

import java.util.List;

public interface ProductService {

    public void saveProduct(Product product) throws Exception;

    public void updateProduct(Product product) ;

    public List<Product> getAllProducts();

    public Product getProductById(int id);
}
