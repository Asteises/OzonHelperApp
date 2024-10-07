package ru.asteises.ozonhelperapp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.asteises.ozonhelperapp.service.ProductService;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ProductRestService implements ProductService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

}
