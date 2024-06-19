package lk.ijse.gdse66.controller;

import lk.ijse.gdse66.dto.CustomDTO;
import lk.ijse.gdse66.dto.OrdersDTO;
import lk.ijse.gdse66.service.PlaceOrderService;
import lk.ijse.gdse66.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kavithma Thushal
 * @project : Spring-POS
 **/
@RestController
@CrossOrigin
@RequestMapping("/orders")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil placeOrder(@RequestBody OrdersDTO dto) {
        service.placeOrder(dto);
        return new ResponseUtil("200 OK", "purchased successfully...!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/LoadOrders")
    public ResponseUtil LoadOrders() {
        return new ResponseUtil("200 OK", "loaded successfully...! : ", service.LoadOrders());
    }


    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/LoadOrderDetails")
    public ResponseUtil LoadOrderDetails() {
        return new ResponseUtil("200 OK", "loaded successfully...! : ", service.LoadOrderDetails());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/OrderIdGenerate")
    public @ResponseBody CustomDTO OrderIdGenerate() {
        return service.OrderIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/ordersCount")
    public @ResponseBody CustomDTO getSumOrders() {
        return service.getSumOrders();
    }
}