package pkg1.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.entity.Inv_CompanyEntity;
import pkg1.repo.Inv_CompanyRepo;

@RestController
public class Inv_CompanyController {
	@Autowired
	Inv_CompanyRepo inv_companyrepo;
	@GetMapping("/hello")
	public String testHello() {
		return "Hello World";
	}
	@PostMapping("/companies/add")
	public String addCompany(@RequestBody Inv_CompanyEntity inv_CompanyEntity) {
		inv_companyrepo.save(inv_CompanyEntity);
		return "Success";
	}
	@GetMapping("/companies/view")
	public List<Inv_CompanyEntity> viewCompany(){
		return inv_companyrepo.findAll();
	}
	@GetMapping("/companies/view/{id}")
	public Optional<Inv_CompanyEntity> viewCompanyById(@PathVariable long id){
		return inv_companyrepo.findById(id);
	}
	
	

}
