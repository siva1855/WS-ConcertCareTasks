package com.concertcare.sivatask.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.concertcare.sivatask.vo.StudentVO;

//producer Application URL
@FeignClient(name = "CC-STUDENTSERVICE")
public interface StudentFeignClient {

	/* producer ----- get all records */
	@RequestMapping(value = "/studentservice/all", method = RequestMethod.GET, consumes = "application/json")
	public List<StudentVO> getData();

}
