package org.trainingamalitech.routes;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trainingamalitech.models.HelloWorld;

import java.time.LocalDateTime;
@RestController
@RequestMapping("/api")
public class api {
        @RequestMapping("/helloworld")
        public String handler(Model model) {

            HelloWorld helloWorld = new HelloWorld();
            helloWorld.setMessage("Hello World Example Using Spring MVC !!!");
            helloWorld.setDateTime(LocalDateTime.now().toString());
            model.addAttribute("helloWorld", helloWorld);
            return "helloworld";
        }

}
