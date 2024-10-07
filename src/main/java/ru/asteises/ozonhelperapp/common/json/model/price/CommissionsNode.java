package ru.asteises.ozonhelperapp.common.json.model.price;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Информация о комиссиях.
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CommissionsNode {

    /**
     * Наибольший процент комиссии за продажу среди FBO и FBS.
     */
    @JsonProperty("sales_percent")
    private double salesPercent;

    /**
     * Процент комиссии за продажу (FBO).
     */
    @JsonProperty("sales_percent_fbo")
    private double salesPercentFbo;

    /**
     * Процент комиссии за продажу (FBS).
     */
    @JsonProperty("sales_percent_fbs")
    private double salesPercentFbs;

    /**
     * Комиссия за сборку заказа (FBO).
     */
    @JsonProperty("fbo_fulfillment_amount")
    private double fboFulfillmentAmount;

    /**
     * Магистраль от (FBO).
     */
    @JsonProperty("fbo_direct_flow_trans_min_amount")
    private double fboDirectFlowTransMinAmount;

    /**
     * Магистраль от (FBO).
     */
    @JsonProperty("fbo_direct_flow_trans_max_amount")
    private double fboDirectFlowTransMaxAmount;

    /**
     * Последняя миля (FBO).
     */
    @JsonProperty("fbo_deliv_to_customer_amount")
    private double fboDeliveryToCustomerAmount;

    /**
     * Комиссия за возврат и отмену (FBO).
     */
    @JsonProperty("fbo_return_flow_amount")
    private double fboReturnFlowAmount;

    /**
     * Комиссия за обратную логистику от (FBO).
     */
    @JsonProperty("fbo_return_flow_trans_min_amount")
    private double fboReturnFlowTransMinAmount;

    /**
     * Комиссия за обратную логистику до (FBO).
     */
    @JsonProperty("fbo_return_flow_trans_max_amount")
    private double fboReturnFlowTransMaxAmount;

    /**
     * Минимальная комиссия за обработку отправления (FBS)
     */
    @JsonProperty("fbs_first_mile_min_amount")
    private double fbsFirstMileMinAmount;

    /**
     * Максимальная комиссия за обработку отправления (FBS)
     * <br>
     * Подробнее: <a href="https://seller-edu.ozon.ru/commissions-tariffs/commissions-tariffs-ozon/rashody-na-dop-uslugi#%D0%B2%D1%8B%D0%B5%D0%B7%D0%B4-%D1%82%D1%80%D0%B0%D0%BD%D1%81%D0%BF%D0%BE%D1%80%D1%82%D0%BD%D0%BE%D0%B3%D0%BE-%D1%81%D1%80%D0%B5%D0%B4%D1%81%D1%82%D0%B2%D0%B0-%D0%BF%D0%BE-%D0%B0%D0%B4%D1%80%D0%B5%D1%81%D1%83-%D0%BF%D1%80%D0%BE%D0%B4%D0%B0%D0%B2%D1%86%D0%B0-%D0%B4%D0%BB%D1%8F-%D0%B7%D0%B0%D0%B1%D0%BE%D1%80%D0%B0-%D0%BE%D1%82%D0%BF%D1%80%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B8-(pick-up)">ссылка</a>
     */
    @JsonProperty("fbs_first_mile_max_amount")
    private double fbsFirstMileMaxAmount;

    /**
     * Магистраль от (FBS).
     */
    @JsonProperty("fbs_direct_flow_trans_min_amount")
    private double fbsDirectFlowTransMinAmount;

    /**
     * Магистраль от (FBS).
     */
    @JsonProperty("fbs_direct_flow_trans_max_amount")
    private double fbsDirectFlowTransMaxAmount;

    /**
     * Последняя миля (FBS).
     */
    @JsonProperty("fbs_deliv_to_customer_amount")
    private double fbsDeliveryToCustomerAmount;

    /**
     * Комиссия за возврат и отмену, обработка отправления (FBS).
     */
    @JsonProperty("fbs_return_flow_amount")
    private double fbsReturnFlowAmount;

    /**
     * Комиссия за возврат и отмену, магистраль от (FBS).
     */
    @JsonProperty("fbs_return_flow_trans_min_amount")
    private double fbsReturnFlowTransMinAmount;

    /**
     * Комиссия за возврат и отмену, магистраль до (FBS).
     */
    @JsonProperty("fbs_return_flow_trans_max_amount")
    private double fbsReturnFlowTransMaxAmount;
}
