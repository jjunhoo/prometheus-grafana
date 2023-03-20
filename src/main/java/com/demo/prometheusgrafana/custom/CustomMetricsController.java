package com.demo.prometheusgrafana.custom;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;

@RestController
public class CustomMetricsController {

    @GetMapping("/counter")
    public String counter() {
        List<Tag> tags = List.of(Tag.of("custom_label_a", "A"), Tag.of("custom_label_b", "B"));
        Metrics.counter("custom.count.label", tags).increment();

        return "custom-metrics";
    }
}
