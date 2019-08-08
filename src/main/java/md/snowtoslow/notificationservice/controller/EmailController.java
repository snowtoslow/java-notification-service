package md.snowtoslow.notificationservice.controller;

import md.snowtoslow.notificationservice.repository.EmailRepository;
import md.snowtoslow.notificationservice.service.EmailService;
import md.snowtoslow.notificationservice.service.EmailValidatorService;
import org.springframework.web.bind.annotation.*;


@RequestMapping("email")
@RestController
public class EmailController{
    private EmailService emailService;
    private EmailRepository emailRepository;
    private EmailValidatorService emailValidatorService;


    public EmailController(EmailService emailService, EmailRepository emailRepository, EmailValidatorService emailValidatorService) {
        this.emailService = emailService;
        this.emailRepository = emailRepository;
        this.emailValidatorService = emailValidatorService;
    }

    @PostMapping
    public String sendEmail(@RequestBody EmailRequest emailRequest ){
        emailValidatorService.validate(emailRequest);
        return  emailService.register(emailRequest).getId();
    }

    @GetMapping("{id}")
    public EmailRequest getById(@PathVariable String id){
        return emailRepository.getById(id);
    }
        




}
