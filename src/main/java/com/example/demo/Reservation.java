package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("reservation")
public class Reservation {
    @Id
    public String id;
    public String guestEmail;
    public String guestName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date checkInDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date checkOutDate;
    public String roomNumber;
}
