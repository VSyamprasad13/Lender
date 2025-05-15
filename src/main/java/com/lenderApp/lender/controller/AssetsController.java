package com.lenderApp.lender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenderApp.lender.entity.Assets;
import com.lenderApp.lender.service.AssetsService;

@RestController
@RequestMapping("/api/assets")
public class AssetsController {

	@Autowired
	private AssetsService service;
	
	@PostMapping("/{id}")
	public ResponseEntity<Assets> saveAssets(@PathVariable Long id,@RequestBody Assets entity){
		Assets assets = service.addAssets(id, entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(assets);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Assets> getAssetDetails(@PathVariable Long id){
		Assets details = service.getAssetDetails(id);
		return ResponseEntity.ok(details);
	}
}
