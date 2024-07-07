package org.trainingamalitech.routes;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.trainingamalitech.services.SortService;

@Controller
@RequestMapping("/")
public class web {
    private final SortService sortService;
    @Autowired
    web(SortService sortService ){
        this.sortService = sortService;
    }
    @RequestMapping(value = "/sort",method = RequestMethod.POST)
    String sort(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sort_type = request.getParameter("sort_type");
        String userInput = request.getParameter("user_input").replaceAll("\\s+", ",");
        int[] unsortedArray = Arrays.stream(userInput.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] sortedArray = sortService.sort(unsortedArray,sort_type);
        session.setAttribute("sort_type", sort_type);
        session.setAttribute("sorted_array", Arrays.toString(sortedArray));
        session.setAttribute("user_input", userInput);
        session.setAttribute("timeElapsed", sortService.timeElapsed);
        session.setAttribute("timeComplexity", sortService.timeComplexity);
        session.setAttribute("spaceComplexity", sortService.spaceComplexity);
        return "index";
    }
}
