package com.pathshala.schedule.syllabus.exam.examschedule.service;

import java.util.List;

import com.pathshala.schedule.syllabus.exam.examschedule.dto.ExamScheduleDTO;
import com.pathshala.schedule.syllabus.exam.examschedule.model.ExamSchedule;
/**
 * 
 * @author kapoor_tirumala
 *
 */
public interface ExamScheduleService {
	
	
	
	public ExamSchedule createExamSchedule(ExamScheduleDTO examScheduleDTO) ;
	
	public void deleteById(Integer id);

	public void updateExamSchedule(String examScheduleId, ExamScheduleDTO dto) ;
	
	//FIND
	public List<ExamScheduleDTO> findAll();
	public ExamScheduleDTO findById(Integer id);
	public List<ExamScheduleDTO> findByClassIdAndSectionIdAndExamType(Integer classId, Integer sectionId, String examType);

	//SORTING BY FIELD
	public List<ExamScheduleDTO> findExamScheduleWithSorting(String feildName);
	
	//PAGINATION
	public List<ExamScheduleDTO> findExamScheduleWithPagination(int offset, int pageSize);

}
