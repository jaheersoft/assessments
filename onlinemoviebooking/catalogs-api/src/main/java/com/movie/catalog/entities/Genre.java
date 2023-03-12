package com.movie.catalog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "genres")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false,name="`id`")
	private String id;
	
	@Column(nullable = false,name = "`name`")
	private String name;
	
	@Builder.Default
	@JsonIgnoreProperties("movieGenres")
	@ManyToMany(mappedBy = "movieGenres", cascade = { CascadeType.ALL })
	private List<Movie> movies = new ArrayList<>();
}
