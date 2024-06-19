package lk.ijse.gdse66.repo;

import lk.ijse.gdse66.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : Kavithma Thushal
 * @project : Spring-POS
 **/
public interface CustomerRepo extends JpaRepository<Customer, String> {
    @Query(value = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(id) FROM Customer", nativeQuery = true)
    int getSumCustomer();
}