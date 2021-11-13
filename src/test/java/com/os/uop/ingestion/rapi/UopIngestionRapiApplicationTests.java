package com.os.uop.ingestion.rapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class UopIngestionRapiApplicationTests {

    @Test
    void contextLoads() {
        List<String> strings = List.of("String", "String1", "String2");

        Assertions.assertNotNull(strings);
    }

}
