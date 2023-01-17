package com.ren.boot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-16 19:31
 * @description:
 **/
@ToString
@NoArgsConstructor
@Data
public class Pet {

    private String name;
    private Double weight;

}
