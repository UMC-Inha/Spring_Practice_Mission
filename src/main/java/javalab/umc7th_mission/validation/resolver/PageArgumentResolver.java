package javalab.umc7th_mission.validation.resolver;

import javalab.umc7th_mission.validation.annotation.CheckPage;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CheckPage.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String pageParam = webRequest.getParameter(parameter.getParameterName());
        if (pageParam == null) {
            return 0;
        }

        int page = Integer.parseInt(pageParam);
        if (page < 1) {
            throw new IllegalArgumentException("페이지 번호가 너무 작습니다.");
        }

        return page - 1;

    }
}