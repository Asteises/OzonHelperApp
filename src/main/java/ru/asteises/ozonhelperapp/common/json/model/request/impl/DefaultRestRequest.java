package ru.asteises.ozonhelperapp.common.json.model.request.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.asteises.ozonhelperapp.common.json.model.request.OzonRestRequest;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DefaultRestRequest implements OzonRestRequest<DefaultFilterRestRequest> {

    private DefaultFilterRestRequest filter;

    @JsonProperty("last_id")
    private String lastId;

    private Integer limit;

    @Override
    public DefaultFilterRestRequest getFilter() {
        return filter;
    }

    @Override
    public void setFilter(DefaultFilterRestRequest filter) {
        this.filter = filter;
    }

    @Override
    public String getLastId() {
        return lastId;
    }

    @Override
    public void setLastId(String lastId) {
        this.lastId = lastId;
    }

    @Override
    public Integer getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
