package pkg1.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.dto.Inv_BranchDto;
import pkg1.entity.Inv_BranchEntity;
import pkg1.entity.Inv_CompanyEntity;
import pkg1.entity.LocationsEntity;
import pkg1.repo.Inv_BranchRepo;
import pkg1.repo.Inv_CompanyRepo;
import pkg1.repo.LocationsRepo;

@RestController
public class Inv_BranchController {
	@Autowired
	Inv_BranchRepo inv_branchrepo;
	
	@Autowired
	Inv_CompanyRepo inv_companyrepo;
	
	@Autowired
	LocationsRepo locationsrepo;
	
	@PostMapping("/branches/add")
	public ResponseEntity<Inv_BranchEntity> addBranch(@RequestBody Inv_BranchDto inv_branchdto) {
		Inv_BranchEntity saved_branch=new Inv_BranchEntity();  //created the empty object
		saved_branch.setBranch_name(inv_branchdto.getInv_BranchEntity().getBranch_name());  //added one field
		
		long cid=inv_branchdto.getCompany_id();
		Inv_CompanyEntity company_obj=inv_companyrepo.findById(cid).orElseThrow(()->new NullPointerException("company id "+cid+" not present"));
		saved_branch.setInv_CompanyEntity(company_obj);    //added FK object
		
		long lid=inv_branchdto.getLocation_id();
		LocationsEntity location_obj=locationsrepo.findById(lid).orElseThrow(()->new NullPointerException("location id "+lid+" not present"));
		saved_branch.setLocationEntity(location_obj);   //added FK object
		
		inv_branchrepo.save(saved_branch);  //added to database
		return ResponseEntity.ok(saved_branch);
	}
	@GetMapping("/branches/view")
	public List<Inv_BranchEntity> viewBranches(){
		return inv_branchrepo.findAll();
	}
	@GetMapping("/branches/view/{id}")
	public Optional<Inv_BranchEntity> viewBranchById(@PathVariable long id){
		return inv_branchrepo.findById(id);
	}
	
	
	

}
