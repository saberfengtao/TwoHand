package com.ft.controller;

import com.ft.entity.Admin;
import com.ft.entity.Authority;
import com.ft.entity.Role;
import com.ft.entity.User;
import com.ft.exceprion.CustomException;
import com.ft.service.AdminService;
import com.ft.service.AuthoService;
import com.ft.service.RoleService;
import com.ft.service.UserService;
import com.ft.utils.ImageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/system")
public class SystemController {
    @Resource
    RoleService roleService;

    @Resource
    AdminService adminService;

    @Resource
    UserService userService;

    @Resource
    AuthoService authoService;

    /**
     * 修改个人密码
     * @param admin
     * @param model
     * @return
     */
    @RequestMapping("/updUserByAdminId")
    public String updUserByAdminId(Admin admin,Model model) {
        if (adminService.updUserByAdminId(admin)){
            //更改成功执行退出登录
            return "redirect:/logoutUpd";
        }
        model.addAttribute("msg","修改信息失败！");
        return "error";
    }



    /**
     * 添加用户（管理员）
     * @param model
     * @return
     */
    @RequestMapping(value="/addUser",method = RequestMethod.GET)
    public String addUser(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles",roles);
        return "system/admin/addUser";
    }

    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public String addUser(Admin admin, String[] role, Model model) {
        int result = adminService.addUser(admin,role);
        if(result>0) {
            model.addAttribute("msg", "添加用户成功");
            return "success";
        }else {
            model.addAttribute("msg","添加用户失败");
        }
        return "error";
    }

    /**
     * 添加角色
     * @param model
     * @return
     */
    @RequestMapping(value="/addRole",method = RequestMethod.GET)
    public String addRole(Model model) {
        List<Authority> authorityList = authoService.getAllAuthorities();
        model.addAttribute("authorities",authorityList);
        return "system/admin/addRole";
    }

  @RequestMapping(value="/addRole",method = RequestMethod.POST)
    public String addRole(String roleName,String[] perms,Model model) {
      System.out.println(roleName);
        if(roleService.addRole(roleName)){
           if (roleService.addRoleAuthority(roleName,perms)){
               model.addAttribute("msg", "角色添加成功");
               return "success";
               }
        }
        return "error";
    }

    /**
     * 角色管理
     * @param model
     * @return
     */
    @RequestMapping("/roleManage")
    public String roleManage(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles",roles);
        return "system/admin/roleManage";
    }

    /**
     * 用户管理
     * @param model
     * @return
     */
    @RequestMapping("/userManage")
    public String userManage(Model model) {
        List<Admin> admins = adminService.getAllUsers();
        model.addAttribute("admins",admins);
        return "system/admin/userManage";
    }


    /**
     * 角色更改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/updRole", method = RequestMethod.GET)
    public String updRole(int id,Model model) {
        List<Authority> authorityList = authoService.getAllAuthorities();
        Role role = roleService.getRoleById(id);
        List<Authority> list = role.getAuthorityList();
        //判断该角色有哪些权限，并把权限设置在权限集合的每个isSelected属性上
        try {
            for (Authority authority:authorityList) {
                for(Authority authority1 : list) {
                    if(authority.getAuthoName().equals(authority1.getAuthoName())) {
                        System.out.println("查出来："+authority1.getAuthoName());
                        authority.setSelected(true);
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            model.addAttribute("authorities",authorityList);
            model.addAttribute("role",role);
            return "system/admin/updRole";
        }
        model.addAttribute("authorities",authorityList);
        model.addAttribute("role",role);
        return "system/admin/updRole";
    }

    @RequestMapping(value = "/updRole", method = RequestMethod.POST)
    public String updRole(Role role,String[] perms,Model model) {
        try {
            roleService.updRole(role,perms);
        }catch (CustomException ex) {
            model.addAttribute("msg","该角色已经存在");
            return "error";
        }catch (Exception ex) {
            ex.printStackTrace();
            model.addAttribute("msg","出现未知错误");
            return "error";
        }
        model.addAttribute("msg","修改角色成功");
        return "success";
    }

    /**
     * 用户更改（管理员）
     * @param adminId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updUser", method = RequestMethod.GET)
    public String updUser(int adminId,Model model) {
        List<Role> roleList = roleService.getAllRoles();
        Admin admin =adminService.getAdminByAdminId(adminId);
        List<Role> list = admin.getRoleList();

        //判断该角色有哪些权限，并把权限设置在权限集合的每个isSelected属性上
        try {
            for (Role role:roleList) {
                for(Role role1 : list) {
                    if(role.getRoleName().equals(role1.getRoleName())) {
                        System.out.println("查出来："+role1.getRoleName());
                        role.setSelected(true);
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            model.addAttribute("roles",roleList);
            model.addAttribute("admin",admin);
          return "system/admin/updUser";
        }
            model.addAttribute("roles",roleList);
            model.addAttribute("admin",admin);
          return "system/admin/updUser";
    }

    @RequestMapping(value = "/updUser", method = RequestMethod.POST)
    public String updUser(Admin admin,String[] roles,Model model) {
        try {
            adminService.updRole(admin,roles);
        }catch (CustomException ex) {
            model.addAttribute("msg","该已经存在");
            return "error";
        }catch (Exception ex) {
            ex.printStackTrace();
            model.addAttribute("msg","出现未知错误");
            return "error";
        }
        model.addAttribute("msg","修改角色成功");
        return "success";
    }

    //-----------------------下面为用户的system操作------------------------------------------>


    @RequestMapping("/updUserPassByUserId")
    public String updUserPassByUserId(User user,Model model) {
        if (userService.updUserPassByUserId(user)){
            //更改成功执行退出登录
            return "redirect:/logoutUptUser";
        }
        model.addAttribute("msg","修改信息失败！");
        return "error";
    }

    @RequestMapping("/updUserMessageByUserId")
    public String updUserMessageByUserId(HttpServletRequest request, MultipartFile userFilePath, User user, Model model) {
       String userPhoto;
        System.out.println("得到的图片路径"+userFilePath);
        try {
            //ImageUtils为之前添加的工具类
            userPhoto = ImageUtils.upload(request, userFilePath);
            if (userPhoto != null) {
                // 将上传图片的地址封装到实体类
                user.setUserPhoto(userPhoto);
                if (userService.updUserMessageByUserId(user)){
                    model.addAttribute("msg","修改信息成功");
                    return "success";
                }
                return "error";
            } else {

                if (userService.updUserMessageByUserId(user)){
                    model.addAttribute("msg","修改信息成功");
                    return "success";
                }
                return "error";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }
      /*  if (userService.updUserMessageByUserId(user)){
            //更改成功执行退出登录
            return "redirect:/goUserHome";
        }*/
        model.addAttribute("msg","修改信息失败！");
        return "error";
    }
}
