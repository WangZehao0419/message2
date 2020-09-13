<%--
  Created by IntelliJ IDEA.
  User: lsn
  Date: 2020/9/1
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <base>
    <title>信息管理</title>
    <meta charset="UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>信息管理</title>
    <link rel="stylesheet" type="text/css" href="../static/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../static/css/IM-index.css"/>
    <script src="../static/js/jquery.js"></script>
    <script src="../static/js/IM-index.js"></script>

    <style>
        html, body {
            height: 100%;
        }
    </style>
</head>

<body>
<a name="top"></a>
<div class="contaner">
    <div class="im-content">
        <div class="im-heade">
            <div class="imhead-title">当前页面：<a>信息管理</a></div>
            <form id="form01" action="/sampleInfo/conditionQuery" method="get">
                <div class="imhead-select">
                    <ul>
                        <li class="bh">
                            <lable>样品编号</lable>
                            <input maxlength="15" onkeyup="this.value=this.value.replace(/\s+/g,'')" id="sampleId"
                                   name="sampleId" value="" type="text">
                        </li>
                        <li class="wrl mright">
                            <lable>污染率</lable>
                            <select name="pollutionRate" id="pollutionRate">
                                <option value="">请选择</option>
                                <option value="0-20">0~20%</option>
                                <option value="20-40">20%~40%</option>
                                <option value="40-60">40%~60%</option>
                                <option value="60-80">60%~80%</option>
                                <option value="80-100">80%~100%</option>
                            </select>
                        </li>
                        <li class="time">
                            <lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间</lable>
                            <input id="qaz" type="hidden">
                            <select name="year" id="year" class="year">
                                <option value="">请选择</option>
                            </select>
                            <span> &nbsp;年</span>
                            <select name="month" id="month" class="month">
                                <option value="">请选择</option>
                            </select>
                            <span> &nbsp;月 </span>
                            <select name="day" id="day" class="day">
                                <option value="">请选择</option>
                            </select>
                            <span>&nbsp; 日</span></li>
                        <li class="w mright yu">
                            <lable>主要污染菌种类</lable>
                            <select name="toxinType" class="mainSpecies" id="toxin_type">
                                <option value="">请选择</option>
                            </select>
                        </li>
                        <li class="w mright yu">
                            <lable>农作物种类</lable>
                            <select name="cropSpecies" class="nzw_spacies" id="crop_species">
                                <option value="">请选择</option>
                            </select>
                        </li>
                        <li class="place w">
                            <lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地点</lable>
                            <select name="province" class="province" id="shen" onchange="findCity(this.value)">
                                <option value="">请选择</option>
                            </select>
                            <span> &nbsp;省</span>

                            <select name="city" class="city" id="shi" onchange="findCounty(this.value)">
                                <option value="">请选择</option>
                            </select>
                            <span> &nbsp;市</span>
                            <select name="county" class="county" id="xian">
                                <option value="">请选择</option>
                            </select>
                            <span> &nbsp;县</span></li>
                    </ul>
                    <div class="soso"><a onclick="realList(1)">搜索</a></div>
                </div>
            </form>
            <div class="oper">
                <ul>
                    <li class="btn-top"><a href="editIM-add.html" class="dt">新增单条</a>
                        <form class="form-b" action="rest/excel/updateExcel" method="post" enctype="multipart/form-data"
                              id="excelForm">
                            <input type="file" name="file" class="file-info-b  file-info-b-1" accept=".xlsx">
                            <a class="xz-btn-b xz-btn-b-1">选择文件</a>
                            <input type="text" name="" id="" value="" class="vall vall-1" readonly>
                            <input class="submit-b" type="button" value="导入样品信息">
                        </form>
                        <a class="mb">下载模板</a> <br>
                        <a class="pl">批量删除</a>
                        <!-- 产毒菌株信息的导入 -->
                        <form class="form-b" action="rest/excel/updateBacterialExcel" method="post"
                              enctype="multipart/form-data" id="excelForm1">
                            <input type="file" name="file" class="file-info-b junzhu-a" accept=".xlsx">
                            <a class="xz-btn-b junzhu-b">选择文件</a>
                            <input type="text" name="" id="flag" value="" class="vall vall-c" readonly>
                            <input class="submit-b submit-c" type="button" value="导入菌株信息">
                        </form>
                        <a href="javascript:exportAll()" class="dc">全部导出</a></li>
                </ul>
            </div>
        </div>
        <div class="im-table">
            <table>
                <thead>
                <tr>
                    <th class="w1"><input type="checkbox" id="checkbox1" value="">
                        全选
                    </th>
                    <th class="w2">样品编号</th>
                    <th class="w3">地点</th>
                    <th class="w4">农产品加工类型</th>
                    <th class="w5">取样时间</th>
                    <th class="w6">录入时间</th>
                    <th class="w7">真菌污染率</th>
                    <th class="w8">主要毒素</th>
                    <th class="w9">操作</th>
                </tr>
                </thead>
                <tbody id="tbody"></tbody>
            </table>
        </div>
        <div class="page"></div>
    </div>
