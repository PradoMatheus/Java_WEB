package br.com.fatec.web.dao;

import br.com.fatec.web.domain.Category;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IDAO {
    @Override
    public boolean save(IDominio domain) {
        return false;
    }

    @Override
    public boolean delete(IDominio domain) {
        return false;
    }

    @Override
    public IDominio search(IDominio domain) {
        Product product = new Product();
        product.setId(1);
        product.setName("Coca Cola 1.5L");
        product.setActive(true);
        product.setDescription("Cola Cola de 1.5 Litros Descartavel");
        product.setEan("12345678909009");
        product.setValue(7.79);

        Category category = new Category();
        category.setName("Bebida");
        product.setCategory(category);

        return product;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        List<IDominio> productList = new ArrayList<IDominio>();

        Product product = new Product();
        product.setId(1);
        product.setName("Coca Cola 2L");
        product.setActive(true);
        product.setDescription("Cola Cola de 2 Litros Descartavel");
        product.setEan("12345678909009");
        product.setValue(7.79);

        Category category = new Category();
        category.setName("Bebida");
        product.setCategory(category);

        productList.add(product);

        return productList;
    }
}
