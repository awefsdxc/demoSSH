package com.example.demoSSH.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoSSH.entity.Column;

public interface ColumnDao extends JpaRepository<Column, Long>{

}
