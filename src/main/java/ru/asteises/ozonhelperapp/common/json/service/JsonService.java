package ru.asteises.ozonhelperapp.common.json.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public interface JsonService {

    Logger log = LoggerFactory.getLogger(JsonService.class);

    static <T> T parseJsonToDomain(String json, Class<T> clazz, ObjectMapper objectMapper) {

        JsonNode node = getNodeFromJsonString(json, objectMapper);
        return getObjectFromJsonNode(node, clazz, objectMapper);
    }

    static JsonNode getNodeFromJsonString(String json, ObjectMapper objectMapper) {
        try {
            return objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong when parsing json from string: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    static  <T> T getObjectFromJsonNode(JsonNode node, Class<T> clazz, ObjectMapper objectMapper) {
        try {
            return objectMapper.treeToValue(node, clazz);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong when parsing json from node: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    static String getJsonFromMap(Map<String, Object> data, ObjectMapper objectMapper) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong when parsing json from map: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    static  <T> String getJsonFromObject(T requestObject, ObjectMapper objectMapper) {
        try {
            return objectMapper.writeValueAsString(requestObject);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong when parsing json from object: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
