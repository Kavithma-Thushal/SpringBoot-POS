package lk.ijse.gdse66.repo;

import lk.ijse.gdse66.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Kavithma Thushal
 * @project : Spring-POS
 **/
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, String> {
}