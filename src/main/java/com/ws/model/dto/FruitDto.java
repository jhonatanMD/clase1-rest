package com.ws.model.dto;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FruitDto {

    private Integer id;
    private String name;
    private String description;

}
