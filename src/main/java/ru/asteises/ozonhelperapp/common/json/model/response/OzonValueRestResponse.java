package ru.asteises.ozonhelperapp.common.json.model.response;

public interface OzonValueRestResponse<T> {

    T getResult();

    void setResult(T result);
}
