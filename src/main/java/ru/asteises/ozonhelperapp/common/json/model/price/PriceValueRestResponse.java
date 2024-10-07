package ru.asteises.ozonhelperapp.common.json.model.price;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import ru.asteises.ozonhelperapp.common.json.model.response.OzonValueRestResponse;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PriceValueRestResponse implements OzonValueRestResponse<ProductResultRestResponse> {

    private ProductResultRestResponse result;

    @Override
    public ProductResultRestResponse getResult() {
        return result;
    }

    @Override
    public void setResult(ProductResultRestResponse result) {
        this.result = result;
    }
}
