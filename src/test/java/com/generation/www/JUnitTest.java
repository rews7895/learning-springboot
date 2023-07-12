package com.generation.www;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    // 테스트 이름
    @DisplayName("1 + 2는 3이다")
    // 테스트 메서드
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        // 값이 같은지 확인
        Assertions.assertEquals(sum, a + b);
    }

//    @DisplayName("1 + 3은 4이다")
//    @Test
//    public void junitFailedTest() {
//        int a = 1;
//        int b = 3;
//        int sum = 3;
//
//        Assertions.assertEquals(sum, a + b);
//    }
}
