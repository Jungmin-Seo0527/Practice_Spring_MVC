package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberExceptionControllerV4 implements ControllerV4 {

    @Override
    public String precess(Map<String, String> paramMap, Map<String, Object> model) {
        return "exception";
    }
}
