package ru.asteises.ozonhelperapp.model.impl;

import lombok.Builder;
import lombok.ToString;
import ru.asteises.ozonhelperapp.model.ProductStockNode;
import ru.asteises.ozonhelperapp.model.Stock;

import java.util.List;

@ToString
@Builder
public class DefaultProductStockNode implements ProductStockNode {

    private Integer productId;

    private String offerId;

    private List<Stock> stocks;

    @Override
    public Integer getProductId() {
        return productId;
    }

    @Override
    public String getOfferId() {
        return offerId;
    }

    @Override
    public List<Stock> getStocks() {
        return stocks;
    }
}
