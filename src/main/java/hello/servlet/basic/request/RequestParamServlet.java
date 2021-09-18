package hello.servlet.basic.request;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> log.info("{} = {}", paramName, request.getParameter(paramName)));
        log.info("[전체 파라미터 조회] - end");
        log.info("---");

        log.info("[단일 파라미터 조회] - start");
        log.info("username = {}", request.getParameter("username"));
        log.info("age = {}", request.getParameter("age"));
        log.info("[단일 파라미터 조회] - end");
        log.info("---");

        log.info("[이름이 같은 복수 파라미터 조회] - start");
        Arrays.stream(request.getParameterValues("username"))
                .forEachOrdered(username -> log.info("username = {}", username));
        log.info("---");

        response.getWriter().write("ok");
    }
}
