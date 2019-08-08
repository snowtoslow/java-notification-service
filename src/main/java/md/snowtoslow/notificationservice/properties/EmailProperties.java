package md.snowtoslow.notificationservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;
@Component
@ConfigurationProperties("mail.smtp")
public class EmailProperties {

    private boolean auth;
    private boolean starttlsEnable;
    private String host;
    private String port;
    private String sslTrust;


    public Properties toProperties(){

        Properties prop = new Properties();

        //prop.put("mail.smtp.auth", this.auth);
        //prop.put("mail.smtp.starttls.enable",this.starTlsEnable);
        prop.put("mail.smtp.host", this.host);
        prop.put("mail.smtp.port", this.port);
        //prop.put("mail.smtp.ssl.trust", this.sslTrust);

        return prop;


    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public void setStartTlsEnable(boolean startTlsEnable) {
        this.starttlsEnable = startTlsEnable;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setSslTrust(String sslTrust) {
        this.sslTrust = sslTrust;
    }
}
