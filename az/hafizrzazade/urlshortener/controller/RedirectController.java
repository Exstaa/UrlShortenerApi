package az.hafizrzazade.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import az.hafizrzazade.urlshortener.service.UrlService;


@Controller
public class RedirectController {
	@Autowired
    private UrlService urlService;
	
	@GetMapping("/index")
	public String loadIndexPage() {
		return "index";
	}
	
	@GetMapping("/{shortUrl}")
	public String redirectToGoogle(@PathVariable String shortUrl) {
        String longUrl = urlService.getOriginalUrl(shortUrl);
        if (longUrl == null) {
            throw new RuntimeException("URL not found");
        }
        
        
        return "redirect:" + longUrl;
	}

}
