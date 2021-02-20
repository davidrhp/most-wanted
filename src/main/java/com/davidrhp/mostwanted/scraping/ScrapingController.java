package com.davidrhp.mostwanted.scraping;

import com.davidrhp.mostwanted.scraping.dto.ScrapingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ScrapingController {

    private final ScrapingService scrapingService;

    @Autowired
    public ScrapingController(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    @GetMapping
    public ScrapingDto getScrapingData() {
        return scrapingService.getScrapingData();
    }
}
