package az.hafizrzazade.urlshortener.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.hafizrzazade.urlshortener.model.URL;
import az.hafizrzazade.urlshortener.repository.UrlRepository;

@Service
public class UrlService {
	    @Autowired
	    private UrlRepository urlRepository;

	    public String shortenUrl(String originalUrl) {
	        URL url = new URL();
	        url.setLongUrl(originalUrl);
	        urlRepository.save(url);

	        String shortCode = Base64.getUrlEncoder()
	                                 .withoutPadding()
	                                 .encodeToString(String.valueOf(url.getId()).getBytes(StandardCharsets.UTF_8));
	        url.setShortUrl(shortCode);

	        urlRepository.save(url);

	        return shortCode;
	    }

	    public String getOriginalUrl(String shortUrl) {
	        return urlRepository.findByShortUrl(shortUrl)
	                            .map(URL::getLongUrl)
	                            .orElse(null); 
	    }
}
