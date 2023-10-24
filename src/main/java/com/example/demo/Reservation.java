package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("reservation")
public class Reservation {
    @Id
    public String id;
    public String guestName;
    public Date checkInDate;
    public Date checkOutDate;
    public int roomNumber;
}
