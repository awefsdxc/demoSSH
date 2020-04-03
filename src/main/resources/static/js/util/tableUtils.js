var tableUtils = {
	/**
	* 通过value找到在列表中对应的名字
	* @param {Object} obj
	*  @param obj.dataList 数据列表
	*  @param obj.value    数据的值对应的字段名称   例如 'value'
	*  @param obj.label    数据的说明对应的字段名称 例如 'label'
	*  @param obj.data     当前传入的数据值
	* @return name        返回当前传入值在数组中对应的名字
	*/
	getDataName : (obj) => {
		let name = obj.data
		if (Array.isArray(obj.dataList) && obj.dataList.length > 0) {
			for (let i = 0; i < obj.dataList.length; i++) {
				if (obj.dataList[i][obj.value] == obj.data) {
					name = obj.dataList[i][obj.label]
				}
			}
		}
		return name
	}
}