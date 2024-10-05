package ru.asteises.ozonhelperapp.model.impl;

import lombok.Builder;
import lombok.ToString;
import ru.asteises.ozonhelperapp.model.ProductShortNode;

@ToString
@Builder
public class DefaultProductShortNodeDomain implements ProductShortNode {

    private Integer productId;

    private String offerId;

    private boolean fboVisible;

    private boolean fbsVisible;

    private boolean archived;

    private boolean discounted;

    @Override
    public Integer getProductId() {
        return productId;
    }

    @Override
    public String getOfferId() {
        return offerId;
    }

    @Override
    public boolean getFboVisible() {
        return fboVisible;
    }

    @Override
    public boolean getFbsVisible() {
        return fbsVisible;
    }

    @Override
    public boolean getArchived() {
        return archived;
    }

    @Override
    public boolean getDiscounted() {
        return discounted;
    }
}
