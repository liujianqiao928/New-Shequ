package xyz.liujianqiao.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class Webconfig extends WebMvcConfigurerAdapter  {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//映射图片保存地址
        registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\n\\community\\src\\main\\resources\\static\\images\\");
    }

}
