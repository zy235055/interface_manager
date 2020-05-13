package com.abchina.interfacemanager.config;

import com.abchina.interfacemanager.component.LoginHandlerInterceptor;
import com.abchina.interfacemanager.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/atguigu").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
//    @Bean //将组件注册在容器
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
//        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashboard");
//            }
//
//            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //super.addInterceptors(registry);
//                //静态资源；  *.css , *.js
//                //SpringBoot已经做好了静态资源映射
////                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
////                        .excludePathPatterns("/index.html","/","/user/login");
//            }
//        };
//        return adapter;
//    }

    @Configuration
    public class WebMvcConfig implements WebMvcConfigurer {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("login");
            registry.addViewController("/index.html").setViewName("login");
            registry.addViewController("/main.html").setViewName("dashboard");
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            //静态资源；  *.css , *.js
           //SpringBoot已经做好了静态资源映射
           registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login", "/asserts/**", "/webjars/**", "/**.ico", "/user/loginOut");
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            registry.addResourceHandler("/favicon.ico")//favicon.ico
                    .addResourceLocations("classpath:/resources/");
        }
        //        @Override
//        protected void addViewControllers(ViewControllerRegistry registry) {
//            registry.addViewController("/").setViewName("login");
//            registry.addViewController("/index.html").setViewName("login");
//            registry.addViewController("/main.html").setViewName("dashboard");
//        }
//
//        @Override
//        protected void addInterceptors(InterceptorRegistry registry) {
//            //super.addInterceptors(registry);
//
//        }
//
//
//        @Override
//        protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        }
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}