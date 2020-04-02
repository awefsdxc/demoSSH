package com.example.demoSSH.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoSSH.entity.Datasource;

public interface DataSourceDao extends JpaRepository<Datasource, Long>{
	
	List<Datasource> findBySystemName(String systemName);
	
	List<Datasource> findBySystemNameAndTableNameLike(String systemName, String tableName);

}
