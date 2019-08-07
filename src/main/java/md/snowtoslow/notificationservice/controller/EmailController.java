package md.snowtoslow.notificationservice.controller;

import md.snowtoslow.notificationservice.service.EmailService;
import org.springframework.web.bind.annotation.*;



@RequestMapping("email")
@RestController
public class EmailController{
    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public String sendEmail(@RequestBody EmailRequest emailRequest ){
        return  emailService.register(emailRequest).getId();
    }

    @GetMapping("{id}")
    public EmailRequest getById(@PathVariable String id){
        return emailService.getById(id);
    }


}
