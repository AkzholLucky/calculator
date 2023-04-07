package akzhol.keiken.calcualtor.controllers;

import akzhol.keiken.calcualtor.services.MailSenderService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/keiken")
public class MainController {

    private final MailSenderService mailSenderService;

    public MainController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @GetMapping("/calculator")
    public String text(){
        return "Hello world!";
    }

    @PostMapping("/calculator")
    public Map<String, String> calculatePrice(@RequestBody String name, String number){
//        float chronoTime, int pastime, String type

//        int totalPrice = 0;
//
//        //chronoTime
//        if (chronoTime <= 1){
//            totalPrice = 20000;
//        } else if (chronoTime > 1 && chronoTime <= 3){
//            totalPrice = 30000;
//        } else if (chronoTime > 3 && chronoTime <= 5) {
//            totalPrice = 40000;
//        } else if (chronoTime > 5 && chronoTime <= 10) {
//            totalPrice = 50000;
//        } else if (chronoTime > 10) {
//            totalPrice = 60000;
//        }
//
//        //pastime
//        if (pastime > 14){
//            totalPrice = totalPrice + 20000;
//        } else if (pastime > 10 && pastime <= 14){
//            totalPrice = totalPrice + 30000;
//        } else if (pastime > 5 && pastime <= 10) {
//            totalPrice = totalPrice + 40000;
//        } else if (pastime > 3 && pastime <= 5) {
//            totalPrice = totalPrice + 50000;
//        } else if (pastime < 3) {
//            totalPrice = totalPrice + 60000;
//        }
//
//        //type
//        switch (type){
//            case "ad":
//                totalPrice = totalPrice + 10000;
//                break;
//            case "reels":
//                totalPrice = totalPrice + 5000;
//                break;
//            case "clip":
//                totalPrice = totalPrice + 15000;
//                break;
//            case "tutorial":
//                totalPrice = totalPrice + 10000;
//                break;
//            case "youtube":
//                totalPrice = totalPrice + 10000;
//                break;
//            default:
//                totalPrice = totalPrice + 15000;
//                break;
//        }

        String message = String.format(
                "New order!\n" + "Name: %s\n " + "Number: %s",
                name,
                number
        );

        mailSenderService.send("slamjanovakjol@gmail.com", "New order", message);

        return Map.of("Message", "Success!");
    }
}
