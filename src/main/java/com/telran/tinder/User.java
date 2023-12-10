package com.telran.tinder;

import lombok.*;

@AllArgsConstructor
@Data
public class User {

    private final long id;

    private String name;

    private int rating;

    private String description;

}
