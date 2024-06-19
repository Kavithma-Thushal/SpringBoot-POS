package lk.ijse.gdse66.controller;

import lk.ijse.gdse66.dto.CustomDTO;
import lk.ijse.gdse66.dto.ItemDTO;
import lk.ijse.gdse66.service.ItemService;
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
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto) {
        service.saveItem(dto);
        return new ResponseUtil("200 OK", "saved successfully...!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto) {
        service.updateItem(dto);
        return new ResponseUtil("200 OK", "updated successfully...! : " + dto.getCode(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteItem(@RequestBody ItemDTO dto) {
        service.deleteItem(dto);
        return new ResponseUtil("200 OK", "deleted successfully...! : " + dto.getCode(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchItemCode", params = {"code"})
    public ItemDTO searchItemCode(String code) {
        return service.searchItemCode(code);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllItem")
    public ResponseUtil loadAllItem() {
        return new ResponseUtil("200 OK", "loaded successfully...! : ", service.loadAllItem());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/ItemIdGenerate")
    public @ResponseBody CustomDTO ItemIdGenerate() {
        return service.itemIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/itemCount")
    public @ResponseBody CustomDTO getSumItem() {
        return service.getSumItem();
    }
}