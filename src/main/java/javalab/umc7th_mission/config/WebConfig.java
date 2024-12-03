package javalab.umc7th_mission.config;


import javalab.umc7th_mission.validation.resolver.PageArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final PageArgumentResolver pageArgumentResolver;

    public WebConfig(PageArgumentResolver pageArgumentResolver) {
        this.pageArgumentResolver = pageArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(pageArgumentResolver);
    }
}