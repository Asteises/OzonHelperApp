package ru.asteises.ozonhelperapp.common.json.service;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public interface JsonService {

    <T> T parseJsonToDomain(String json, Class<T> clazz);

    <T> T getObjectFromJsonNode(JsonNode node, Class<T> clazz);

    JsonNode getNodeFromJsonString(String json);

    String getJsonFromMap(Map<String, Object> data);

    <T> String getJsonFromObject(T requestObject);
}
