package com.pathshala.schedule.syllabus.exam.examschedule.dto;

import java.time.LocalDate;

import lombok.Data;

/**
 * 
 * @author kapoor_tirumala
 *
 */
@Data
public class ExamScheduleDTO{
	private Integer schoolId;	
	private Integer sessionId;	
	private Integer classId;	
	private Integer sectionId;
	private Integer subjectId;
//	@JsonFormat(pattern="HH:mm:ss",shape = JsonFormat.Shape.STRING)
	private String startT;
//	@JsonFormat(pattern="HH:mm:ss",shape = JsonFormat.Shape.STRING)
	private String endT;
	private LocalDate examDate;

	private String remarks;
	private String examType;
	private Integer examId;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	private LocalDate deletedDate;
}
