package com.abchina.interfacemanager.service;

import com.abchina.interfacemanager.entity.SystemInfo;
import com.abchina.interfacemanager.repository.SystemInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysInfoService {

    @Autowired
    SystemInfoRepository systemInfoRepository;

    public boolean isSystemInfoExists(SystemInfo systemInfo){
        SystemInfo systemInfoQuery = new SystemInfo();
        systemInfoQuery.setSystemNameEN(systemInfo.getSystemNameEN());
        Example<SystemInfo> systemInfoExample = Example.of(systemInfoQuery);
        boolean exists = systemInfoRepository.exists(systemInfoExample);
        return exists;
    }

    public boolean updateSysInfo(SystemInfo systemInfo){
        systemInfoRepository.save(systemInfo);
        return true;
//        boolean systemInfoExists = isSystemInfoExists(systemInfo);
//        if (systemInfoExists){
//            return false;
//        }else {
//            systemInfoRepository.save(systemInfo);
//            return true;
//        }
    }

    public boolean addSysInfo(SystemInfo systemInfo){
        boolean systemInfoExists = isSystemInfoExists(systemInfo);
        if (systemInfoExists){
            return false;
        }else {
            systemInfoRepository.save(systemInfo);
            return true;
        }
    }

    public List<SystemInfo> findAllSysInfo(){
        List<SystemInfo> all = systemInfoRepository.findAll();
        return all;
    }

    public SystemInfo findSysInfoById(String id){
        SystemInfo systemInfo = systemInfoRepository.findById(id).get();
        return systemInfo;
    }

    public String getSysNameById(String id){
        SystemInfo systemInfo = systemInfoRepository.findById(id).get();
        return systemInfo.getSystemName();
    }


    public void deleteSysInfoById(String id){
        systemInfoRepository.deleteById(id);

    }


    public boolean isValid(SystemInfo systemInfo){
        String systemName = systemInfo.getSystemName();
        if(systemName != null && systemName.length() != 0 && !systemName.trim().isEmpty()){
            return false;
        }
        return true;
    }
}
