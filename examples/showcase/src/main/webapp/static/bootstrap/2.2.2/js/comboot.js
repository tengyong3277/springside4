/**
 * bootstrap公共js
 */

  $(document).ready(function(){
	$('a').bind('focus', function(){   
		if(this.blur){ //如果支持 this.blur   
			this.blur();   
		}   
	});
 });
 
/**
 * 表格checkbox全选全消
 * obj    : 表格中Checkbox
 * tabid : 表格的id
 */
function selectAll(obj, tabid){
	if(obj.checked){
		$('#'+tabid+'').find("input[type=checkbox][name=tabche]").attr("checked", true);
	}else{
		$('#'+tabid+'').find("input[type=checkbox][name=tabche]").attr("checked", false);
	}
}

/**
* 表格选中当前行
* obj         : 当前行
* chename : 复选框的name
*/
function selectTr(obj, chename){
	var chenum = $(obj).find("input[type=checkbox][name="+chename+"][checked]").length;
	if(chenum > 0){
		$(obj).find("input[type=checkbox][name="+chename+"]").attr("checked", false);
	}else{
		$(obj).find("input[type=checkbox][name="+chename+"]").attr("checked", true);
	}
}

/**
* 校验是否是数字
* obj    : 当前对象
* minnum : 最小值
* maxnum : 最大值
*/
function validateNum(obj, minnum, maxnum){
	var temp = obj.value.replace(/[\D]/g,'');
	if(temp == ''){
		obj.value = '';
		return;
	}
	if(temp < minnum){
		obj.value = minnum;
		return;
	}
	if(temp > maxnum){
		obj.value = maxnum;
		return;
	}
	obj.value = temp;
}

/**
* 将要跳转到第page页
* page  : 要转向的页码
* tourl : 要跳转的url地址
*/
function gotoPage(page, formid){
	$('#'+formid+'').find('input[name=page]').val(page);
	$('#'+formid+'').submit();
}

/**
*  禁止输入特殊字符
*/
function banCharacter(val){
	return val.replace(/[\/\\\'\"]/g, '');
}

/**
* 特殊字符替换成实体
*/
function replaceEntity(val){
	return val.replace(/\//g, "&#47;").replace(/\\/g,'&#92;').replace(/\'/g,'&#39;').replace(/\"/g,'&#34;');
}

function naviClick(obj){
	if($(obj).parent().attr('class') != 'active'){
		$(obj).parent().parent().find('li').removeClass();
		$(obj).parent().addClass('active');
	}
}







