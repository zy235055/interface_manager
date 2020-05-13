package com.abchina.interfacemanager.controller;

import com.abchina.interfacemanager.entity.SuccessMsg;
import com.abchina.interfacemanager.entity.SystemInfo;
import com.abchina.interfacemanager.repository.SystemInfoRepository;
import com.abchina.interfacemanager.service.SysInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class SystemInfoController {
    @Autowired
    SysInfoService sysInfoService;

    @ResponseBody
    @GetMapping("/systemInfo/{id}")
    public SystemInfo getSystemInfo(@PathVariable("id") String id){
        //Optional<SystemInfo> byId = systemInfoRepository.findById(id);
        SystemInfo systemInfo = sysInfoService.findSysInfoById(id);
        //SystemInfo one = byId.get();
        return systemInfo;
    }


    @GetMapping("/systemInfo")
    public String getAllSystemInfo(Model model){

        List<SystemInfo> all = sysInfoService.findAllSysInfo();
        model.addAttribute("sysInfoList",all);
        //model.addAttribute("sucMsg", new SuccessMsg(true, "成功"));
        return "systemInfo/sysList";
    }

    @GetMapping("/toSysInfoAddPage")
    public String toSysInfoAddPage(){
        return "systemInfo/sysAdd";
    }

    @PostMapping("/systemInfo")
    public String addSysInfo(SystemInfo systemInfo, RedirectAttributes redirectAttributes){
        if(sysInfoService.isValid(systemInfo)){
            redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(false, "信息非法，请重新填写"));
            return "redirect:/toSysInfoAddPage";
        }
        //判断是否有重名
        boolean suc = sysInfoService.addSysInfo(systemInfo);
        if (suc){
            redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(true, "添加成功"));
            return "redirect:/systemInfo";

        }else {
            redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(false, "系统信息已存在"));
            return "redirect:/toSysInfoAddPage";
        }
    }



    @PutMapping("/systemInfo")
    public String updateSysInfo(SystemInfo systemInfo, RedirectAttributes redirectAttributes){
        if(sysInfoService.isValid(systemInfo)){
            redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(false, "信息非法，请重新填写"));
            return "redirect:/toSysInfoEditPage/"+ systemInfo.getSystemNameEN();
        }

        boolean suc = sysInfoService.updateSysInfo(systemInfo);
        if (suc){
            redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(true, "修改成功"));
            return "redirect:/systemInfo";
        }else {
            redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(false, "修改失败，系统信息已存在"));
            return "redirect:/toSysInfoEditPage/"+ systemInfo.getSystemNameEN();
        }


    }

    @DeleteMapping("/systemInfo/{id}")
    public String deleteSysInfo(@PathVariable("id") String id, RedirectAttributes redirectAttributes){
        sysInfoService.deleteSysInfoById(id);
        redirectAttributes.addFlashAttribute("sucMsg", new SuccessMsg(true, "删除成功"));
        return "redirect:/systemInfo";
    }

    @GetMapping("/toSysInfoEditPage/{id}")
    public String toEditPage(@PathVariable("id") String id, Model model){
        SystemInfo systemInfo = sysInfoService.findSysInfoById(id);
        model.addAttribute("systemInfo", systemInfo);
        return "systemInfo/sysAdd";
    }
}
