package ru.asteises.ozonhelperapp.common.json.model.response;

import java.util.List;

/**
 * Интерфейс для создания моделей ответов из Ozon.
 * @param <T> - типизированный список.
 */
public interface OzonRestResponse<T> {

    List<T> getItems();

    void setItems(List<T> items);

    Integer getTotal();

    void setTotal(Integer total);

    String getLastId();

    void setLastId(String lastId);
}
