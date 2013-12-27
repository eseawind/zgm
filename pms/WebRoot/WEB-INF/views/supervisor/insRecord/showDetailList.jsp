<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>入库货物信息表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link rel="stylesheet" type="text/css" href="${ctx }/css/admin/style.css">
		<link rel="stylesheet" type="text/css" href="${ctx }/css/admin/theme1.css">
		
		<script language="javascript" type="text/javascript" src="${ctx }/js/jquery.js"></script>
		<script type="text/javascript" src="${ctx }/js/date/WdatePicker.js"></script>
		
		<script type="text/javascript">
    		function addDetail(){
				window.location.href = "${ctx}/supervisor/insRecord/addDetail";
			}
			
			function addRecordInfo(){
				window.location.href = "${ctx}/supervisor/insRecord/addRecordInfo";
			}
    	</script>
	
	<style type="text/css">
		.button{
			background: url('${ctx}/images/admin/images/form_blue.gif') repeat-x scroll left top #FFFFFF;
			border: 1px solid #D9E6F0;
		}
	</style>
	
	</head>

	<body>
		<form action="${ctx }/supervisor/insRecord/add" method="post" id="myForm" name="myForm">
			<div align="center" id="content"">
				<div id="box">
					<h3 align="left">
						入库货物信息表
					</h3>
					<div>
						&nbsp;
					</div>
					<br/>
					<table style="text-align: center; font: 12px/ 1.5 tahoma, arial, 宋体;" width="100%">
						<thead>
							<tr>
								<th width="8%">序号</th>
								<th>款式大类</th>
								<th>标明成色</th>
								<th>标明规格重量（kg/件）</th>
								<th>数量（件）</th>
								<th>总重量（kg）</th>
								<th>生产厂家</th>
								<th>检测成色</th>
								<th>检测规格重量（kg/件）</th>
								<th>检测数量（件）</th>
								<th>检测重量（kg）</th>
								<th>检测方法</th>
								<th>标记/备注</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${detailList}" var="insRecordDetail" varStatus="status">
							<tr>
								<td>${status.count}&nbsp;</td>
								<td>${insRecordDetail.style.name}&nbsp;</td>
								<td>${insRecordDetail.pledgePurity.name}&nbsp;</td>
								<td>${insRecordDetail.specWeight}&nbsp;</td>
								<td>${insRecordDetail.amount}&nbsp;</td>
								<td>${insRecordDetail.sumWeight}&nbsp;</td>
								<td>${insRecordDetail.company}&nbsp;</td>
								<td>${insRecordDetail.checkPurity}&nbsp;</td>
								<td>${insRecordDetail.checkSpecWeight}&nbsp;</td>
								<td>${insRecordDetail.checkAmount}&nbsp;</td>
								<td>${insRecordDetail.checkWeight}&nbsp;</td>
								<td>${insRecordDetail.checkMethod.title}&nbsp;</td>
								<td>${insRecordDetail.desc}&nbsp;</td>
								<th>
									<a href="${ctx }/supervisor/insRecord/editDetail/${status.count}">编辑</a>
								</th>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<div align="center" id="pager">
						<input type="button" value="添加货物" class="button" onclick="addDetail()" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="下一步" class="button" onclick="addRecordInfo()" />
					</div>
				</div>
			</div>
		</form>
	</body>
</html>
