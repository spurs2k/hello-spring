package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }


    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }


    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    // lives at /hello/hello
    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello";
        } else if (language.equals("spanish")) {
            greeting = "Hola";
        } else if (language.equals("french")) {
            greeting = "Bonjour";
        } else if (language.equals("german")) {
            greeting = "Hallo";
        } else if (language.equals("russian")) {
            greeting = "Privet";
        }

        return greeting + " " + name;
    }



    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" +   // submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='languages'>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='russian'>Russian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
