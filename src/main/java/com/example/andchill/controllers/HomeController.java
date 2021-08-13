package com.example.andchill.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "<!doctype html>\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "\n" +
                "  <title>Spring Boot Server is Running</title>\n" +
                "  <meta name=\"description\" content=\"A simple HTML5 Template for new projects.\">\n" +
                "  <meta name=\"author\" content=\"SitePoint\">\n" +
                "\n" +
                "  <meta property=\"og:title\" content=\"A Basic HTML5 Template\">\n" +
                "  <meta property=\"og:type\" content=\"website\">\n" +
                "  <meta property=\"og:url\" content=\"https://www.sitepoint.com/a-basic-html5-template/\">\n" +
                "  <meta property=\"og:description\" content=\"A simple HTML5 Template for new projects.\">\n" +
                "  <meta property=\"og:image\" content=\"image.png\">\n" +
                "\n" +
                "  <link rel=\"icon\" href=\"/favicon.ico\">\n" +
                "  <link rel=\"icon\" href=\"/favicon.svg\" type=\"image/svg+xml\">\n" +
                "  <link rel=\"apple-touch-icon\" href=\"/apple-touch-icon.png\">\n" +
                "\n" +
                "  <link rel=\"stylesheet\" href=\"css/styles.css?v=1.0\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "  <h1>Spring Boot API for And Chill is Running </h1>\n" +
                "  <script src=\"js/scripts.js\"></script>\n" +
                "</body>\n" +
                "</html>";
    }
}