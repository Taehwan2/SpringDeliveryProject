package org.delivery.api.config.objecmapper;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){
        var objectMapper = new ObjectMapper();

        objectMapper.registerModule(new Jdk8Module());  // 8 버전 이후 클래스

        objectMapper.registerModule(new JavaTimeModule()); // << localdate

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 모르는 json filed를 대해서는 무시한다.


        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false); //비어있는거 생성할 때

        //날짜 직렬화
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

        return objectMapper;
    }
}
