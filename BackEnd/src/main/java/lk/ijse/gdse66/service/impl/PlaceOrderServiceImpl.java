package lk.ijse.gdse66.service.impl;

import lk.ijse.gdse66.dto.CustomDTO;
import lk.ijse.gdse66.dto.OrderDetailsDTO;
import lk.ijse.gdse66.dto.OrdersDTO;
import lk.ijse.gdse66.entity.Item;
import lk.ijse.gdse66.entity.OrderDetails;
import lk.ijse.gdse66.entity.Orders;
import lk.ijse.gdse66.repo.ItemRepo;
import lk.ijse.gdse66.repo.OrderDetailsRepo;
import lk.ijse.gdse66.repo.PlaceOrderRepo;
import lk.ijse.gdse66.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author : Kavithma Thushal
 * @project : Spring-POS
 **/
@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {
    @Autowired
    private PlaceOrderRepo repo;

    @Autowired
    private OrderDetailsRepo orRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void placeOrder(OrdersDTO dto) {
        Orders ord = mapper.map(dto, Orders.class);
        if (repo.existsById(ord.getOid())) {
            throw new RuntimeException("Order" + ord.getOid() + " Already added.!");
        }
        repo.save(ord);

        //Update Item Qty
        for (OrderDetails od : ord.getOrderDetails()) {
            Item item = itemRepo.findById(od.getItemCode()).get();
            item.setQty(item.getQty() - od.getQty());
            itemRepo.save(item);
        }
    }

    @Override
    public ArrayList<OrdersDTO> LoadOrders() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<OrdersDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<OrderDetailsDTO> LoadOrderDetails() {
        return mapper.map(orRepo.findAll(), new TypeToken<ArrayList<OrderDetailsDTO>>() {
        }.getType());
    }

    @Override
    public CustomDTO OrderIdGenerate() {
        return new CustomDTO(repo.getLastIndex());
    }

    @Override
    public CustomDTO getSumOrders() {
        return new CustomDTO(repo.getSumOrders());
    }
}