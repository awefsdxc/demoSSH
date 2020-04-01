package com.example.demoSSH.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 数据源实体
 */
@Entity
public class Datasource {

	@Id
	@GeneratedValue
	private long id;
	// 应用系统
	private String systemName;
	// 数据类型
	private String dataType;
	// 英文名称
	private String tableName;
	// 中文名称
	private String tableNameZw;
	// 专业（部门）
	private String department;
	// 描述
	private String datasourceDesc;
	
	@Transient
	private Column[] columns;
	
	public Datasource() {
		super();
	}

	public Datasource(long id, String systemName, String dataType, String tableName, String tableNameZw,
			String department, String datasourceDesc) {
		super();
		this.id = id;
		this.systemName = systemName;
		this.dataType = dataType;
		this.tableName = tableName;
		this.tableNameZw = tableNameZw;
		this.department = department;
		this.datasourceDesc = datasourceDesc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableNameZw() {
		return tableNameZw;
	}

	public void setTableNameZw(String tableNameZw) {
		this.tableNameZw = tableNameZw;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDatasourceDesc() {
		return datasourceDesc;
	}

	public void setDatasourceDesc(String datasourceDesc) {
		this.datasourceDesc = datasourceDesc;
	}

	@Override
	public String toString() {
		return "Datasource [id=" + id + ", systemName=" + systemName + ", dataType=" + dataType + ", tableName="
				+ tableName + ", tableNameZw=" + tableNameZw + ", department=" + department + ", datasourceDesc="
				+ datasourceDesc + "]";
	}
	
}
