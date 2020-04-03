package com.example.demoSSH.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoSSH.dao.DataSourceDao;
import com.example.demoSSH.entity.Datasource;

@RestController
public class DataSourceController {

	@Autowired
	private DataSourceDao dao;
	
	private final Logger log = LoggerFactory.getLogger(DataSourceController.class);
	
	@GetMapping("/datasource")
	List<Datasource> all() {
		return dao.findAll();
	}

	@PostMapping("/datasource")
	Datasource newDatasource(@RequestBody Datasource newDatasource) {
		log.info(newDatasource.toString());
		return dao.save(newDatasource);
	}
	
	@PutMapping("/datasource/{id}")
	Datasource updateDS(@RequestBody Datasource datasource, @PathVariable Long id) {
		datasource.setId(id);
		return dao.save(datasource);
	}
	
	@DeleteMapping("/datasource/{id}")
	void deleteDatasource(@PathVariable Long id) {
		dao.deleteById(id);
	}
	
	@GetMapping("datasource/query")
	List<Datasource> query(String systemName, String tableName) {
		if (StringUtils.isEmpty(systemName)) {
			return dao.findByTableNameLike('%' + tableName + '%');
		} else {
			return dao.findBySystemNameAndTableNameLike(systemName, '%' + tableName + '%');
		}
	}
	
	@GetMapping("datasource/query/page")
	Page<Datasource> queryPage(String systemName, String tableName,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		if (StringUtils.isEmpty(systemName)) {
			return dao.findByTableNameLike('%' + tableName + '%', pageRequest);
		} else {
			return dao.findBySystemNameAndTableNameLike(systemName, '%' + tableName + '%', pageRequest);
		}
	}
}
