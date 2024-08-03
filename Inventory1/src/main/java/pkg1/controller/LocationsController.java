package pkg1.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.entity.LocationsEntity;
import pkg1.repo.LocationsRepo;

@RestController
public class LocationsController {
	@Autowired
	LocationsRepo locationsRepo;
	@PostMapping("/locations/add")
	public String addLocations(@RequestBody LocationsEntity locationsEntity) {
		locationsRepo.save(locationsEntity);
		return "Success";
	}
	@GetMapping("/locations/view")
	public List<LocationsEntity> viewLocations(){
		return locationsRepo.findAll();
	}
	@GetMapping("/locations/view/{id}")
	public Optional<LocationsEntity> viewLocationsById(@PathVariable long id){
		return locationsRepo.findById(id);
	}
	
}
