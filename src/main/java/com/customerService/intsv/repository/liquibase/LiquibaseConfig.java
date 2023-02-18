package com.customerService.intsv.repository.liquibase;

import com.sun.xml.bind.v2.TODO;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class LiquibaseConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public SpringLiquibase liquibase(){


        String changelogFile = "classpath:/liquibase/changelog.xml"; // изменить путь,после того,как Марсель запилит миграции. Затестить
        Resource resource = resourceLoader.getResource(changelogFile);
        Assert.state(resource.exists(), "Unable to find file: " + changelogFile);


        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(changelogFile);
        liquibase.setContexts("test,dev,prod");
        liquibase.setDataSource(dataSource);
        liquibase.setDefaultSchema("mySchema");
        liquibase.setDropFirst(false);
        liquibase.setShouldRun(true);


        Map<String, String> params = new HashMap<>();
        params.put("verbose", "true"); // проверить работу со стринговым true
        liquibase.setChangeLogParameters(params);

        return liquibase;
    }

}
