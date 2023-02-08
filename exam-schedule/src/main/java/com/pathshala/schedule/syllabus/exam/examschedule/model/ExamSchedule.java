package com.pathshala.schedule.syllabus.exam.examschedule.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="exam_schedules")
@Setter
@Getter
public class ExamSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_schedule_id")
	private Integer id;
	
	private Integer schoolId;	
	private Integer sessionId;	
	private Integer classId;	
	private Integer sectionId;
	private Integer subjectId;
	private LocalDate examDate;
	@Temporal(TemporalType.TIME)
	private Time startTime;
	@Temporal(TemporalType.TIME)
	private Time endTime;
	private String remarks;
	private String examType;
	private Integer examId;
	@CreationTimestamp
	private LocalDate createdDate;
	@UpdateTimestamp
	private LocalDate updatedDate;
	private LocalDate deletedDate;
	

}
