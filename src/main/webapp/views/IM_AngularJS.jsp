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
    <script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
    <script type="text/javascript">
        <%-- 声明app对象 --%>
        var app = angular.module("IMApp", []);
        <%-- 页面初始化加载，类似js的$() --%>
        app.controller("IMsController", function ($http, $scope) {

            $http({
                url: "/sampleInfo/findToxinType",
                method: "get"
            }).success(function (data) {
                $scope.toxinTypes = data;
            });

            $http({
                url: "/sampleInfo/findCropSpecies",
                method: "get"
            }).success(function (data) {
                $scope.cropSpeciess = data;
            });

            $http({
                url: "/sampleInfo/findProvince",
                method: "get"
            }).success(function (data) {
                $scope.provinces = data;
            });


            $scope.findCity = function () {
                var provinceCode = $scope.pojo.province;
                $http({
                    url: "/sampleInfo/findCity",
                    method: "get",
                    params: {"provinceCode": provinceCode}
                }).success(function (data) {
                    $scope.citys = data;
                });
            };

            $scope.findCounty = function () {
                var cityCode = $scope.pojo.city;
                $http({
                    url: "/sampleInfo/findCounty",
                    method: "get",
                    params: {"cityCode": cityCode}
                }).success(function (data) {
                    $scope.countys = data;
                });
            };

            $scope.pojo = {// 创建空对象
                "pageNum": "",
                "year": "0",
                "month": "0",
                "day": "0"
            };
            $scope.realList = function (pageNum) {
                if (pageNum == null || pageNum === '') {
                    pageNum = 1;
                }
                $scope.pojo.pageNum = pageNum;
                var model = $scope.pojo;
                console.log(model);
                $http({
                    url: "/sampleInfo/conditionQueryAsyn",
                    method: "post",
                    data: model,/*params与data一致，使用哪种方式都可*/
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function (obj) {/*将参数传递进该方法进行处理*/
                        var str = [];/*定义数组，用于保存所处理的数据*/
                        for (var p in obj) {/*遍历对象*/
                            // 向数组添加数据。格式：key=value。key：
                            str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                        }
                        // 将数组转换成字符串并用"&"符号分割
                        return str.join("&");
                    }
                }).success(function (data) {
                    $scope.pageUtil = data.data;
                });
            };

        });


    </script>
</head>

<%-- ng-app当前页只允许一个。ng-controller当前页可允许多个，但唯一 --%>
<body ng-app="IMApp" ng-controller="IMsController" ng-init="realList()">
<a name="top"></a>
<div class="contaner">
    <div class="im-content">
        <div class="im-heade">
            <div class="imhead-title">当前页面：<a>信息管理</a></div>
            <form id="form01" action="/sampleInfo/conditionQuery" method="get">
                <%--<input type="hidden" id="pageNum" name="pageNum" value="">--%>
                <div class="imhead-select">
                    <ul>
                        <li class="bh">
                            <lable>样品编号</lable>
                            <input maxlength="15" onkeyup="this.value=this.value.replace(/\s+/g,'')" id="sampleId"
                                   ng-model="pojo.sampleId" value="" type="text">
                        </li>
                        <li class="wrl mright">
                            <lable>污染率</lable>
                            <select ng-model="pojo.pollutionRate" id="pollutionRate">
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
                            <select name="year" ng-model="pojo.year" id="year" class="year">

                            </select>
                            <span> &nbsp;年</span>
                            <select name="month" ng-model="pojo.month" id="month" class="month">
                                <option value="">请选择</option>
                            </select>
                            <span> &nbsp;月 </span>
                            <select name="day" ng-model="pojo.day" id="day" class="day">
                                <option value="">请选择</option>
                            </select>
                            <span>&nbsp; 日</span></li>
                        <li class="w mright yu">
                            <lable>主要污染菌种类</lable>
                            <select ng-model="pojo.toxinType" class="mainSpecies"
                                    ng-options="toxinType.id as toxinType.toxinType for toxinType in toxinTypes">
                                <option value="">请选择</option>
                            </select>
                        </li>
                        <li class="w mright yu">
                            <lable>农作物种类</lable>
                            <select ng-model="pojo.cropSpecies" class="nzw_spacies">
                                <option value="">请选择</option>
                                <option ng-repeat="crop in cropSpeciess" ng-value="crop.id">{{crop.cropSpecies}}
                                </option>
                            </select>
                        </li>
                        <li class="place w">
                            <lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地点</lable>
                            <select ng-model="pojo.province" class="province" ng-change="findCity()">
                                <option value="">请选择</option>
                                <option ng-repeat="province in provinces" ng-value="province.code">{{province.name}}
                                </option>
                            </select>
                            <span> &nbsp;省</span>

                            <select ng-model="pojo.city" class="city" ng-change="findCounty()">
                                <option value="">请选择</option>
                                <option ng-repeat="city in citys" ng-value="city.code">{{city.name}}</option>
                            </select>
                            <span> &nbsp;市</span>
                            <select ng-model="pojo.county" class="county">
                                <option value="">请选择</option>
                                <option ng-repeat="county in countys" ng-value="county.code">{{ county.name}}</option>
                            </select>
                            <span> &nbsp;县</span></li>
                    </ul>
                    <div class="soso"><a ng-click="realList(1)">搜索</a></div>
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
                        <a href="javascript:void(0)" class="dc">信息导出</a></li>
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
                <tbody>
                <tr ng-repeat="samp in pageUtil.result">
                    <td><input class="testyangpin" ng-value="samp.id" type="checkbox"></td>
                    <td class="ybbh">{{samp.sampleId}}</td>
                    <td>{{samp.addressName}}</td>
                    <td ng-bind="samp.cropSpecies"></td>
                    <td>{{samp.samplingTime}}</td>
                    <td>{{samp.inputTime}}</td>
                    <td>{{samp.pollutionRate}}</td>
                    <td>{{samp.toxinType}}</td>
                    <td><a href="editIM.html">编辑</a> |<a
                            href="javascript:if(confirm('确实要删除吗?'))location='/glory/rest/iddeleteyangpin?id=754'">删除</a>
                    </td>
                </tr>
                </tbody>
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
    <ul>
        <li class="im-indexpage"><a ng-click="realList(1)">首页</a></li>
        <li class="im-nextpage"><a ng-click="realList(pageUtil.prePage)">上一页</a></li>
        <li class="im-nextpage"><a ng-click="realList(pageUtil.nextPage)">下一页</a></li>
        <li class="im-indexpage"><a ng-click="realList(pageUtil.pages)">尾页</a></li>

        <%--<li class="im-nextpage"><a onclick="pages(${pageHelper.prePage})">上一页</a></li>
        <li class="im-nextpage"><a onclick="pages(${pageHelper.nextPage})">下一页</a></li>
        <li class="im-indexpage"><a onclick="pages(${pageHelper.pages})">尾页</a></li>--%>
    </ul>
</div>
<script type="text/javascript" src="../static/js/jquery1.11.3-jquery.min.js"></script>
<script type="text/javascript" src="../static/js/browsing.js"></script>
<script type="text/javascript" src="../static/js/linkage4.js"></script>
</body>
</html>
