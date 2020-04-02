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
		rules: rules,
		currentPage: 1
	},
	methods: {
		onSubmit: function () {
			this.$refs['form'].validate((valid) => {
				if (valid) {
					axios.post(url, ex.form)
						.then(function (response) {
							ex.$message({ message: '保存成功', type: 'success' })
							console.log(response)
							ex.$refs['form'].resetFields()
							ex.onQuery()
						})
						.catch(function (error) {
							console.log(error)
						})
				} else {
					console.log('error submit!!')
					return false
				}
			});
		},
		onQuery: function () {
			axios.get(url + "/query", { params: queryForm })
				.then(function (response) {
					ex.tableData = response.data
				})
				.catch(function (error) {
					console.log(error)
				})
		},
		resetForm(formName) {
			this.$refs[formName].resetFields()
			delete this.form.id
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
			ex.form = JSON.parse(JSON.stringify(row))
		},
		handleClick(row) {
			this.$confirm('此操作无法恢复, 是否继续?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				axios.delete(url + '/' + row.id)
					.then(() => {
						ex.$message({
							message: '删除成功',
							type: 'success'
						});
						ex.onQuery()
					})
					.catch(error => {
						this.$message.error('操作失败，' + error);
					})
			}).catch(() => {
				this.$message({
					type: 'info',
					message: '已取消删除'
				});
			});
		},
		handleSizeChange(val) {
			console.log(`每页 ${val} 条`);
		},
		handleCurrentChange(val) {
			console.log(`当前页: ${val}`);
		}
	}
})