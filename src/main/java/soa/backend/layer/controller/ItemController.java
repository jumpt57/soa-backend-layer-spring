package soa.backend.layer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@RequestMapping("/item")
    String home() {
        return "Hello World! Item";
    }

}
