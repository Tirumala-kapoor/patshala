package com.pathshala.schedule.syllabus.exam.examschedule.mapper;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.pathshala.schedule.syllabus.exam.examschedule.dto.ExamScheduleDTO;
import com.pathshala.schedule.syllabus.exam.examschedule.model.ExamSchedule;

@Mapper(componentModel = "spring")
public interface ExamScheduleMapper {
	
	//ExamScheduleMapper INSTANCE = Mappers.getMapper(ExamScheduleMapper.class);
	ExamScheduleDTO toExamScheduleDTO(ExamSchedule examSchedule);
	
	
	

//    default LocalDateTime fromInstant(Instant instant, @Context TimeZone timeZone) {
//        return instant == null ? null : LocalDateTime.ofInstant(instant, timeZone.toZoneId());
//    }
	
	List<ExamScheduleDTO> toExamScheduleDTOs(List<ExamSchedule> examSchedules);
	
	@Mapping(target = "startTime", source = "examScheduleDTO.startT", ignore = true)
	@Mapping(target = "endTime", source = "examScheduleDTO.endT", ignore = true)
	ExamSchedule toExamSchedule(ExamScheduleDTO examScheduleDTO);
	
	//@Named("startTToStartTime")
    default Time map(String value) throws ParseException {

       // Time startTime = Time.valueOf(value);//.parse(dto.getStartT(), dateTimeFormatter); 
       // ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(dto. getTimeZoneStart()));
       
        
        DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = sdf.parse(value);
        Time startTime = new Time(date.getTime());
        return startTime;
    }

//    @Named("endTTToEndTime")
//    default Time endTTToEndTime(ExamScheduleDTO dto) {
//
//    	Time endTime = Time.valueOf(dto.getEndT());
//        //ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(dto. getTimeZoneEnd()));
//        return endTime;
//    }

}
