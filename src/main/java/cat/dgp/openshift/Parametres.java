package cat.dgp.openshift;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Parametres {
 
    @Value("${spring.datasource.url}")
    private String urlbbdd;
 
    public String getUrl() {
        return urlbbdd;
    }
 
    public void setUrl(String urlbbdd) {
        this.urlbbdd = urlbbdd;
    }
}
