package com.huitong.web.controller.system;

import java.util.*;
import java.util.stream.Collectors;
import com.huitong.common.annotation.Decrypt;
import com.huitong.common.annotation.Encrypt;
import com.huitong.common.config.HuiTongConfig;
import com.huitong.common.utils.*;
import com.huitong.common.utils.file.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.huitong.common.annotation.Log;
import com.huitong.common.constant.UserConstants;
import com.huitong.common.core.controller.BaseController;
import com.huitong.common.core.domain.AjaxResult;
import com.huitong.common.core.domain.Ztree;
import com.huitong.common.core.domain.entity.SysDept;
import com.huitong.common.core.domain.entity.SysRole;
import com.huitong.common.core.domain.entity.SysUser;
import com.huitong.common.core.page.TableDataInfo;
import com.huitong.common.core.text.Convert;
import com.huitong.common.enums.BusinessType;
import com.huitong.common.utils.poi.ExcelUtil;
import com.huitong.framework.shiro.service.SysPasswordService;
import com.huitong.framework.shiro.util.AuthorizationUtils;
import com.huitong.system.service.ISysDeptService;
import com.huitong.system.service.ISysRoleService;
import com.huitong.system.service.ISysUserService;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息
 * 
 * 
 */
@Controller
@RequestMapping("/system/user")
public class SysUserController extends BaseController
{
    private String prefix = "system/user";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;
    
    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private SysPasswordService passwordService;


    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody SysUser user)
    {
        startPage(user.getPageNum(),user.getPageSize());
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody SysUser user)
    {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "用户数据");
    }

    /**
     * 导出zip加密
     * @param user
     * @param response
     * @throws Exception
     */
   @GetMapping("/exportZip")
   public void exportZip(SysUser user, HttpServletResponse response) throws Exception{
       List<SysUser> list = userService.selectUserList(user);
       ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
       AjaxResult ajaxResult =  util.exportExcel(list, "用户数据");
       String fileName= ajaxResult.get("msg").toString();//获取文件下载名称
       if (!FileUtils.checkAllowDownload(fileName))
       {
           throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
       }
       String filePath = HuiTongConfig.getDownloadPath() + fileName;
       if(StringUtils.isNotEmpty(filePath)){
           FileZipUtil.zipFile(filePath,"用户数据"+DateUtils.dateTimeNow(),response);
           //下载完成后， 删除下载的文件
           String docFilePathArry[] = filePath.split(",");
           for (String docFilePath :docFilePathArry) {
               FileUtils.deleteFile(docFilePath);
           }
       }
   }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/exportZip")
    @ResponseBody
    @Decrypt
    public AjaxResult exportZip(@RequestBody SysUser user) throws Exception{
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        AjaxResult ajaxResult =  util.exportExcel(list, "用户数据");
        String fileName= ajaxResult.get("msg").toString();//获取文件下载名称
        if (!FileUtils.checkAllowDownload(fileName))
        {
            throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
        }
        String filePath = HuiTongConfig.getDownloadPath() + fileName;
        String zipFileName = System.currentTimeMillis()+".zip";
        String zipFilePath = HuiTongConfig.getDownloadPath()+zipFileName;
        if(StringUtils.isNotEmpty(filePath)){
            try{
                FileZipUtil.zipFilePwd(filePath,zipFilePath,null);
                FileUtils.deleteFile(filePath);//删除文件
                ajaxResult.put("msg","");
                ajaxResult.put("fileName",zipFileName);
                ajaxResult.put("realFileName","用户数据"+DateUtils.dateTimeNow()+".zip");
            }catch (Exception e){
                ajaxResult.put("code","-1");
                ajaxResult.put("msg",e.getMessage());
                e.printStackTrace();
            }
        }
        return ajaxResult;
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:user:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        String message = userService.importUser(userList, updateSupport, getLoginName());
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:user:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.importTemplateExcel("用户数据");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("roles", roleService.selectRoleAll().stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("system:user:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody SysUser user) throws Exception {
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber())
                && UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        user.setCreateBy(getLoginName());
        return toAjax(userService.insertUser(user));
    }


    /**
     * 修改用户
     */
    @RequiresPermissions("system:user:edit")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        userService.checkUserDataScope(userId);
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        mmap.put("user", userService.selectUserById(userId));
        mmap.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody SysUser user)
    {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(user)))
        {
            return error("修改用户'" + user.getLoginName() + "'失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(user.getPhonenumber())
                && UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return error("修改用户'" + user.getLoginName() + "'失败，手机号码已存在");
        }
        else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user)))
        {
            return error("修改用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        user.setUpdateBy(getLoginName());
        AuthorizationUtils.clearAllCachedAuthorizationInfo();
        return toAjax(userService.updateUser(user));
    }

    @RequiresPermissions("system:user:resetPwd")
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        mmap.put("user", userService.selectUserById(userId));
        return prefix + "/resetPwd";
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(SysUser user)
    {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        if (userService.resetUserPwd(user) > 0)
        {
            if (ShiroUtils.getUserId().longValue() == user.getUserId().longValue())
            {
                setSysUser(userService.selectUserById(user.getUserId()));
            }
            return success();
        }
        return error();
    }

    /**
     * 进入授权角色页
     */
    @GetMapping("/authRole/{userId}")
    public String authRole(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        SysUser user = userService.selectUserById(userId);
        // 获取用户所属的角色列表
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        mmap.put("user", user);
        mmap.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return prefix + "/authRole";
    }

    /**
     * 用户授权角色
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.GRANT)
    @PostMapping("/authRole/insertAuthRole")
    @ResponseBody
    public AjaxResult insertAuthRole(Long userId, Long[] roleIds)
    {
        userService.checkUserDataScope(userId);
        userService.insertUserAuth(userId, roleIds);
        AuthorizationUtils.clearAllCachedAuthorizationInfo();
        return success();
    }

    @RequiresPermissions("system:user:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids)
    {
        if (ArrayUtils.contains(Convert.toLongArray(ids), getUserId())) {
            return error("当前用户不能删除");
        }
        return toAjax(userService.deleteUserByIds(ids));
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(SysUser user)
    {
        return userService.checkLoginNameUnique(user);
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(SysUser user)
    {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(SysUser user)
    {
        return userService.checkEmailUnique(user);
    }

    /**
     * 用户状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:user:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SysUser user)
    {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        return toAjax(userService.changeStatus(user));
    }

    /**
     * 加载部门列表树
     */
    @RequiresPermissions("system:user:list")
    @GetMapping("/deptTreeData")
    @ResponseBody
    public List<Ztree> deptTreeData()
    {
        List<Ztree> ztrees = deptService.selectDeptTree(new SysDept());
        return ztrees;
    }

    /**
     * 选择部门树
     * 
     * @param deptId 部门ID
     */
    @RequiresPermissions("system:user:list")
    @GetMapping("/selectDeptTree/{deptId}")
    public String selectDeptTree(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        mmap.put("dept", deptService.selectDeptById(deptId));
        return prefix + "/deptTree";
    }

    /**
     * 全量重置用户密码
     * @param user1
     * @return
     */
    @GetMapping("/updateAllUserPwd")
    @ResponseBody
    public AjaxResult updateAllUserPwd(SysUser user1)
    {
        List<SysUser> list =  userService.selectUserList(user1);
        String newPassword = "Mrmm@";
        for(SysUser su : list){
            if(!su.getLoginName().equals("@dmin")){
                SysUser user = new SysUser();
                user.setUserId(su.getUserId());
                user.setPassword(passwordService.encryptPassword(su.getLoginName(), newPassword+su.getLoginName()+"9", su.getSalt()));
                int i = userService.resetUserPwd(user);
                System.out.println(i);
            }

        }
        return toAjax(1);
    }
}