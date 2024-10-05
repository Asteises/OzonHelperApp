package ru.asteises.ozonhelperapp.model;

import java.util.List;

public interface ProductStockNode {

    Integer getProductId();

    String getOfferId();

    List<Stock> getStocks();
}
