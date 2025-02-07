package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wildcard")
public class WildCardMappingController {

    @GetMapping(path = "test1/*/hello")   //* mark ena thananta ona wachanayak puluwan , spacuth puluwan , anthimata hello thiyanne ona
    public String test1(){
        return "get Mapping 1 invoked";
    }

    @GetMapping(path = "test2/*/*")  //
    public String test2(){
        return "get Mapping 2 invoked";
    }

}
