package com.spring.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ItemController {
    private Item item_1= new Item("Item 1", 500);
    private Item item_2 = new Item("Item 2", 300);

    public List<Item> getItems(){
        LinkedList list = new LinkedList();
        list.add(item_1);
        list.add(item_2);
        return list;
    }


    @GetMapping("/items")
    public String getAllItems() throws JsonProcessingException{


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(getItems());
        return json;
    }

    @GetMapping("/items/{id}")
    public String getItemWithId(@PathVariable String id) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        String json;
        if(id.equals("1")){
            json = mapper.writeValueAsString(item_1);
        }else if(id.equals("2")){
            json = mapper.writeValueAsString(item_2);
        }else{
            json = "";
        }

        return json;
    }


}
