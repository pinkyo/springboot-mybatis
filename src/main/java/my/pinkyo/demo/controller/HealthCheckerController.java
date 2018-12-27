package my.pinkyo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.DataSourceHealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@RestController
public class HealthCheckerController {

    @Autowired
    private DataSource dataSource;
    private DataSourceHealthIndicator dshl;

    @PostConstruct
    public void setup() {
        dshl = new DataSourceHealthIndicator(dataSource);
    }

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public String health() {
        return dshl.health().getStatus().getDescription();
    }
}
