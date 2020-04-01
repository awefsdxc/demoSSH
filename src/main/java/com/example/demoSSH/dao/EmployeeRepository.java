package com.example.demoSSH.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoSSH.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
