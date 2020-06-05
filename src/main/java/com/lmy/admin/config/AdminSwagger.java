package com.lmy.admin.config;
/**
 * @Project leyou
 * @Package com.leyou.config
 * @author Administrator
 * @date 2020/5/25 18:04
 * @version V1.0
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 * @ClassName LeyouSwagger
 * @Description 接口文档
 * @date 2020/5/25 18:04
 **/
@Configuration
@EnableSwagger2
public class AdminSwagger {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("选课管理系统接口文档")
                .apiInfo(webApiInfo())
                .select()
                .build();

    }

    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("AdminAPI文档")
                .description("本文档描述了商城微服务接口定义")
                .version("1.0")
                .build();
    }


}
