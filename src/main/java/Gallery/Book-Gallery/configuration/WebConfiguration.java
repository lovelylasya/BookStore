package Gallery.Book-Gallery.configuration;

import org.h2.server.web.WebServlet;
import org.Book-Gallery.boot.web.servlet.ServletRegistrationBean;
import org.Book-Gallery.context.annotation.Bean;
import org.Book-Gallery.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
