<template>
	<div>
		<el-dialog v-model="formVisible" :title="formTitle" width="50%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" label-width="$template2.back.add.form.base.labelWidth" :rules="rules">
				<el-row>
					<el-col :span="24">
						<el-form-item label="房屋名称" prop="fangwumingcheng">
							<el-input class="list_inp" v-model="form.fangwumingcheng" placeholder="房屋名称"
								 type="text" 								:readonly="!isAdd||disabledForm.fangwumingcheng?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="房屋图片" prop="fangwutupian">
							<uploads
								:disabled="!isAdd||disabledForm.fangwutupian?true:false"
								action="file/upload" 
								tip="请上传房屋图片" 
								:limit="3" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.fangwutupian?form.fangwutupian:''" 
								@change="fangwutupianUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="房屋类型" prop="fangwuleixing">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.fangwuleixing?true:false"
								v-model="form.fangwuleixing" 
								placeholder="请选择房屋类型"
								>
								<el-option v-for="(item,index) in fangwuleixingLists" :label="item"
									:value="item"
									>
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="房屋面积" prop="fangwumianji">
							<el-input class="list_inp" v-model="form.fangwumianji" placeholder="房屋面积"
								 type="text" 								:readonly="!isAdd||disabledForm.fangwumianji?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="房屋地址" prop="fangwudizhi">
							<el-input class="list_inp" v-model="form.fangwudizhi" placeholder="房屋地址"
								 type="text" 								:readonly="!isAdd||disabledForm.fangwudizhi?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="价格/月" prop="chuzujiage">
							<el-input class="list_inp" v-model.number="form.chuzujiage" placeholder="价格/月"
								 type="number" 								:readonly="!isAdd||disabledForm.chuzujiage?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="经纪人账号" prop="jingjirenzhanghao">
							<el-input class="list_inp" v-model="form.jingjirenzhanghao" placeholder="经纪人账号"
								 type="text" 								:readonly="!isAdd||disabledForm.jingjirenzhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="经纪人姓名" prop="jingjirenxingming">
							<el-input class="list_inp" v-model="form.jingjirenxingming" placeholder="经纪人姓名"
								 type="text" 								:readonly="!isAdd||disabledForm.jingjirenxingming?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="状态" prop="zhuangtai">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.zhuangtai?true:false"
								v-model="form.zhuangtai" 
								placeholder="请选择状态"
								>
								<el-option v-for="(item,index) in zhuangtaiLists" :label="item"
									:value="item"
									>
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="房屋介绍" prop="fangwujieshao">
							<editor :value="form.fangwujieshao" placeholder="请输入房屋介绍" :readonly="!isAdd||disabledForm.fangwujieshao?true:false"
								class="list_editor" @change="(e)=>editorChange(e,'fangwujieshao')"></editor>
						</el-form-item>
					</el-col>
				</el-row>
			</el-form>
			<template #footer v-if="isAdd||type=='logistics'||type=='reply'">
				<span class="formModel_btn_box">
					<el-button class="formModel_cancel" @click="closeClick">取消</el-button>
					<el-button class="formModel_confirm" type="primary" @click="save"
						>
						提交
					</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>
