package com.example.javaapi.service;

import com.example.javaapi.common.CommonResult;
import com.example.javaapi.common.GetListParameter;
import com.example.javaapi.dao.AdminRoleRepository;
import com.example.javaapi.dao.MenuRepository;
import com.example.javaapi.model.Admin;
import com.example.javaapi.model.Menu;
import com.example.javaapi.payload.MasterMenu;
import com.example.javaapi.payload.SunMenu;
import com.example.javaapi.security.AdminPrincipal;
import com.example.javaapi.security.CurrentUser;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {




    @Autowired
    private MenuRepository menuRepository;

    public ResponseEntity<?> getMenu(@NotNull AdminPrincipal admin) {

//        Iterable<AdminRole> adminRoles=adminRoleRepository.findAll();

        String[] ids=admin.getSort();

//        List idslist= (List) Arrays.stream(ids);

        List<String> idslist = Arrays.stream(ids).map(x->x).collect(Collectors.toList());


      var menus =(List<Menu>) menuRepository.findAll();

        menus = menus.stream().filter(menu -> menu.getUse() == true).collect(Collectors.toList());

      var pId = menus.stream().filter(menu -> idslist.contains(menu.getId().toString())).map(menu -> menu.getId()).distinct().collect(Collectors.toList());

      var sort = menus.stream().filter(menu -> pId.contains(menu.getpId())).collect(Collectors.toList());

        List<Menu> finalMenus = menus;

//        List<Menu> mytest = menus.stream().map(menu -> {
//            var mymeny=new  Menu();
//           if(finalMenus.stream().filter(x->idslist.contains(x.getpId())&& x.getpId()==menu.getpId() && x.getId()==x.getpId()
//           ).count()==1){
//               mymeny.setName(menu.getName());
//           }
//           return  mymeny;
//
//       }).collect(Collectors.toList());


       List<MasterMenu> masterMenus = new ArrayList<>();

        for (Menu item:menus) {
            var masterMenu = new MasterMenu();
            if(finalMenus.stream().filter(x->idslist.contains(x.getpId())&& x.getpId()==item.getpId() && x.getId()==x.getpId()
            ).count()==1){
                masterMenu.setIcon(item.getIcon());
                masterMenu.setName(item.getName());
                masterMenu.setPathName(item.getPathName());

                masterMenus.add(masterMenu);


                continue;
            }else if(finalMenus.stream().filter(x->idslist.contains(x.getpId())&& x.getId()==x.getpId()
            ).count()==1) {
                continue;
            }

            masterMenu.setIcon(item.getIcon());
            masterMenu.setName(item.getName());
            masterMenu.setPathName(item.getPathName());
            masterMenu.setSunMenus(new ArrayList<SunMenu>());


            var sort1 = finalMenus.stream()

                    .filter(x->x.getId()== item.getId() && x.getId()!=x.getpId() && idslist.contains(x.getId().toString()))
                    .collect(Collectors.toList());
            for (var myitem:sort1
                 ) {
                var subMenu= new SunMenu(myitem.getIcon(),myitem.getName(),myitem.getPathName());
                masterMenu.getSunMenus().add(subMenu);

            }

            masterMenus.add(masterMenu);








        }






        return CommonResult.success(masterMenus);





    }


}
