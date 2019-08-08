package md.snowtoslow.notificationservice.service;

import md.snowtoslow.notificationservice.controller.EmailRequest;
import md.snowtoslow.notificationservice.exception.UnprocessableEntity;
import md.snowtoslow.notificationservice.exception.ValidationFail;
import md.snowtoslow.notificationservice.helper.StringsHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmailValidatorService {

    private StringsHelper stringsHelper;
    private String regex_TO_FOR = "^[A-Za-z0-9+_.-]+@(.+)$";//EmailRegex for fields "TO' and "For"
    private String regex_MES_SUBJ = "^[A-Z]{1,30}$";
    public EmailValidatorService(StringsHelper stringsHelper) {
        this.stringsHelper = stringsHelper;
    }
    public void validate(EmailRequest emailRequest) {
        List<ValidationFail> fails = new ArrayList<>();

        if (stringsHelper.isNullorEmpty(emailRequest.getTo())){
            fails.add(new ValidationFail("to" , "cannot be null or empty"));
        } else if (!emailRequest.getTo().matches(regex_TO_FOR)){
            fails.add(new ValidationFail("to","NOT CORRESPONDING TO NECESSARY CONDITIONS"));
        }


        if (stringsHelper.isNullorEmpty(emailRequest.getFrom())){
            fails.add(new ValidationFail("from" , "cannot be null or empty"));
        } else if (!emailRequest.getTo().matches(regex_TO_FOR)){
            fails.add(new ValidationFail("from","NOT CORRESPONDING TO NECESSARY CONDITIONS"));}


        if (stringsHelper.isNullorEmpty(emailRequest.getSubject())){
            fails.add(new ValidationFail("subject" , "cannot be NULL or EMPTY"));
        }   else if (!emailRequest.getSubject().matches((regex_MES_SUBJ))){
            fails.add(new ValidationFail("subject", "Not corresponding to the aloud length"));
        }


        if (stringsHelper.isNullorEmpty(emailRequest.getMessage())){
            fails.add(new ValidationFail("message" , "cannot be NULL or EMPTY"));
        }   else if ((!emailRequest.getMessage().matches((regex_MES_SUBJ)))){
            fails.add(new ValidationFail("message", "Not corresponding to the aloud length"));
        }


        if (fails.size()>0){
            throw new UnprocessableEntity(fails);
        }
    }
}
