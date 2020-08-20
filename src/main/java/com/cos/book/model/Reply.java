package com.cos.book.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
public class Reply {
	@Id //primary key
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //A.I
	
	@Column(nullable = false,length = 200)
	private String content;
	
	@ManyToOne //여러개의 답변은 하나의 게시글에 달릴 수 있다.
	@JoinColumn(name = "boardId")
	private Board board;
	
	@ManyToOne // 여러개의 답변을 하나의 유저가 쓸 수 있다.
	@JoinColumn(name = "userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
