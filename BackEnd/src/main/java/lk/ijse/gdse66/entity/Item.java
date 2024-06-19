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
public class Item {
    @Id
    String code;
    String description;
    int qty;
    double unitPrice;
}