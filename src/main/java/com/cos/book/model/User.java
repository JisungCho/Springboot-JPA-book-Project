package com.cos.book.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
public class User {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  
	
	@Column(nullable = false,length = 200,unique = true)
	private String username;  
	
	@Column(nullable = false,length = 100,unique = true)
	private String nickname;
	
	@Column(nullable = false,length = 200)
	private String password;
	
	@Column(nullable = false,length = 300)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role; 
	
	private String oauth;  
	
	//@OneToMany를 2개이상 사용할 경우 Set으로 설정
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Board> board;
	  
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Favorite> favorite;  
	
	@CreationTimestamp
	private Timestamp createDate;
}
