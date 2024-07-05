package org.trainingamalitech.routes;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.trainingamalitech.services.SortService;

@Controller
@RequestMapping("/")
public class web {
    private SortService sortService = new SortService();

    @RequestMapping(value = "sort",method = RequestMethod.POST)
    String sort(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        String sort_type = request.getParameter("sort_type");
        String userInput = request.getParameter("user_input").replaceAll("\\s+", ",");
        int[] unsortedArray = Arrays.stream(userInput.split(",")).mapToInt(Integer::parseInt).toArray();
        int [] sortedArray;
        switch (sort_type) {
            case "heap":
            sortedArray = sortService.heapSort(unsortedArray);                
                break;
            case "merge":
            sortedArray = sortService.mergeSort(unsortedArray);
                break;
            case "quick":
            sortedArray = sortService.quickSort(unsortedArray);
                break;
            case "radix":
            sortedArray = sortService.radixSort(unsortedArray);
                break;        
            default:
            sortedArray = sortService.quickSort(unsortedArray);
                break;
        }
        session.setAttribute("sort_type", sort_type);
        session.setAttribute("sorted_array", Arrays.toString(sortedArray));
        session.setAttribute("user_input", userInput);
        return "index";
    }
}
