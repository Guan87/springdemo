package com.david.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by GW on 2019/6/17.
 */
@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {
    /**
     *
     * * 添加静态资源--过滤swagger-api (开源的在线API文档)
     *
     * SpringBoot 使用WebJars统一管理静态资源
     *静态资源处理
     **/
    @Override
    public  void  addResourceHandlers(ResourceHandlerRegistry registry){

        //addResourceHandler()指的是对外暴漏的访问路经  addResourceLocations()指的是文件放置的位置
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/image/**")
                .addResourceLocations("classpath:/static/images/");

    }
    /* 视图跳转控制器
     *
     * 设置访问主页访问
      * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("/springdemo").setViewName("login.html");
    }


    /*
    * 方法中使用@ResponseBody注解, 返回值直接是一个字符串, 没有用到jackson转json, 中文会出现编码问题
    * 该bean处理返回值类型为String类型的结果时的编码问题
    * */
    @Bean
    public  HttpMessageConverter<String>  ResponseBodyConverter()   {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    /* 配置内容裁决的一些选项*/
    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//       /* 是否通过请求Url的扩展名来决定media type */
//        configurer.favorPathExtension(true)
//                 /* 不检查Accept请求头 */
//                .ignoreAcceptHeader(true)
//                .parameterName("mediaType")
//                 /* 设置默认的media yype */
//                .defaultContentType(MediaType.TEXT_HTML)
//                 /* 请求以.html结尾的会被当成MediaType.TEXT_HTML*/
//                .mediaType("html", MediaType.TEXT_HTML)
//                /* 请求以.json结尾的会被当成MediaType.APPLICATION_JSON*/
//                .mediaType("json", MediaType.APPLICATION_JSON);
//    }

}
