package az.hafizrzazade.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class URL {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   
       private Integer id;
       private String longUrl;
       private String shortUrl;
}
