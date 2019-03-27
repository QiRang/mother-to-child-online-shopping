package com.example.mothertochild.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration                       //注解表示这个是一个配置文件，让spring来加载该类配置
@EnableSwagger2                      //注解表示启用Swagger2
//@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")
public class SwaggerConfig {
    @Bean                            //注解表示交由bean容器去管理
    public Docket newsApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("用户登陆密钥")
                .modelRef(new ModelRef("string")).parameterType("query").required(false).build();
        pars.add(tokenPar.build());
        //这段代码是默认参数，添加上后，所有的接口都会有一个公共参数，不需要在每个接口单独配置
        return new Docket(DocumentationType.SWAGGER_2)
                //生产环境下将true改为false这样swagger就不再展示
                .enable(true)
                //apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
                //select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，本例采用指定扫描的包路径来定义，
                // Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.mothertochild.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars)  ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("这里是项目所有接口")
                .termsOfServiceUrl("http://www-03.n.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("NiYan")
                .license("China Red Star Licence Version 1.0")
                .licenseUrl("#")
                .version("1.0").build();
    }

}
