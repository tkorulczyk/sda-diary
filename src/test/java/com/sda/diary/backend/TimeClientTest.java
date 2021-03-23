package com.sda.diary.backend;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class TimeClientTest {


    @Test
    void getCurrentTime_returnsCorrectTime(){
        // given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        TimeClient timeClient = new TimeClient(objectMapper);
        // when
        Instant currentTime = timeClient.getCurrentTime();

        // then
        assertNotNull(currentTime);


    }

}