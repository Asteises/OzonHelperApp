package ru.asteises.ozonhelperapp.common.json.model;

public interface OzonRestRequest<T> {

    T getFilter();

    void setFilter(T filter);

    String getLastId();

    void setLastId(String lastId);

    Integer getLimit();

    void setLimit(Integer limit);
}
