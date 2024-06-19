package lk.ijse.gdse66.service;

import lk.ijse.gdse66.dto.CustomDTO;
import lk.ijse.gdse66.dto.OrderDetailsDTO;
import lk.ijse.gdse66.dto.OrdersDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author : Kavithma Thushal
 * @project : Spring-POS
 **/
public interface PlaceOrderService {
    void placeOrder(@RequestBody OrdersDTO dto);

    ArrayList<OrdersDTO> LoadOrders();

    ArrayList<OrderDetailsDTO> LoadOrderDetails();

    @ResponseBody
    CustomDTO OrderIdGenerate();

    @ResponseBody
    CustomDTO getSumOrders();
}