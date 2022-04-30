package com.ufpe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpe.exception.ResourceNotFoundException;
import com.ufpe.model.Company;
import com.ufpe.model.JsonObject;
import com.ufpe.model.Laboratory;
import com.ufpe.model.Property;
import com.ufpe.repository.CompanyRepository;
import com.ufpe.repository.LaboratoryRepository;
import com.ufpe.repository.PropertyRepository;

@RestController
@RequestMapping("/api/v1/")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private LaboratoryRepository laboratoryRepository;
	
	//getCompany
	@GetMapping("companies")
	public List<JsonObject> getAllCompanies(){
		List<JsonObject> jsonList = new ArrayList<JsonObject>();
		companyRepository.findAll().forEach((e) -> {
			Property property = new Property();
			Laboratory laboratory = new Laboratory();
			try {
				property = propertyRepository.findById(e.getProperty())
						.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + e.getProperty()));
				laboratory = laboratoryRepository.findById(e.getLaboratory())
						.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + e.getLaboratory()));
			} catch (ResourceNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JsonObject object = new JsonObject(e.getName(), e.getCnpj(), e.getObservations(), e.getStartDate(), e.getEndDate(), property, laboratory);
			jsonList.add(object);
		});
		
		return jsonList;
	}
	
	//getCompanyById
	@GetMapping("company/{id}")
	public ResponseEntity<JsonObject> getCompanyById(@PathVariable(value = "id") Long companyId)
		throws ResourceNotFoundException {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
		Property property = propertyRepository.findById(company.getProperty())
				.orElseThrow(() -> new ResourceNotFoundException("Property not found for this id :: " + company.getProperty()));
		Laboratory laboratory = laboratoryRepository.findById(company.getLaboratory())
				.orElseThrow(() -> new ResourceNotFoundException("Laboratory not found for this id :: " + company.getLaboratory()));
		
		JsonObject object = new JsonObject(company.getName(), company.getCnpj(), company.getObservations(), company.getStartDate(), company.getEndDate(), property, laboratory);
		return ResponseEntity.ok().body(object);
	}
	
	//saveCompany
	@PostMapping("company")
	public Company createCompany(@Valid @RequestBody JsonObject json) {
		System.out.println(json.getProperty().getName());
		Company company = new Company(json.getName(), json.getCnpj(), json.getObservations(), json.getStartDate(), json.getEndDate(), json.getProperty().getId(), json.getLaboratory().getId());
		Property property = new Property(json.getProperty().getId(), json.getProperty().getName());
		Laboratory laboratory = new Laboratory(json.getLaboratory().getId(), json.getLaboratory().getName());
		
		this.laboratoryRepository.save(laboratory);
		this.propertyRepository.save(property);
		return this.companyRepository.save(company);
	}
	
	//updateCompany
	@PutMapping("company/{id}")
	public ResponseEntity<JsonObject> updateCompany(@PathVariable(value="id") Long companyId,
			@Valid @RequestBody JsonObject object) throws ResourceNotFoundException{
		
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
		Property property = propertyRepository.findById(company.getProperty())
				.orElseThrow(() -> new ResourceNotFoundException("Property not found for this id :: " + company.getProperty()));
		Laboratory laboratory = laboratoryRepository.findById(company.getLaboratory())
				.orElseThrow(() -> new ResourceNotFoundException("Laboratory not found for this id :: " + company.getLaboratory()));

		company.setCnpj(object.getCnpj());
		company.setName(object.getName());
		company.setObservations(object.getObservations());
		company.setStartDate(object.getStartDate());
		company.setEndDate(object.getEndDate());
		company.setProperty(object.getProperty().getId());
		property.setId(object.getProperty().getId());
		property.setName(object.getProperty().getName());
		company.setLaboratory(object.getLaboratory().getId());
		laboratory.setId(object.getLaboratory().getId());
		laboratory.setName(object.getLaboratory().getName());
		this.companyRepository.save(company);
		this.propertyRepository.save(property);
		this.laboratoryRepository.save(laboratory);
		return ResponseEntity.ok(object);
	}
	
	//deleteCompany
	@DeleteMapping("company/{id}")
	public Map<String, Boolean> deleteCompany(@PathVariable(value = "id") Long companyId) throws ResourceNotFoundException {
		
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
		Property property = propertyRepository.findById(company.getProperty())
				.orElseThrow(() -> new ResourceNotFoundException("Property not found for this id :: " + company.getProperty()));
		Laboratory laboratory = laboratoryRepository.findById(company.getLaboratory())
				.orElseThrow(() -> new ResourceNotFoundException("Laboratory not found for this id :: " + company.getLaboratory()));

		this.companyRepository.delete(company);
		this.propertyRepository.delete(property);
		this.laboratoryRepository.delete(laboratory);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
