package my.pinkyo.demo.controller;

import my.pinkyo.demo.model.DataCategory;
import my.pinkyo.demo.service.DumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/data-dump")
public class DataDumpController {
    @Autowired
    private ApplicationContext applicationContext;
    private Map<DataCategory, DumpService> dumpServiceMap;
    @PostConstruct
    public void setup() {
        Map<String, DumpService> result = applicationContext.getBeansOfType(DumpService.class);
        dumpServiceMap = Collections.unmodifiableMap(
                result.entrySet().stream().collect(Collectors.toMap(
                        entry -> entry.getValue().getCategory(), Map.Entry::getValue)));

    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<DataCategory> getDataCategories() {
        return Arrays.asList(DataCategory.USER);
    }

    @RequestMapping(value = "/dump/{category}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List getData(@PathVariable DataCategory category) {
        return dumpServiceMap.get(category).dump();
    }
}
