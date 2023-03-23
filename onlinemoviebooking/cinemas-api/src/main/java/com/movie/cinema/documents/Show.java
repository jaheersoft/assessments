package com.movie.cinema.documents;

import java.time.LocalDateTime;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "shows")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {

	@Id
	private String id;
	private LocalDateTime time;
	private String movieId;
	private boolean isAvailable;
	
	@DocumentReference(lazy = false)
	@JsonBackReference
	private Screen screen;
}
