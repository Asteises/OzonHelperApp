package ru.asteises.ozonhelperapp.common.json.model.info;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import ru.asteises.ozonhelperapp.common.json.model.price.PriceIndexesNodeRestResponse;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InfoResultRestResponse {

    /**
     * Идентификатор товара product_id.
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * Название.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Идентификатор товара в системе продавца — артикул.
     */
    @JsonProperty("offer_id")
    private String offerId;

    /**
     * Значение true, если товар архивирован вручную.
     */
    @JsonProperty("is_archived")
    private Boolean archived;

    /**
     * Значение true, если товар архивирован автоматически.
     */
    @JsonProperty("is_autoarchived")
    private Boolean autoArchived;

    /**
     * Штрихкод.
     */
    @JsonProperty("barcode")
    private String barcode;

    /**
     * Все штрихкоды товара.
     */
    @JsonProperty("barcodes")
    private List<String> barcodes;

    @JsonSetter("barcodes")
    public void setBarcodes(List<String> barcodes) {
        if(barcodes != null) {
            this.barcodes = new ArrayList<>(barcodes);
        }
    }

    @JsonGetter("barcodes")
    public List<String> getBarcodes() {
        return Objects.requireNonNullElseGet(barcodes, ArrayList::new);
    }

    /**
     * Цена главного предложения на Ozon.
     * Устаревший параметр, больше не используется. Всегда возвращает пустую строку
     */
    @Deprecated
    @JsonProperty("buybox_price")
    private String buyboxPrice;

    /**
     * Идентификатор категории. Используйте его с методами:
     * <br>
     * /v1/description-category/tree,
     * <br>
     * /v1/description-category/attribute,
     * <br>
     * /v1/description-category/attribute/values.
     * <br>
     * Параметр будет отключён, когда отключат методы, указанные выше.
     */
    @Deprecated
    @JsonProperty("category_id")
    private Integer categoryId;

    /**
     * Идентификатор типа товара.
     */
    @JsonProperty("type_id")
    private Integer typeId;

    /**
     * Дата и время создания товара.
     */
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;

    /**
     * Массив ссылок на изображения. Изображения в массиве расположены в порядке их расположения на сайте.
     * Если параметр primary_image не указан, первое изображение в массиве главное для товара.
     */
    @JsonProperty("images")
    private List<String> images = new ArrayList<>();

    @JsonSetter("images")
    public void setImages(List<String> images) {
        if(images != null) {
            this.images = new ArrayList<>(images);
        }
    }

    @JsonGetter("images")
    public List<String> getImages() {
        return Objects.requireNonNullElseGet(images, ArrayList::new);
    }

    /**
     * Признак, что у товара есть уценённые аналоги на складе Ozon.
     */
    @JsonProperty("has_discounted_item")
    private Boolean hasDiscountedItem;


    /**
     * Признак, является ли товар уценённым:
     * <br>
     * Если товар создавался продавцом как уценённый — true.
     * <br>
     * Если товар не уценённый или был уценён Ozon — false.
     */
    @JsonProperty("is_discounted")
    private Boolean discounted;

    /**
     * Остатки уценённого товара на складе Ozon.
     */
    @JsonProperty("discounted_stocks")
    private InfoStocksNode discountedStocks;

    /**
     * Валюта ваших цен. Совпадает с валютой, которая установлена в настройках личного кабинета.
     * <br>
     * Возможные значения:
     * <br>
     *     RUB — российский рубль,
     *     <br>
     *     BYN — белорусский рубль,
     *     <br>
     *     KZT — тенге,
     *     <br>
     *     EUR — евро,
     *     <br>
     *     USD — доллар США,
     *     <br>
     *     CNY — юань.
     */
    @JsonProperty("currency_code")
    private String currencyCode;

    /**
     * Идентификатор категории. Используйте его с методами:
     * <br>
     * /v1/description-category/attribute
     * <br>
     * /v1/description-category/attribute/values.
     */
    @JsonProperty("description_category_id")
    private Integer descriptionCategoryId;

    /**
     * Цена на товар с учетом всех акций. Это значение будет указано на витрине Ozon.
     */
    @JsonProperty("marketing_price")
    private String marketingPrice;

    /**
     * Минимальная цена товара после применения акций.
     * <br>
     * Уточняйте минимальную цену товара после применения всех акций в личном кабинете.
     * Параметр min_price из ответа метода на доработке и возвращает 0.
     */
    @JsonProperty("min_price")
    private String minPrice;

    /**
     * Цена до учёта скидок. На карточке товара отображается зачёркнутой.
     */
    @JsonProperty("old_price")
    private String oldPrice;

    /**
     * Цена товара с учётом скидок — это значение показывается на карточке товара.
     */
    @JsonProperty("price")
    private String price;

    /**
     * Информация об источниках схожих предложений. Подробнее: <a href="https://seller-edu.ozon.ru/docs/prices/market-prices.html#%D0%B5%D1%81%D0%BB%D0%B8-%D1%80%D1%8B%D0%BD%D0%BE%D1%87%D0%BD%D0%B0%D1%8F-%D1%86%D0%B5%D0%BD%D0%B0-%D0%BD%D0%B0-%D0%BA%D0%BE%D0%BC%D0%BF%D0%BB%D0%B5%D0%BA%D1%82-%D0%BE%D1%82%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B0%D0%B5%D1%82%D1%81%D1%8F-%D0%BD%D0%B5%D0%B2%D0%B5%D1%80%D0%BD%D0%BE"> ссылка </a>.
     */
    @JsonProperty("sources")
    private List<InfoSourcesNode> sources;

    @JsonSetter("sources")
    public void setSources(List<InfoSourcesNode> sources) {
        if (sources != null) {
            this.sources = new ArrayList<>(sources);
        }
    }

    @JsonProperty("sources")
    public List<InfoSourcesNode> getSources() {
        return Objects.requireNonNullElseGet(sources, ArrayList::new);
    }

    /**
     * Информация об остатках товара.
     */
    @JsonProperty("stocks")
    private InfoStocksNode stocks;

    //FIXME - Уточнить, какой объект должен туту быть.
    @JsonIgnore
    private List<String> errors;

    @JsonSetter("errors")
    public void setErrors(List<String> errors) {
        if (errors != null) {
            this.errors = new ArrayList<>(errors);
        }
    }

    @JsonGetter("errors")
    public List<String> getErrors() {
        return Objects.requireNonNullElseGet(errors, ArrayList::new);
    }

    /**
     * Дата последнего обновления товара.
     */
    @JsonProperty("updated_at")
    private ZonedDateTime updatedAt;

    /**
     * Ставка НДС для товара.
     */
    @JsonProperty("vat")
    private String vat;

    /**
     * Если товар выставлен на продажу — true.
     */
    @JsonProperty("visible")
    private Boolean visible;

    /**
     * Настройки видимости товара.
     */
    @JsonProperty("visibility_details")
    private InfoVisibilityDetailsNode visibilityDetails;

    /**
     * Ценовые индексы товара.
     * <br>
     * Подробнее: <a href="https://seller-edu.ozon.ru/ceny-i-akcii/rabota-s-cenami/price-index"> ссылка </a>.
     */
    @JsonProperty("price_indexes")
    private PriceIndexesNodeRestResponse priceIndexes;

    /**
     * Информация о комиссиях.
     */
    @JsonProperty("commissions")
    private List<InfoCommissionNode> commissions;

    /**
     * Объёмный вес товара.
     */
    @JsonProperty("volume_weight")
    private Double volumeWeight;

    /**
     * Флаг обязательной предоплаты для товара: true — чтобы купить товар, нужно внести предоплату.
     * <br>
     * false — предоплата необязательна.
     */
    @JsonProperty("is_prepayment")
    private Boolean prepayment;

    /**
     * Если возможна предоплата — true.
     */
    @JsonProperty("is_prepayment_allowed")
    private Boolean prepaymentAllowed;

    /**
     * Массив изображений 360.
     */
    @JsonProperty("images360")
    private List<String> images360;

    @JsonSetter("images360")
    public void setImages360(List<String> images360) {
        if (images360 != null) {
            this.images360 = new ArrayList<>(images360);
        }
    }

    @JsonGetter("images360")
    public List<String> getImages360() {
        return Objects.requireNonNullElseGet(images360, ArrayList::new);
    }

    /**
     * Признак крупногабаритного товара.
     */
    @JsonProperty("is_kgt")
    private Boolean isKgt;

    /**
     * Маркетинговый цвет.
     */
    @JsonProperty("color_image")
    private String colorImage;

    /**
     * Главное изображение товара.
     */
    @JsonProperty("primary_image")
    private String primaryImage;

    /**
     * Описание состояния товара.
     */
    @JsonProperty("status")
    private InfoStatusNode status;
}
