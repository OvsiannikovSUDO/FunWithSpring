package ru.inno.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.inno.config.FactConfig;
import ru.inno.controllers.model.FunFactModel;
import ru.inno.services.FunService;

import java.util.Arrays;

@Controller
public class FunController {

    private final FunService funService;
    private final String serviceUrl;
    private final Environment env;
    private final FactConfig config;

    public FunController(final FunService funService,
                         @Value("${integration.fun-fact.url}") final String serviceUrl,
                         @Value("${integration.fun-fact.missing:}") final String nonExist,
                         final Environment env,
                         final FactConfig config) {
        this.funService = funService;
        this.serviceUrl = serviceUrl;
        this.env = env;
        this.config = config;
    }

    /**
     * @deprecated Use "/api/random"
     * @return
     */
    @GetMapping("random")
    @ResponseBody
    @Deprecated(forRemoval = true)
    public FunFactModel getFun() {
        return funService.getRandomFact();
    }

    @GetMapping("check1")
    @ResponseBody
    public String getFun1() {
        return "welcome";
    }

    @GetMapping("check2")
    public String getFun2() {
        return "welcome";
    }

    // http://localhost:8080/?name=John
    @GetMapping
    public String getFunTest(final Model model, @RequestParam(defaultValue = "World") final String name) {
        model.addAttribute("name", name);
        model.addAttribute("url", serviceUrl);
        model.addAttribute("profiles", Arrays.stream(env.getActiveProfiles()).toList());
        model.addAttribute("apiKey", config.getApiKey());
        model.addAttribute("sericeName", funService.getServiceName());
        return "welcome";
    }
}
