package ru.asteises.ozonhelperapp.common.json.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.asteises.ozonhelperapp.common.json.model.value.ProductListValueOzonRestRequestJson;
import ru.asteises.ozonhelperapp.common.json.service.JsonService;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonServiceImpl implements JsonService {

    private final ObjectMapper objectMapper;

    @Override
    public <T> T parseJsonToDomain(String json, Class<T> clazz) {

        JsonNode node = getNodeFromJsonString(json);
        return getObjectFromJsonNode(node, clazz);
    }

    @Override
    public JsonNode getNodeFromJsonString(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong when parsing json from string: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T getObjectFromJsonNode(JsonNode node, Class<T> clazz) {
        try {
            return objectMapper.treeToValue(node, clazz);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong when parsing json from node: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getJsonFromMap(Map<String, Object> data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong when parsing json from map: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> String getJsonFromObject(T requestObject) {
        try {
            return objectMapper.writeValueAsString(requestObject);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong when parsing json from object: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
