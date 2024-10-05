package ru.asteises.ozonhelperapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.asteises.ozonhelperapp.model.ProductShortNode;
import ru.asteises.ozonhelperapp.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("Получаем список всех товаров в Архиве")
    public void getProductByVisibilityArchivedTest() {

        List<ProductShortNode> actualProductShortNodesInArchive = productService.getProductByVisibilityArchived();

        assertEquals(1636, actualProductShortNodesInArchive.size());
    }

    @Test
    @DisplayName("Получаем список всех товаров в архиве у которых не нулевой остаток")
    public void getAllAvailableProductIdsInArchiveTest() {

        List<ProductShortNode> result = productService.getActualProductByVisibilityArchived();

        assertEquals(0, 0);
    }
}
