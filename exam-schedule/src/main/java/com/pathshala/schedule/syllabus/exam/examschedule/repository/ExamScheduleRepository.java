package com.pathshala.schedule.syllabus.exam.examschedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pathshala.schedule.syllabus.exam.examschedule.model.ExamSchedule;
/**
 * 
 * @author kapoor_tirumala
 *
 */
public interface ExamScheduleRepository extends JpaRepository<ExamSchedule, Integer>{
	
	List<ExamSchedule> findByClassIdAndSectionIdAndExamType(Integer classId, Integer sectionId, String examType);
	
}
