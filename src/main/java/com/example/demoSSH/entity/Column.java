package com.example.demoSSH.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据源字段表
 */
@Entity
@Table(name = "datasourceColumn")
public class Column {

	@Id
	@GeneratedValue
	private Long id;
	// 数据源ID
	private Long datasourceId;
	// 名称
	private String name;
	// 中文名
	private String nameZw;
	// 注释
	private String comment;
	// 字段类型
	private String type;
	// 是否为空
	private String isNull;

	public Column() {
		super();
	}

	public Column(Long id, Long datasourceId, String name, String nameZw, String comment, String type, String isNull) {
		super();
		this.id = id;
		this.datasourceId = datasourceId;
		this.name = name;
		this.nameZw = nameZw;
		this.comment = comment;
		this.type = type;
		this.isNull = isNull;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameZw() {
		return nameZw;
	}

	public void setNameZw(String nameZw) {
		this.nameZw = nameZw;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public Long getDatasourceId() {
		return datasourceId;
	}

	public void setDatasourceId(Long datasourceId) {
		this.datasourceId = datasourceId;
	}
	
}
