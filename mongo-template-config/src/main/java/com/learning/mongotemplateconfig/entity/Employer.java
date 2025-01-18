package com.learning.mongotemplateconfig.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "employers")
public class Employer {
    @Id
    private String id;
    private String companyName;
    private String email;
    private Profile profile;

    @Data
    public static class Profile {
        private String founder;
        @Field("established_year")
        private int establishedYear;
        private String industry;
    }
}
