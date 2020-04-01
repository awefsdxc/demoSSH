var url = '/datasource';
// 数据表表单
var form = {
	tableName: '',
	systemName: '',
	tableNameZw: '',
	dataType: '',
	datasourceDesc: '',
	columns: [
		{ key: '', name: '', nameZw: '', comment: '', type: '', isNull: "1" }
	]
}
// 表单校验 
var rules = {
	systemName: [{ required: true, message: '请选择应用系统', trigger: 'change' }],
	tableName: [{ required: true, message: '请输入表名', trigger: 'change' }],
	tableNameZw: [{ required: true, message: '请输入中文表名', trigger: 'change' }],
	dataType: [{ required: true, message: '请选择数据类型', trigger: 'change' }]
}
// 查询表单
var queryForm = {
	systemName: '',
	tableName: ''
}
// 数据表格
var tableData = []

var ex = new Vue({
	el: '#app',
	data: {
		form: form,
		queryForm: queryForm,
		tableData: tableData,
		loading: false,
		rules: rules
	},
	methods: {
		onSubmit: function () {
			this.$refs['form'].validate((valid) => {
				if (valid) {
					axios.post(url, form)
						.then(function (response) {
							console.log(response);
						})
						.catch(function (error) {
							console.log(response);
						})
				} else {
					console.log('error submit!!');
					return false;
				}
			});
		},
		onQuery: function () {
			axios.get(url, queryForm)
				.then(function (response) {
					ex.tableData = response.data
				})
				.catch(function (error) {
					console.log(error);
				})
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		},
		removeColumn(item) {
			var index = this.form.columns.indexOf(item)
			if (index !== -1 && this.form.columns.length !== 1) {
				this.form.columns.splice(index, 1)
			}
		},
		addColumn(item) {
			var index = this.form.columns.indexOf(item)
			this.form.columns.splice(index + 1, 0, { key: Date.now(), name: '', nameZw: '', comment: '', type: '', isNull: "1" })
		},
		onTableDbl: function (row, column, event) {
			if (!row.columns) {
				row.columns = [{ key: '', name: '', nameZw: '', comment: '', type: '', isNull: "1" }]
			}
			// ex.form = Object.assign({}, row)	// columns 可能有问题
			ex.form = JSON.parse(JSON.stringify(row))
		}
	}
})