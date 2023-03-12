package com.movie.catalog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "moviecasts")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCast {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false,name="`id`")
	private String id;
	
	@Column(nullable = false,name = "`cast`")
	private String cast;

	@JsonIgnoreProperties("movieCasts")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`movie_id`")
	private Movie movie;
	
	@Column(nullable = false,name = "`role`")
	private String role;
}
