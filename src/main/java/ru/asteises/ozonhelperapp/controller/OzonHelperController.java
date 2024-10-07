package ru.asteises.ozonhelperapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asteises.ozonhelperapp.service.ProductService;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OzonHelperController {

    // Вначале реализовать все стандартные методы
    private final ProductService productService;

}
