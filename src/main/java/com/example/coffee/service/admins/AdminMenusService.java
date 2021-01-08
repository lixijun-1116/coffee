package com.example.coffee.service.admins;

import com.example.coffee.model.dto.AdminMenusDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMenusService {

    List<AdminMenusDto> getMenus(Integer adminType);


}
