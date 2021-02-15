package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
    /*
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }
*/

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, String language) {
        return language + name + "!";
    }



    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }






    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" +   // submit a request to /hello
                "<input type='text' name='name'>" +
                "<select action='/hello' name='languages' id='language-select'>" +
                "<option value='English'>English</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Bonjour'>French</option>" +
                "<option value='Hallo'>German</option>" +
                "<option value='Privet'>Russian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
