package ru.asteises.ozonhelperapp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class OzonHelperAppApplicationTests {

    @Test
    void contextLoads() {

        double costPrice = 4000; // Себестоимость товара
        double profitPercentage = 30; // Желаемый процент прибыли

        // Фиксированные значения
        double deliveryCost = 1000;
        double marketplaceCommissionRate = 0.18;
        double acquiringRate = 0.03;
        double taxRate = 0.07;

        double totalCost = costPrice + deliveryCost + (profitPercentage / 100 * costPrice);
        double totalCommissionRate = marketplaceCommissionRate + acquiringRate + taxRate;

        // Расчет цены продажи
        double sellingPrice = totalCost / (1 - totalCommissionRate);

        // Расчет прибыли
        double totalCommission = (marketplaceCommissionRate + acquiringRate + taxRate) * sellingPrice;
        double profit = sellingPrice - (costPrice + deliveryCost + totalCommission);

        log.info("sellingPrice: {}", sellingPrice);
        log.info("profit: {}", profit);
    }

}
