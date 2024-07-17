package org.trainingamalitech.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.trainingamalitech.services.SortService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class WebController {

    private final SortService sortService;

    @Autowired
    public WebController(SortService sortService) {
        this.sortService = sortService;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ModelAndView sort(@RequestParam("user_input") String userInput,
                             @RequestParam("sort_type") String sortType,
                             HttpServletRequest request) {

        // Clean and prepare input
        userInput = userInput.replaceAll("\\s+", ",");
        int[] unsortedArray = Arrays.stream(userInput.split(",")).mapToInt(Integer::parseInt).toArray();

        // Perform sorting and measure time
        long startTime = System.nanoTime();
        int[] sortedArray = sortService.sort(unsortedArray, sortType);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        // Retrieve session
        HttpSession session = request.getSession();

        // Store data in session attributes
        session.setAttribute("sort_type", sortType);
        session.setAttribute("user_input", userInput);
        session.setAttribute("sorted_array", Arrays.toString(sortedArray));
        session.setAttribute("time_elapsed", timeElapsed);
        session.setAttribute("time_complexity", sortService.getTimeComplexity());
        session.setAttribute("space_complexity", sortService.getSpaceComplexity());

        // Return view name to render (e.g., "index.jsp" or "index.html")
        return new ModelAndView("index");
    }
}
