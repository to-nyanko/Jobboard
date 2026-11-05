package jobboard;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {
	
	private final JobRepository jobRepository;
	private final CompanyRepository companyRepository;
	
	public JobController(JobRepository jobRepository,CompanyRepository companyRepository) {
		this.jobRepository = jobRepository;
		this.companyRepository = companyRepository;
	}
	
	@GetMapping("/jobs")
	public String index(Model model) {
		List<Job> jobList = jobRepository.findAll();
		model.addAttribute("jobList",jobList);
		return "index";
	}
	
	@GetMapping("/jobs/create")
	public String createForm(Model model, @ModelAttribute JobForm jobForm) {
		List<Company>companyList = companyRepository.findAll();
		model.addAttribute("companyList",companyList);
		return "create";
	}
	
	@PostMapping("/jobs")
	public String create(@Validated @ModelAttribute JobForm jobForm,BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Company>companyList = companyRepository.findAll();
			model.addAttribute("companyList",companyList);
			return "create";
		}
		
		Job job = new Job();
		job.setTitle(jobForm.getTitle());
		job.setSalary(jobForm.getSalary());
		job.setDescription(jobForm.getDescription());
		
		Company company = companyRepository.findById(jobForm.getCompanyId()).orElseThrow();
		job.setCompany(company);
		
		jobRepository.save(job);
		
		return "redirect:/jobs";
	}

}
