package com.movie.cinema.entities;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cinemas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false,name="`id`")
	private String id;
	
	@Column(nullable = false,name = "`name`")
	private String name;
	
	@Column(nullable = false,name = "`address`")
	private String address;
	
	@Column(nullable = false,name = "`city`")
	private String city;
	
	@Column(nullable = false,name = "`country`")
	private String country;
	
	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
            mappedBy = "cinema")
	@JsonBackReference
	private List<Screen> screens = new ArrayList<>();
}