<script setup>
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		computed,
		defineEmits
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;	
	const emit = defineEmits(['formModelChange'])
	//基础信息
	const tableName = 'fangyuanchuzu'
	const formName = '房源出租'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
		fangwumingcheng : false,
		fangwutupian : false,
		fangwuleixing : false,
		fangwumianji : false,
		fangwudizhi : false,
		chuzujiage : false,
		fangwujieshao : false,
		jingjirenzhanghao : false,
		jingjirenxingming : false,
		storeupnum : false,
		zhuangtai : false,
	})
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
	//表单验证
	//匹配整数
	const validateIntNumber = (rule, value, callback) => {
		if (!value) {
			callback();
		} else if (!context?.$toolUtil.isIntNumer(value)) {
			callback(new Error("请输入整数"));
		} else {
			callback();
		}
	}
	//匹配数字
	const validateNumber = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isNumber(value)) {
			callback(new Error("请输入数字"));
		} else {
			callback();
		}
	}
	//匹配手机号码
	const validateMobile = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isMobile(value)) {
			callback(new Error("请输入正确的手机号码"));
		} else {
			callback();
		}
	}
	//匹配电话号码
	const validatePhone = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isPhone(value)) {
			callback(new Error("请输入正确的电话号码"));
		} else {
			callback();
		}
	}
	//匹配邮箱
	const validateEmail = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isEmail(value)) {
			callback(new Error("请输入正确的邮箱地址"));
		} else {
			callback();
		}
	}
	//匹配身份证
	const validateIdCard = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.checkIdCard(value)) {
			callback(new Error("请输入正确的身份证号码"));
		} else {
			callback();
		}
	}
	//匹配网站地址
	const validateUrl = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isURL(value)) {
			callback(new Error("请输入正确的URL地址"));
		} else {
			callback();
		}
	}
	const rules = ref({
		fangwumingcheng: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		fangwutupian: [
		],
		fangwuleixing: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		fangwumianji: [
		],
		fangwudizhi: [
		],
		chuzujiage: [
			{required: true,message: '请输入',trigger: 'blur'}, 
			{ validator: validateNumber, trigger: 'blur' },
		],
		fangwujieshao: [
		],
		jingjirenzhanghao: [
		],
		jingjirenxingming: [
		],
		storeupnum: [
			{ validator: validateIntNumber, trigger: 'blur' },
		],
		zhuangtai: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//房屋图片上传回调
	const fangwutupianUploadSuccess=(e)=>{
		form.value.fangwutupian = e
	}
	//房屋类型列表
	const fangwuleixingLists = ref([])
	//状态列表
	const zhuangtaiLists = ref([])
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			fangwumingcheng: '',
			fangwutupian: '',
			fangwuleixing: '',
			fangwumianji: '',
			fangwudizhi: '',
			chuzujiage: '',
			fangwujieshao: '',
			jingjirenzhanghao: '',
			jingjirenxingming: '',
			storeupnum: '0',
			zhuangtai: '未出租',
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			res.data.data.fangwujieshao = res.data.data.fangwujieshao?(res.data.data.fangwujieshao.replace(reg,'../../../cl7459339/file')):'';
			form.value = res.data.data
			formVisible.value = true
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init=(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null)=>{
		resetForm()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
			formTitle.value = '新增' + formName
			formVisible.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			formTitle.value = '查看' + formName
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			formTitle.value = '修改' + formName
			getInfo()
		}else if(formType == 'logistics'){
			isAdd.value = false
			formTitle.value = '修改物流信息'
			getInfo()
		}else if(formType == 'reply'){
			type.value = formType
			isAdd.value = true
			disabledForm.value.cpicture = true
			disabledForm.value.content = true
			formTitle.value = '回复'
			getInfo()
		}else if(formType == 'cross'){
			isAdd.value = true
			formTitle.value = formNames
			// getInfo()
			for(let x in row){
				if(x=='fangwumingcheng'){
					form.value.fangwumingcheng = row[x];
					disabledForm.value.fangwumingcheng = true;
					continue;
				}
				if(x=='fangwutupian'){
					form.value.fangwutupian = row[x];
					disabledForm.value.fangwutupian = true;
					continue;
				}
				if(x=='fangwuleixing'){
					form.value.fangwuleixing = row[x];
					disabledForm.value.fangwuleixing = true;
					continue;
				}
				if(x=='fangwumianji'){
					form.value.fangwumianji = row[x];
					disabledForm.value.fangwumianji = true;
					continue;
				}
				if(x=='fangwudizhi'){
					form.value.fangwudizhi = row[x];
					disabledForm.value.fangwudizhi = true;
					continue;
				}
				if(x=='chuzujiage'){
					form.value.chuzujiage = row[x];
					disabledForm.value.chuzujiage = true;
					continue;
				}
				if(x=='fangwujieshao'){
					form.value.fangwujieshao = row[x];
					disabledForm.value.fangwujieshao = true;
					continue;
				}
				if(x=='jingjirenzhanghao'){
					form.value.jingjirenzhanghao = row[x];
					disabledForm.value.jingjirenzhanghao = true;
					continue;
				}
				if(x=='jingjirenxingming'){
					form.value.jingjirenxingming = row[x];
					disabledForm.value.jingjirenxingming = true;
					continue;
				}
				if(x=='storeupnum'){
					form.value.storeupnum = row[x];
					disabledForm.value.storeupnum = true;
					continue;
				}
				if(x=='zhuangtai'){
					form.value.zhuangtai = row[x];
					disabledForm.value.zhuangtai = true;
					continue;
				}
			}
			if(row){
				crossRow.value = row
			}
			if(table){
				crossTable.value = table
			}
			if(tips){
				crossTips.value = tips
			}
			if(statusColumnName){
				crossColumnName.value = statusColumnName
			}
			if(statusColumnValue){
				crossColumnValue.value = statusColumnValue
			}
			form.value.storeupnum='0'
			form.value.zhuangtai='未出租'
			formVisible.value = true
		}

		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('jingjirenzhanghao')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.jingjirenzhanghao = json.jingjirenzhanghao
				disabledForm.value.jingjirenzhanghao = true;
			}
			if(json.hasOwnProperty('jingjirenxingming')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.jingjirenxingming = json.jingjirenxingming
				disabledForm.value.jingjirenxingming = true;
			}
		})
		context?.$http({
			url: `option/fangwuleixing/fangwuleixing`,
			method: 'get'
		}).then(res=>{
			fangwuleixingLists.value = res.data.data
		})
		zhuangtaiLists.value = "已出租,未出租".split(',')
	}
	//初始化
	//声明父级调用
	defineExpose({
		init
	})
	//关闭
	const closeClick = () => {
		formVisible.value = false
	}
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save=()=>{
		if(form.value.fangwutupian!=null) {
			form.value.fangwutupian = form.value.fangwutupian.replace(new RegExp(context?.$config.url,"g"),"");
		}
		var table = crossTable.value
		var objcross = JSON.parse(JSON.stringify(crossRow.value))
		let crossUserId = ''
		let crossRefId = ''
		let crossOptNum = ''
		if(type.value == 'cross'){
			if(crossColumnName.value!=''){
				if(!crossColumnName.value.startsWith('[')){
					for(let o in objcross){
						if(o == crossColumnName.value){
							objcross[o] = crossColumnValue.value
						}
					}
					//修改跨表数据
					changeCrossData(objcross)
				}else{
					crossUserId = context?.$toolUtil.storageGet('userid')
					crossRefId = objcross['id']
					crossOptNum = crossColumnName.value.replace(/\[/,"").replace(/\]/,"")
				}
			}
		}
		formRef.value.validate((valid)=>{
			if(valid){
				if(crossUserId&&crossRefId){
					form.value.crossuserid = crossUserId
					form.value.crossrefid = crossRefId
					let params = {
						page: 1,
						limit: 1000, 
						crossuserid:form.value.crossuserid,
						crossrefid:form.value.crossrefid,
					}
					context?.$http({
						url: `${tableName}/page`,
						method: 'get', 
						params: params 
					}).then(res=>{
						if(res.data.data.total>=crossOptNum){
							context?.$toolUtil.message(`${crossTips.value}`,'error')
							return false
						}else{
							context?.$http({
								url: `${tableName}/${!form.value.id ? "save" : "update"}`,
								method: 'post', 
								data: form.value 
							}).then(res=>{
								context?.$toolUtil.message(`操作成功`,'success',()=>{
									formVisible.value = false
									emit('formModelChange')
								})
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(res=>{
						context?.$toolUtil.message(`操作成功`,'success',()=>{
							formVisible.value = false
							emit('formModelChange')
						})
					})
				}
			}
		})
	}
	//修改跨表数据
	const changeCrossData=(row)=>{
		context?.$http({
			url: `${crossTable.value}/update`,
			method: 'post',
			data: row
		}).then(res=>{})
	}
</script>
<style lang="scss" scoped>
	// 表单
	.formModel_form{
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 30px;
		margin: 0;
		background: #fff;
		// form item
		:deep(.el-form-item) {
			margin: 0 150px 20px 0;
			background: none;
			display: flex;
			//label
			.el-form-item__label {
			 background: none;
			 font-weight: 500;
			 display: block;
			 width: 150px;
			 min-width: 150px;
			 text-align: right;
			}
			// 内容盒子
			.el-form-item__content {
				display: flex;
				width: calc(100% - 120px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
				// 输入框
				.list_inp {
					border: 1px solid #eee;
					border-radius: 0px;
					padding: 0 10px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 350px;
					height: 36px;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
						padding: 0;
					}
					.is-focus {
						box-shadow: none !important;
					}
				}
				// 下拉框
				.list_sel {
					border: 1px solid #eee;
					border-radius: 0px;
					padding: 0 10px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 350px;
					//去掉默认样式
					.select-trigger{
						height: 100%;
						.el-input{
							height: 100%;
							.el-input__wrapper{
								border: none;
								box-shadow: none;
								background: none;
								border-radius: 0;
								height: 100%;
								padding: 0;
							}
							.is-focus {
								box-shadow: none !important;
							}
						}
					}
				}
				// 富文本
				.list_editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					margin: 0;
					width: auto;
					min-height: 320px;
					border-color: #eee;
					border-width: 1px;
					border-style: solid;
					min-width: 100%;
					height: auto;
				}
				//图片上传样式
				.el-upload-list  {
					//提示语
					.el-upload__tip {
						margin: 7px 0 0;
						color: #999;
						display: flex;
						font-size: 14px;
						justify-content: flex-start;
						align-items: center;
					}
					//外部盒子
					.el-upload--picture-card {
						border: 1px solid #eee;
						cursor: pointer;
						background-color: #fff;
						border-radius: 0px;
						width: 120px;
						line-height: 70px;
						text-align: center;
						height: 60px;
						//图标
						.el-icon{
							color: #ff9900;
							font-size: 32px;
						}
					}
					.el-upload-list__item {
						border: 1px solid #eee;
						cursor: pointer;
						background-color: #fff;
						border-radius: 0px;
						width: 120px;
						line-height: 70px;
						text-align: center;
						height: 60px;
					}
				}
			}
		}
	}
	// 按钮盒子
	.formModel_btn_box {
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: center;
		.formModel_cancel {
			border: 0;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 24px;
			margin: 0 20px 0 0;
			outline: none;
			color: #990033;
			background: #ff990030;
			width: auto;
			font-size: 14px;
			min-width: 100px;
			height: 36px;
		}
		.formModel_cancel:hover {
		}
		
		.formModel_confirm {
			border: 0;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 24px;
			margin: 0 20px 0 0;
			outline: none;
			color: #fff;
			background: #ff9900;
			width: auto;
			font-size: 14px;
			min-width: 100px;
			height: 36px;
		}
		.formModel_confirm:hover {
		}
	}
</style>