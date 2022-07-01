package com.liuyq.jdk1216;

/**
 * @author liuyuqing
 * @className switchTest
 * @description
 * @date 2022/6/29 3:37 下午
 */
public class SwitchTest {

    public static String old(int score) {
        score /= 10;
        String grade = "";
        switch (score) {
            case 10:
            case 9:
                grade = "优秀";
                break;
            case 8:
            case 7:
                grade = "良好";
                break;
            default:
                grade = "不及格";
        }
        return grade;
    }


    /**
     * switch表达式
     *
     * @param score
     * @return
     */
    public static String newVersion(int score) {
        score /= 10;
        return switch (score) {
            case 10, 9 -> "优秀";
            case 8, 7 -> {
                System.out.println("232323");
                yield "良好";
            }
            default -> "不及格";
        };
    }
}
