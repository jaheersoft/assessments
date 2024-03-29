package com.movie.catalog.documents;

import javax.persistence.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "moviecasts")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCast {

	
	private String id;
	
	private String name;
	
	@DocumentReference(lazy = true)
    @ReadOnlyProperty
    @JsonManagedReference
	private Movie movie;
	
	private String role;
}
