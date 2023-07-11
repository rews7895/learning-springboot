package com.generation.www.controller;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {
    @GetMapping("/textBlock")
    public String textBlock() {

        String query11 = """
                SELECT * FROM "items"
                WHERE "status" = "ON_SALE"
                ORDER BY "price";
                """;

        return query11;
    }

    @GetMapping("/formattedMethod")
    public String formattedMethod() {
        JsonObject jo = new JsonObject();

        jo.addProperty("id", 2);
        jo.addProperty("name", "juice");
        jo.addProperty("created_at", new Date().toString());


//        String textBlock17 = """
//                {
//                    "id": %d,
//                    "name": %s
//                }
//                """.formatted(2, "juice");
//
//        return textBlock17;

        return jo.toString();
    }
}
