package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.concretes.dtos.JobAdvertisementForAddDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	
	JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementForAddDto jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadline")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadline();
	}
	
	@GetMapping("/findByIsActiveTrueAndEmployer_EmployerId")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_UserId(@RequestParam int userId){
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_UserId(userId);
	}
	
	@PutMapping("/closeAdvertisement")
	public Result closeAdvertisement(int id, int userId) {
		return this.jobAdvertisementService.closeAdvertisement(id, userId);
	}
	
}
