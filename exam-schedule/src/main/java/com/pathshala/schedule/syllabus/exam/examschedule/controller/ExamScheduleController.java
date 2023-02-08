package com.pathshala.schedule.syllabus.exam.examschedule.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pathshala.schedule.syllabus.exam.examschedule.dto.ExamScheduleDTO;
import com.pathshala.schedule.syllabus.exam.examschedule.service.ExamScheduleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author kapoor_tirumala
 *
 */

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/exam/schedule")
public class ExamScheduleController {
	
	private final ExamScheduleService examScheduleService;
	
	
	
	@PostMapping
	public ResponseEntity<ExamScheduleDTO> create(@RequestBody ExamScheduleDTO examScheduleDTO){
		log.info("ExamScheduleController :: create");		
		examScheduleService.createExamSchedule(examScheduleDTO);
		log.info("ExamSchedule created successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(examScheduleDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExamScheduleDTO> findById(@PathVariable("id") String id){
		ExamScheduleDTO examScheduleDTO = examScheduleService.findById(Integer.valueOf(id));		 
		return ResponseEntity.ok(examScheduleDTO);
	}
	
	@GetMapping("/classsectionandexamtype")
	public ResponseEntity<List<ExamScheduleDTO>> findByClassSectionAndExamType(@RequestParam Integer classId,
			@RequestParam Integer sectionId, @RequestParam String examType){
		 List<ExamScheduleDTO> findByClassIdAndSectionIdAndExamType = examScheduleService.findByClassIdAndSectionIdAndExamType(classId, sectionId, examType);		 
		return ResponseEntity.ok(findByClassIdAndSectionIdAndExamType);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ExamScheduleDTO> update(@PathVariable("id") String id, @RequestBody ExamScheduleDTO dto)
	{
		examScheduleService.updateExamSchedule(id, dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		examScheduleService.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<ExamScheduleDTO>> findAll(){
		return ResponseEntity.ok(examScheduleService.findAll());
	}
	
	@GetMapping("/sort/{field}")
	public ResponseEntity<List<ExamScheduleDTO>> findExamScheduleWithSort(@PathVariable("field") String field){
		return ResponseEntity.ok(examScheduleService.findExamScheduleWithSorting(field));
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public ResponseEntity<List<ExamScheduleDTO>> findExamScheduleWithPagination(@PathVariable("offset") int offset,@PathVariable("pageSize") int pageSize){
		return ResponseEntity.ok(examScheduleService.findExamScheduleWithPagination(offset,pageSize));
	}
	

}
