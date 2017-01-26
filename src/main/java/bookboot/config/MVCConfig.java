/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookboot.config;


import java.io.File;
import static java.lang.System.console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author FP51User
 */



@Configuration

public class MVCConfig extends WebMvcConfigurerAdapter{
    
    @Value("${qr.folder}")
    private String folder;
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        
        
        String location;
        String currentPath = new File(".").getAbsolutePath();
        
        location = "file:///" + currentPath.substring(0, currentPath.length()-1).replace("\\", "/");
        
        
        
        System.out.print("AAAAAAAAAAAAAAAAAAAAAAAAAA"+location);
        
        //registry.addResourceHandler("/qr/**").addResourceLocations(folder);
        registry.addResourceHandler("/qr/**").addResourceLocations(location);
        
        super.addResourceHandlers(registry);
    }
}
