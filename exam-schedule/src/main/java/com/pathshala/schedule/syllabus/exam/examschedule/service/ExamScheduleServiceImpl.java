package com.pathshala.schedule.syllabus.exam.examschedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pathshala.schedule.syllabus.exam.examschedule.dto.ExamScheduleDTO;
import com.pathshala.schedule.syllabus.exam.examschedule.mapper.ExamScheduleMapper;
import com.pathshala.schedule.syllabus.exam.examschedule.model.ExamSchedule;
import com.pathshala.schedule.syllabus.exam.examschedule.repository.ExamScheduleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExamScheduleServiceImpl implements ExamScheduleService {

	private final ExamScheduleRepository repository;
	private final ExamScheduleMapper examScheduleMapper;

	public ExamSchedule createExamSchedule(ExamScheduleDTO examScheduleDTO) {

		ExamSchedule examSchedule = examScheduleMapper.toExamSchedule(examScheduleDTO);
		return repository.save(examSchedule);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public void updateExamSchedule(String examScheduleId, ExamScheduleDTO dto) {

		ExamSchedule examSchedule = examScheduleMapper.toExamSchedule(dto);
		examSchedule.setId(Integer.valueOf(examScheduleId));
		repository.save(examSchedule);

	}

	public List<ExamScheduleDTO> findAll() {
		List<ExamSchedule> examSchedules = repository.findAll();
		return examScheduleMapper.toExamScheduleDTOs(examSchedules);
	}

	public ExamScheduleDTO findById(Integer id) {
		Optional<ExamSchedule> examSchedule = repository.findById(id);
		return examScheduleMapper.toExamScheduleDTO(examSchedule.get());
	}

	@Override
	public List<ExamScheduleDTO> findByClassIdAndSectionIdAndExamType(Integer classId, Integer sectionId,
			String examType) {
		List<ExamSchedule> examSchedules = repository.findByClassIdAndSectionIdAndExamType(classId, sectionId,
				examType);
//		Comparator<ExamSchedule> compareBySectionAndExamType = Comparator
//                .comparing(ExamSchedule::getSectionId)
//                .thenComparing(ExamSchedule::getExamType)
//                .thenComparing(ExamSchedule::getExamDate);
//		return examScheduleMapper.toExamScheduleDTOs(examSchedules.stream()
//				.sorted(compareBySectionAndExamType)
//				.collect(Collectors.toList()));
		return examScheduleMapper.toExamScheduleDTOs(examSchedules);
	}

	@Override
	public List<ExamScheduleDTO> findExamScheduleWithSorting(String fieldName) {
		List<ExamSchedule> examScheduleWithSorting = repository.findAll(Sort.by(fieldName));
		return examScheduleMapper.toExamScheduleDTOs(examScheduleWithSorting);
	}
	
	public List<ExamScheduleDTO> findExamScheduleWithPagination(int offset, int pageSize) {
		Page<ExamSchedule> examSchedules = repository.findAll(PageRequest.of(offset, pageSize));
		return examScheduleMapper.toExamScheduleDTOs(examSchedules.getContent());
	}
	

}
