package com.abchina.interfacemanager.service;

import com.abchina.interfacemanager.entity.InterfaceInfo;
import com.abchina.interfacemanager.entity.InterfaceInfoQuery;
import com.abchina.interfacemanager.entity.ParamInfo;
import com.abchina.interfacemanager.entity.SystemInfo;
import com.abchina.interfacemanager.repository.InterfaceInfoRepository;
import com.abchina.interfacemanager.util.ClassUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class InterfaceInfoService {
    @Autowired
    InterfaceInfoRepository interfaceInfoRepository;
    @Autowired
    SysInfoService sysInfoService;

    public Page<InterfaceInfo> findAllWithPage(Integer currentPage, Integer pageSize){
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.Direction.ASC, "id");
        InterfaceInfo interfaceInfoQuery = new InterfaceInfo();
        interfaceInfoQuery.setDeleteFlag("false");
        Example<InterfaceInfo> interfaceInfoExample = Example.of(interfaceInfoQuery);
        Page<InterfaceInfo> all = interfaceInfoRepository.findAll(interfaceInfoExample, pageable);
        return all;
    }

    public List<InterfaceInfo> findAll(){

        InterfaceInfo interfaceInfoQuery = new InterfaceInfo();
        interfaceInfoQuery.setDeleteFlag("false");
        Example<InterfaceInfo> interfaceInfoExample = Example.of(interfaceInfoQuery);

        List<InterfaceInfo> allinterfaceInfoRepository = interfaceInfoRepository.findAll(interfaceInfoExample);
        //List<InterfaceInfo> all = interfaceInfoRepository.findAll();
        return allinterfaceInfoRepository;
    }

    public void addInterfaceInfo(InterfaceInfo interfaceInfo){
        interfaceInfo.setDataEntryTime(new Date());

        interfaceInfo.setInterfaceSystemName(sysInfoService.getSysNameById(interfaceInfo.getInterfaceSystemNameEN()));
        interfaceInfo.setCallInterfaceSystemName(sysInfoService.getSysNameById(interfaceInfo.getCallInterfaceSystemNameEN()));
        interfaceInfo.setDeleteFlag("false");
        interfaceInfoRepository.save(interfaceInfo);

    }


    public InterfaceInfo getInterfaceInfoById(Integer id){
        InterfaceInfo interfaceInfo = interfaceInfoRepository.findById(id).get();
        return interfaceInfo;

    }

    public void updateInterfaceInfo(InterfaceInfo interfaceInfo){
        if (interfaceInfo.getInterfaceHasParameters().equals("false")){
            interfaceInfo.setInterfaceParameters("");
        }
        if (interfaceInfo.getInterfaceHasReturnedValue().equals("false")){
            interfaceInfo.setInterfaceReturnedValue("");
        }
        interfaceInfo.setInterfaceSystemName(sysInfoService.getSysNameById(interfaceInfo.getInterfaceSystemNameEN()));
        interfaceInfo.setCallInterfaceSystemName(sysInfoService.getSysNameById(interfaceInfo.getCallInterfaceSystemNameEN()));
        interfaceInfo.setDataEntryUpdateTime(new Date());
        interfaceInfo.setDeleteFlag("false");
        interfaceInfoRepository.save(interfaceInfo);
    }

    public void deleteInterfaceInfo(Integer id, String emp){
        InterfaceInfo interfaceInfo = interfaceInfoRepository.findById(id).get();
        interfaceInfo.setDeleteEmp(emp);
        interfaceInfo.setDeleteTime(new Date());
        interfaceInfo.setDeleteFlag("true");
        interfaceInfoRepository.save(interfaceInfo);
    }

    public List<InterfaceInfo> findInterfaceInfoByQuery(InterfaceInfoQuery infoQuery){
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        if (!infoQuery.getInterfaceSysQuery().equals(""))
        interfaceInfo.setInterfaceSystemNameEN(infoQuery.getInterfaceSysQuery());
        if (!infoQuery.getCallInterfaceSysQuery().equals(""))
        interfaceInfo.setCallInterfaceSystemNameEN(infoQuery.getCallInterfaceSysQuery());
        if (!infoQuery.getiSmartQuery().equals(""))
        interfaceInfo.setInterfaceIsCheckInIsmart(infoQuery.getiSmartQuery());
        interfaceInfo.setDeleteFlag("false");
        Example<InterfaceInfo> interfaceInfoExample = Example.of(interfaceInfo);

        List<InterfaceInfo> interfaceInfos = interfaceInfoRepository.findAll(interfaceInfoExample);
        return interfaceInfos;
    }

    public Page<InterfaceInfo> findInterfaceInfoByQueryWithPage(InterfaceInfoQuery infoQuery) {
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        if (infoQuery.getInterfaceSysQuery()!=null &&!infoQuery.getInterfaceSysQuery().equals(""))
            interfaceInfo.setInterfaceSystemNameEN(infoQuery.getInterfaceSysQuery());
        if (infoQuery.getCallInterfaceSysQuery() != null && !infoQuery.getCallInterfaceSysQuery().equals(""))
            interfaceInfo.setCallInterfaceSystemNameEN(infoQuery.getCallInterfaceSysQuery());
        if (infoQuery.getiSmartQuery() != null && !infoQuery.getiSmartQuery().equals(""))
            interfaceInfo.setInterfaceIsCheckInIsmart(infoQuery.getiSmartQuery());
        interfaceInfo.setDeleteFlag("false");
        Example<InterfaceInfo> interfaceInfoExample = Example.of(interfaceInfo);
        Pageable pageable = PageRequest.of(infoQuery.getCurrentPage()-1, infoQuery.getPageSize(), Sort.Direction.ASC, "id");
        Page<InterfaceInfo> all = interfaceInfoRepository.findAll(interfaceInfoExample, pageable);
        return all;
    }



    public boolean downloadInterfaceInfo(InterfaceInfoQuery infoQuery, HttpServletResponse response){

        String[] attributeNames = {"序号", "接口所在系统名称(中文)", "接口所在系统名称(英文)", "接口业务名称", "接口业务描述", "接口业务所属部门",
                "接口业务所属组", "接口业务联系人名称", "接口业务联系人电话", "接口访问地址", "接口方法名称", "接口方法是否需要参数", "接口方法参数",
                "接口是否有返回值", "接口返回值", "调用接口的系统名称(中文)", "调用接口的系统名称(英文)", "调用接口方式", "调用接口频率", "调用接口部门",
                "调用接口组", "调用接口联系人", "调用接口联系电话", "是否纳入iSmart", "是否有白名单", "接口备注", "接口信息录入人", "录入时间",
                "接口信息更新人", "更新时间"};

        List<InterfaceInfo> dataList = findInterfaceInfoByQuery(infoQuery);
        export(response, dataList, attributeNames);

        return true;
    }


    public static void export(HttpServletResponse response, List<?> importList, String[] attributeNames) {
        //获取数据集
        List<?> datalist = importList;

        //声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        //设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 18);

        //获取字段名数组
        String[] tableAttributeName = attributeNames;
        //获取对象属性
        Field[] fields = ClassUtil.getClassAttribute(importList.get(0));
        //获取对象get方法
        List<Method> methodList = ClassUtil.getMethodGet(importList.get(0));

        //循环字段名数组，创建标题行
        Row row = sheet.createRow(0);
        for (int j = 0; j< tableAttributeName.length; j++){
            //创建列
            Cell cell = row.createCell(j);
            //设置单元类型为String
            cell.setCellType(CellType.STRING);
            cell.setCellValue(transCellType(tableAttributeName[j]));
        }
        //创建普通行
        for (int i = 0;i<datalist.size();i++){
            //因为第一行已经用于创建标题行，故从第二行开始创建
            row = sheet.createRow(i+1);
            //如果是第一行就让其为标题行
            Object targetObj = datalist.get(i);
            for (int j = 0;j<fields.length;j++){
                //创建列
                Cell cell = row.createCell(j);
                cell.setCellType(CellType.STRING);
                //
                try {
                    //需要对部分数据进行特殊的处理
                    String methodName = methodList.get(j).getName().toString();
                    Object value = methodList.get(j).invoke(targetObj, new Object[]{});
                    String cellValue = transCellType(value);
                    switch (methodName){
                        case "getInterfaceHasParameters":
                        case "getInterfaceHasReturnedValue":
                        case "getInterfaceIsCheckInIsmart":
                        case "getInterfaceHasWhiteList":
                            if (cellValue.equals("true"))
                                cellValue = "是";
                            else
                                cellValue = "否";
                            break;
                        case "getDeleteFlag":
                        case "getDeleteTime":
                        case "getDeleteEmp":
                            cellValue = "";
                            break;
                        case "getInterfaceParameters":
                        case "getInterfaceReturnedValue":

                            List<ParamInfo> list = JSONObject.parseArray(cellValue, ParamInfo.class);
                            cellValue = "";
                            if (list !=null && list.size() > 0){
                                for (ParamInfo info:list) {
                                    //cellValue += " 名称: ";
                                    cellValue += info.getName();
                                    cellValue += "\r\t";
                                    cellValue += " 类型: ";
                                    cellValue += info.getType();
                                    cellValue += "\r\t";
                                    cellValue += " id: ";
                                    cellValue += info.getId();
                                    cellValue += "\r\t";
                                    cellValue += " 父id: ";
                                    cellValue += info.getPid();
                                    cellValue += "\r\t";
                                    cellValue += " 描述: ";
                                    cellValue += info.getDes();
                                    cellValue += "\r\n";
                                }
                            }
                            default:

                    }
                    cell.setCellValue(cellValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        response.setContentType("application/octet-stream");
        //默认Excel名称
        response.setHeader("Content-Disposition", "attachment;fileName="+"test.xls");

        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String transCellType(Object value){
        String str = null;
        if (value instanceof Date){
            Date date = (Date) value;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            str = sdf.format(date);
        }else{
            str = String.valueOf(value);
            if (str == "null"){
                str = "";
            }
        }

        return str;
    }

}
