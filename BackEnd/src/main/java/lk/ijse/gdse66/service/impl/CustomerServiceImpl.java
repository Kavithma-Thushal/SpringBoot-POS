package lk.ijse.gdse66.service.impl;

import lk.ijse.gdse66.dto.CustomDTO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.entity.Customer;
import lk.ijse.gdse66.repo.CustomerRepo;
import lk.ijse.gdse66.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Not Exist. Please enter Valid id..!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        repo.delete(mapper.map(dto, Customer.class));
    }

    @Override
    public CustomerDTO searchCusId(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        return mapper.map(repo.findById(id).get(), CustomerDTO.class);
    }

    @Override
    public ArrayList<CustomerDTO> loadAllCustomer() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Customer>>() {
        }.getType());
    }

    @Override
    public CustomDTO customerIdGenerate() {
        return new CustomDTO(repo.getLastIndex());
    }

    @Override
    public CustomDTO getSumCustomer() {
        return new CustomDTO(repo.getSumCustomer());
    }
}