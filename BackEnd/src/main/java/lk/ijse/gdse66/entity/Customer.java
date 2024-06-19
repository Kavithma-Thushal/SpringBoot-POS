package lk.ijse.gdse66.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Kavithma Thushal
 * @project : Spring-POS
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
}