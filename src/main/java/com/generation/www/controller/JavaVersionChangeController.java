package com.generation.www.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaVersionChangeController {
    /**
     * 텍스트 블록
     *
     * 이전에는 여러 줄의 텍스트를 작성하려면 \n을 추가해야 했지만 이제는 """로 감싼 텍스트를 사용해 여러 줄의 텍스트를 표현할 수 있다.
     */
    @GetMapping("/textBlockExample")
    public String textBlockExample() {
        String query11 = """
                SELECT * FROM "items"
                WHERE "status" = "ON_SALE"
                ORDER BY "price";
                """;

        return query11;
    }

    /**
     * 포맷 메서드
     *
     * 값을 파싱하기 위한 fomatted() 메서드를 제공
     */
    @GetMapping("/formattedMethodExample")
    public String formattedMethodExample() {
        String textBlock17 = """
                {
                    "id": %d,
                    "name": %s
                }
                """.formatted(2, "juice");

        return textBlock17;
    }

    /**
     * 레코드
     *
     * 레코드는 데이터 전달을 목적으로 하는 객체를 더 빠르고 간편하게 만들기 위한 기능이다.
     * 레코드는 상속을 할 수 없고 파라미터에 정의한 필드는 private final로 정의된다.
     * 또한 레코드는 getter를 자동으로 만들기 때문에 어노테이션이나 메서드로 게터를 정의하지 않아도 된다.
     */
    record Item(String name, int price) {}
    @GetMapping("/recordExample")
    public int recordExample() {
        Item juice = new Item("juice", 3000);

        return juice.price();
    }

    /**
     * 패턴 매칭
     *
     * 패턴 매칭은 타입 확인을 위해 사용하던 instanceof 키워드를 조금 더 쉽게 사용할 수 있게 해준다.
     */
    public void patternMachingExample() {
//        int o = 1;
//        java 11
//        if(o instanceof Integer) {
//            Integer i = (Integer) o;
//        }

//        if(o instanceof Integer i) {
//
//        }
    }
}
