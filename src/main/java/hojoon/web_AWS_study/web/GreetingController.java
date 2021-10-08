package hojoon.web_AWS_study.web;

import hojoon.web_AWS_study.web.dto.GreetingResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(){
        return "greeting";
    }

    @GetMapping("/greeting/dto")
    public GreetingResponseDto greetingResponseDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new GreetingResponseDto(name, amount);
    }

}