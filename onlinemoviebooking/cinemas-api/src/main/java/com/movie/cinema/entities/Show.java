package com.movie.cinema.entities;

import java.sql.Timestamp;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shows")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false,name="`id`")
	private String id;
	
	@Column(nullable = false,name = "`time`")
	private Timestamp time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`screen_id`")
	private Screen screen;
	
	@Column(nullable = false,name = "`movieId`")
	private String movieId;
	
	@Column(nullable = false,name = "`isavailable`")
	private boolean isAvailable;
}
