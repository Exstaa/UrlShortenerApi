package az.hafizrzazade.urlshortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.hafizrzazade.urlshortener.model.URL;

@Repository
public interface UrlRepository extends JpaRepository<URL, Integer>{

	Optional<URL> findByShortUrl(String shortUrl);
}
