package com.davidrhp.mostwanted.scraping;

import com.davidrhp.mostwanted.scraping.dto.ScrapingDto;
import com.davidrhp.mostwanted.scraping.dto.TechnologyDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ScrapingService {

    public static final String BASE_URL = "https://de.indeed.com/Jobs";
    public static final String JOB_COUNT_ID = "searchCountPages";

    private static final String JOB_COUNT_REGEX = "von (\\d*) Jobs";
    private static final Pattern JOB_COUNT_PATTERN = Pattern.compile(JOB_COUNT_REGEX);

    public ScrapingDto getScrapingData() {
        String query = "jsf";
        String location = "München";

        TechnologyDto technologyDto = getTechnologyDto(query, location);
        ScrapingDto scrapingDto = new ScrapingDto(LocalDate.now(), location);
        scrapingDto.addTechnology(technologyDto);

        return scrapingDto;
    }

    private TechnologyDto getTechnologyDto(String query, String location) {
        String urlParams = String.format("?q=%s&l=%s", query, location);

        Document doc;
        try {
            doc = Jsoup.connect(BASE_URL + urlParams).get();
        } catch (IOException e) {
            return null;
        }

        String elementText = doc.getElementById(JOB_COUNT_ID).text();

        Matcher m = JOB_COUNT_PATTERN.matcher(elementText);
        int jobCount = 0;
        if (m.find()) {
            jobCount = Integer.parseInt(m.group(1));
        }

        return new TechnologyDto(query, jobCount);
    }
}
