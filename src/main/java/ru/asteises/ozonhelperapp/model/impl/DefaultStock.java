package ru.asteises.ozonhelperapp.model.impl;

import lombok.Builder;
import lombok.ToString;
import ru.asteises.ozonhelperapp.model.Stock;

@ToString
@Builder
public class DefaultStock implements Stock {

    private String type;

    private Integer present;

    private Integer reserved;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Integer getPresent() {
        return present;
    }

    @Override
    public Integer getReserved() {
        return reserved;
    }
}
