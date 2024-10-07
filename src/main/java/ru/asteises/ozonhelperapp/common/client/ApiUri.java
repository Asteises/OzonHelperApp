package ru.asteises.ozonhelperapp.common.client;

public interface ApiUri {

    String VERSION_2 = "/v2";
    String VERSION_3 = "/v3";
    String VERSION_4 = "/v4";
    String PRODUCT_LIST = "/product/list";
    String PRODUCT_INFO = "/product/info";
    String PRODUCT_INFO_LIST = "/product/info/list";
    String PRODUCT_INFO_STOCKS = "/product/info/stocks";
    String PRODUCT_INFO_PRICES = "/product/info/prices";


    static String getUri(String version, String mainUri) {
        StringBuilder uri = new StringBuilder(version);
        uri.append(mainUri);
        return uri.toString();
    }
}
