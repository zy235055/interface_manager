package com.abchina.interfacemanager.controller;

import com.abchina.interfacemanager.entity.*;
import com.abchina.interfacemanager.service.InterfaceInfoService;
import com.abchina.interfacemanager.service.SysInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class InterfaceInfoController {

    @Autowired
    InterfaceInfoService interfaceInfoService;

    @Autowired
    SysInfoService sysInfoService;

    @GetMapping("/interfaceInfoMain")
    public String getAllInterfaceInfo(Model model){

        List<SystemInfo> all = sysInfoService.findAllSysInfo();
        model.addAttribute("sysInfoList",all);

        Page<InterfaceInfo> allWithPage = interfaceInfoService.findAllWithPage(0, 20);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(allWithPage.getNumber() + 1);
        pageInfo.setPageSize(allWithPage.getSize());
        pageInfo.setTotalPageSize(allWithPage.getTotalPages());
        pageInfo.setTotalElementNum(allWithPage.getTotalElements());
        //Pageable pageable = allWithPage.get

        model.addAttribute("interfaceInfo",allWithPage);
        model.addAttribute("pageInfo",pageInfo);

        return "interfaceInfo/interfaceInfoList";
    }

    @GetMapping("/interfaceInfo")
    public String getInterfaceInfoWithQuery(InterfaceInfoQuery infoQuery, Model model){

        List<SystemInfo> all = sysInfoService.findAllSysInfo();
        model.addAttribute("sysInfoList",all);
        //model.addAttribute("interfaceInfoList",interfaceInfoService.findInterfaceInfoByQuery(infoQuery));
        model.addAttribute("iQuery",infoQuery);

        Page<InterfaceInfo> allWithPage = interfaceInfoService.findInterfaceInfoByQueryWithPage(infoQuery);
        model.addAttribute("interfaceInfo",allWithPage);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(allWithPage.getNumber() + 1);
        pageInfo.setPageSize(allWithPage.getSize());
        pageInfo.setTotalPageSize(allWithPage.getTotalPages());
        pageInfo.setTotalElementNum(allWithPage.getTotalElements());
        model.addAttribute("pageInfo",pageInfo);

        return "interfaceInfo/interfaceInfoList";
    }

    @ResponseBody
    @GetMapping("/interfaceInfoById")
    public InterfaceInfo getInterfaceInfoWithQuery(@RequestParam("id") Integer id){

        InterfaceInfo interfaceInfoById = interfaceInfoService.getInterfaceInfoById(id);
        return interfaceInfoById;
    }


    @GetMapping("/toTestUIPage")
    public String toTestUIPage(){
        return "demo/demoTree2";
    }

    //接口添加页面
    @GetMapping("/toInterfaceInfoAddPage")
    public String toInterfaceInfoAddPage(Model model){
        List<SystemInfo> allSysInfo = sysInfoService.findAllSysInfo();
        model.addAttribute("sysInfoList", allSysInfo);

        return "interfaceInfo/interfaceInfoAdd";
    }

    @PostMapping("/interfaceInfo")
    public String interfaceInfoAdd(InterfaceInfo interfaceInfo, RedirectAttributes redirectAttributes){

        interfaceInfoService.addInterfaceInfo(interfaceInfo);
        redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(true, "添加成功"));

        return "redirect:/interfaceInfoMain";
    }

    @GetMapping("/toInterfaceInfoUpdatePage/{id}")
    public String toInterfaceInfoUpdatePage(@PathVariable("id") Integer id, Model model){
        InterfaceInfo interfaceInfoById = interfaceInfoService.getInterfaceInfoById(id);
        model.addAttribute("iInfo",interfaceInfoById);

        List<SystemInfo> all = sysInfoService.findAllSysInfo();
        model.addAttribute("sysInfoList",all);
        return "interfaceInfo/interfaceInfoUpdateAdd";
    }

    @PutMapping("/interfaceInfo")
    public String interfaceInfoUpdate(InterfaceInfo interfaceInfo, RedirectAttributes redirectAttributes){

        interfaceInfoService.updateInterfaceInfo(interfaceInfo);


        redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(true, "更新成功"));

        return "redirect:/interfaceInfoMain";
    }

    @DeleteMapping("/interfaceInfo")
    public String deleteInterfaceInfo(@RequestParam("id") Integer id,@RequestParam("emp") String emp, RedirectAttributes redirectAttributes){
        interfaceInfoService.deleteInterfaceInfo(id, emp);
        redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(true, "删除成功"));
        return "redirect:/interfaceInfoMain";
    }



    @GetMapping("/downloadInterfaceInfo")
    public void downloadExcel(InterfaceInfoQuery infoQuery, HttpServletResponse response){

        interfaceInfoService.downloadInterfaceInfo(infoQuery, response);
        //调用Excel导出工具类
        //return new SuccessMsg(true,"下载成功");

    }

}
