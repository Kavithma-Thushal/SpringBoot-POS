package lk.ijse.gdse66.service;

import lk.ijse.gdse66.dto.CustomDTO;
import lk.ijse.gdse66.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author : Kavithma Thushal
 * @project : Spring-POS
 **/
public interface CustomerService {
    void saveCustomer(@ModelAttribute CustomerDTO dto);

    void updateCustomer(@RequestBody CustomerDTO dto);

    void deleteCustomer(@RequestBody CustomerDTO dto);

    CustomerDTO searchCusId(String id);

    ArrayList<CustomerDTO> loadAllCustomer();

    @ResponseBody
    CustomDTO customerIdGenerate();

    @ResponseBody
    CustomDTO getSumCustomer();
}