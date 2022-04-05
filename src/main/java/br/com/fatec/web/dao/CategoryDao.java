package br.com.fatec.web.dao;

import br.com.fatec.web.domain.Category;
import br.com.fatec.web.domain.IDominio;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements IDAO {
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

        Category category = new Category();
        category.setName("Gerente");
        category.setId(1);
        category.setObservation("Responsavel pelo Ecommerce");

        return category;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        List<IDominio> categoryList = new ArrayList<IDominio>();

        Category category = new Category();
        category.setName("Gerente");
        category.setId(1);
        category.setObservation("Responsavel pelo Ecommerce");

        categoryList.add(
                category
        );

        return categoryList;
    }
}
