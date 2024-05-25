package com.latencia.latencia.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;
@Document(value="cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Cliente {
    @Id
    private String  id;
    private String name;
    private String email;
    private String phoneNumber;

    
}