</div>
<!-- <link rel="stylesheet" type="text/css" href="../css/style.css"> -->
<link type="text/css" rel="stylesheet" href="../static/css/paging.css">
<style type="text/css">
    .color a {
        padding: 5px;
        color: #4c4743;
        /* font-size: 20px; */
    }

    .color a:hover {
        color: #ed6c44;
    }

    /* .color2 {
        float: right;
        color: #4c4743;
        font-size: 20px;
        border: 1px black hidden;
    } */

    .color {
        /* 	float: right; */
        border: 1px black hidden;
        width: 100%;
        text-align: center;
    }

    #checkOne {
        color: #000;
        font-size: 20px;
    }

    #checkOnediv {
        color: #ed6c44;

    }

    /* #h1 {
        color: #4c4743;
    } */
</style>
<div class="im-page">
    <ul id="pageUtil"></ul>
</div>
<script type="text/javascript" src="../static/js/jquery1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="../static/js/browsing.js"></script>
<script type="text/javascript" src="../static/js/linkage4.js"></script>
<script type="text/javascript">
</script>

<script type="text/javascript">
    $(function () {
        // 调用分页查询
        realList();

        // 查询农产品种类
        $.getJSON("/sampleInfo/findCropSpecies", "", function (data) {
            var crop_species = '<option value="">请选择</option>';
            for (var i = 0; i < data.length; i++) {
                crop_species += '<option value = "' + data[i].id + '">' + data[i].cropSpecies + '</option>';
            }
            $("#crop_species").html(crop_species);
        });

        // 查询毒素
        $.getJSON("/sampleInfo/findToxinType", {}, function (data) {
            var toxin_type = '<option value="">请选择</option>';
            for (var i = 0; i < data.length; i++) {
                toxin_type += '<option value = "' + data[i].id + '">' + data[i].toxinType + '</option>';
            }
            $("#toxin_type").html(toxin_type);
        });

        // 查询省
        $.getJSON("/sampleInfo/findProvince", {}, function (data) {
            var province = '<option value="">请选择</option>';
            for (var i = 0; i < data.length; i++) {
                province += '<option value = "' + data[i].code + '">' + data[i].name + '</option>'
            }
            $("#shen").html(province);
            if (shengs != null && shengs != "")
                findCity(shengs);
        });
    });

    function realList(pageNum) {
        // 表单序列化，该方式可获取表单数据。
        var formData = $("#form01").serialize();

        // 设置默认页
        if (pageNum == null || pageNum === '') {
            pageNum = 1
        }
        formData += "&pageNum=" + pageNum;

        // 局部刷新表格数据
        $.ajax({
            url: "/sampleInfo/conditionQueryAsyn",
            type: "get",
            data: formData,
            dataType: "json",
            success: function (data) {
                var list = data.data.result;
                var sampInfo = '';
                // 遍历集合
                for (var i = 0; i < list.length; i++) {
                    // 获取集合中的对象数据
                    var samp = list[i];
                    sampInfo +=
                        '<tr>\n' +
                        '<td><input class="testyangpin" value="' + samp.id + '" type="checkbox"></td>\n' +
                        '<td class="ybbh">' + samp.sampleId + '</td>\n' +
                        '<td>' + samp.addressName + '</td>\n' +
                        '<td>' + samp.cropSpecies + '</td>\n' +
                        '<td>' + samp.samplingTime + '</td>\n' +
                        '<td>' + samp.inputTime + '</td>\n' +
                        '<td>' + samp.pollutionRate + '%</td>\n' +
                        '<td>' + samp.toxinType + '</td>\n' +
                        '<td><a href="editIM.html">编辑</a> |<a\n' +
                        'href="javascript:if(confirm(\'确实要删除吗?\'))location=\'/glory/rest/iddeleteyangpin?id=754\'">删除</a>\n' +
                        '</td>\n' +
                        '</tr>'
                }
                $("#tbody").html(sampInfo);
                var pageUtil = data.data;

                var pagination =
                    '<li class="im-indexpage"><a onclick="realList(1)">首页</a></li>\n' +
                    '<li class="im-nextpage"><a onclick="realList(' + pageUtil.prePage + ')">上一页</a></li>\n' +
                    '<li class="im-nextpage"><a onclick="realList(' + pageUtil.nextPage + ')">下一页</a></li>\n' +
                    '<li class="im-indexpage"><a onclick="realList(' + pageUtil.pages + ')">尾页</a></li>';
                $("#pageUtil").html(pagination);
            }
        });
    }

    // 查询城市
    function findCity(code) {
        $.getJSON("/sampleInfo/findCity", {"provinceCode": code}, function (data) {
            var city = '<option value="">请选择</option>';
            for (var i = 0; i < data.length; i++) {
                city += '<option value = "' + data[i].code + '">' + data[i].name + '</option>'
            }
            $("#shi").html(city);
            if (shi != null && shi != "")
                findCounty(shi);
        });
    }

    // 查询县区
    function findCounty(code) {
        $.getJSON("/sampleInfo/findCounty", {"cityCode": code}, function (data) {
            $("#xian").empty();//清空数据
            var county = '<option value="">请选择</option>';
            for (var i = 0; i < data.length; i++) {
                county += '<option value = "' + data[i].code + '">' + data[i].name + '</option>'
            }
            $("#xian").append(county);
        });
    }

    // 导出全部信息
    function exportAll() {
        // 跳转方式
        location.href = "/sampleInfo/exportAll";
        // ajax方式
    }
</script>
</body>
</html>
