package lk.ijse.gdse66.controller;

import lk.ijse.gdse66.dto.CustomDTO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto) {
        service.saveCustomer(dto);
        return new ResponseUtil("200 OK", "saved successfully...!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        service.updateCustomer(dto);
        return new ResponseUtil("200 OK", "updated successfully...! : " + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestBody CustomerDTO dto) {
        service.deleteCustomer(dto);
        return new ResponseUtil("200 OK", "deleted successfully...! : " + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCusId", params = {"id"})
    public CustomerDTO searchCusId(String id) {
        return service.searchCusId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllCustomer")
    public ResponseUtil loadAllCustomer() {
        return new ResponseUtil("200 OK", "loaded successfully...! : ", service.loadAllCustomer());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/CustomerIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        return service.customerIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/CustomerCount")
    public @ResponseBody CustomDTO getSumCustomer() {
        return service.getSumCustomer();
    }
}