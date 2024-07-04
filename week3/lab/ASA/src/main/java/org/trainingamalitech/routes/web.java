package org.trainingamalitech.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class web {
    @RequestMapping("/home")
 String home(){
     return "helloworld";
 }
}
