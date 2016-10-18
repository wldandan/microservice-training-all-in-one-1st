package com.microservice.training.hal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HALResponse extends ResourceSupport {
    public HALResponse() {
        this.embedded = new HashMap<>();
    }

    @JsonProperty("_embedded")
    private Map<String, Object> embedded;

    public void add(String name, Object embedded) {

        this.embedded.put(name, embedded);
    }

    public Map<String, Object> getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Map<String, Object> embedded) {
        this.embedded = embedded;
    }
}
