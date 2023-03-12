package com.movie.cinema.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "screens")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screen {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false,name="`id`")
	private String id;
	
	@Column(nullable = false,name = "`name`")
	private String name;
	
	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
            mappedBy = "screen")
	private List<Seat> seats = new ArrayList<>();
	
	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
            mappedBy = "screen")
	private List<Show> shows = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`cinema_id`")
	@JsonManagedReference
	private Cinema cinema;
}
