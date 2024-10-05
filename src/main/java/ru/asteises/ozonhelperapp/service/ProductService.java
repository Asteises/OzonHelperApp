package ru.asteises.ozonhelperapp.service;

import ru.asteises.ozonhelperapp.model.ProductShortNode;

import java.util.List;

public interface ProductService {

    List<ProductShortNode> getProductByVisibilityAll();

    List<ProductShortNode> getProductByVisibilityArchived();

    List<ProductShortNode> getActualProductByVisibilityArchived();
}
