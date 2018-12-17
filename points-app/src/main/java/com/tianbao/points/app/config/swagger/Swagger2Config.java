package com.tianbao.points.app.config.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger2的配置
 * @author wujr 2018-08-28
 */
//@Configuration
//@EnableSwagger2
public class Swagger2Config {
    @Value("${spring.swagger.package}")
    private String swaggerPackage;
    @Value("${spring.swagger.title}")
    private String swaggerTitle;
    @Value("${spring.swagger.contact.name}")
    private String swaggerContactName;
    @Value("${spring.swagger.contact.url}")
    private String swaggerContactUrl;
    @Value("${spring.swagger.contact.email}")
    private String swaggerContactEmail;
    @Value("${spring.swagger.version}")
    private String swaggerVersion;
    @Value("${spring.swagger.desc}")
    private String swaggerDesc;

    /**
     * 创建接口声明
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @author wujr 2018-08-28
     * @return docket 文档
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage(swaggerPackage))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     * @author wujr 2018-08-28
     * @return 接口信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title(swaggerTitle)
                //创建人
                .contact(new Contact(swaggerContactName, swaggerContactUrl, swaggerContactEmail))
                //版本号
                .version(swaggerVersion)
                //描述
                .description(swaggerDesc)
                .build();
    }
}