package org.trainingamalitech.routes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class web {
    @RequestMapping("/home")
    String home() {
        return "index";
    }

    @RequestMapping(value = "sort",method = RequestMethod.POST)
    String sort(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String input = request.getParameter("array");
        String sort_type = request.getParameter("sort_type");
        session.setAttribute("sort_type", sort_type);
        return "index";
    }
}
