package com.movie.catalog.entities;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false,name="`id`")
	private String id;
	
	@Column(nullable = false,name = "`title`")
	private String title;

	@Column(nullable = false,name = "`description`")
	private String description;
	
	@Column(nullable = false,name = "`durationInMins`")
	private int durationInMins;
	
	@Column(nullable = false,name = "`releaseDate`")
	private Date releaseDate;
	
	@Column(nullable = false,name = "`maturityRating`")
	private String maturityRating;
	
	@Column(nullable = false,name = "`year`")
	private int year;
	
	@Column(nullable = false,name = "`country`")
	private String country;
	
	@Column(nullable = false,name = "`addedOn`")
	private Date addedOn;
	
	@Builder.Default
	@Column(nullable = false,name = "`isDeleted`")
	private boolean isDeleted = false;
	
	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
            mappedBy = "movie")
	@JsonIgnoreProperties("movie")
	private List<MovieCast> movieCasts =  new ArrayList<>();
	
	@Builder.Default
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			  name = "movielanguages", 
			  joinColumns = @JoinColumn(name = "`movie_id`"), 
			  inverseJoinColumns = @JoinColumn(name = "`language_id`"))
	@JsonIgnoreProperties("movie")
	private List<Language> movieLanguages = new ArrayList<>();
	
	@Builder.Default
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			  name = "moviegenres", 
			  joinColumns = @JoinColumn(name = "`movie_id`"), 
			  inverseJoinColumns = @JoinColumn(name = "`genre_id`"))
	@JsonIgnoreProperties("movie")
	private List<Genre> movieGenres = new ArrayList<>();
}

