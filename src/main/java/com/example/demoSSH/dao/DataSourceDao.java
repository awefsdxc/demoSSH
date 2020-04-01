package com.example.demoSSH.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoSSH.entity.Datasource;

public interface DataSourceDao extends JpaRepository<Datasource, Long>{

}
