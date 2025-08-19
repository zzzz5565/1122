package com.huitong.web.controller.system;

import java.util.List;
import com.huitong.common.annotation.Decrypt;
import com.huitong.common.annotation.Encrypt;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.huitong.common.annotation.Log;
import com.huitong.common.constant.UserConstants;
import com.huitong.common.core.controller.BaseController;
import com.huitong.common.core.domain.AjaxResult;
import com.huitong.common.core.domain.Ztree;
import com.huitong.common.core.domain.entity.SysMenu;
import com.huitong.common.core.domain.entity.SysRole;
import com.huitong.common.enums.BusinessType;
import com.huitong.common.utils.ShiroUtils;
import com.huitong.framework.shiro.util.AuthorizationUtils;
import com.huitong.system.service.ISysMenuService;

/**
 * 菜单信息
 * 
 *
 */
@Controller
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController
{
    private String prefix = "system/menu";

    @Autowired
    private ISysMenuService menuService;

    @RequiresPermissions("system:menu:view")
    @GetMapping()
    public String menu()
    {
        return prefix + "/menu";
    }

    @RequiresPermissions("system:menu:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public List<SysMenu> list(@RequestBody(required = false) SysMenu menu)
    {
        Long userId = ShiroUtils.getUserId();
        List<SysMenu> menuList = menuService.selectMenuList(menu, userId);
        return menuList;
    }

    /**
     * 删除菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:menu:remove")
    @DeleteMapping("/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody Long id)
    {
        if (menuService.selectCountMenuByParentId(id) > 0)
        {
            return AjaxResult.warn("存在子菜单,不允许删除");
        }
        if (menuService.selectCountRoleMenuByMenuId(id) > 0)
        {
            return AjaxResult.warn("菜单已分配,不允许删除");
        }
        AuthorizationUtils.clearAllCachedAuthorizationInfo();
        return toAjax(menuService.deleteMenuById(id));
    }

    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        SysMenu menu = null;
        if (0L != parentId)
        {
            menu = menuService.selectMenuById(parentId);
        }
        else
        {
            menu = new SysMenu();
            menu.setMenuId(0L);
            menu.setMenuName("主目录");
        }
        mmap.put("menu", menu);
        return prefix + "/add";
    }

    /**
     * 新增保存菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:menu:add")
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody @Validated SysMenu menu)
    {
        if (UserConstants.MENU_NAME_NOT_UNIQUE.equals(menuService.checkMenuNameUnique(menu)))
        {
            return error("新增菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }
        menu.setCreateBy(getLoginName());
        AuthorizationUtils.clearAllCachedAuthorizationInfo();
        return toAjax(menuService.insertMenu(menu));
    }

    /**
     * 修改菜单
     */
    @RequiresPermissions("system:menu:edit")
    @GetMapping("/edit/{menuId}")
    public String edit(@PathVariable("menuId") Long menuId, ModelMap mmap)
    {
        mmap.put("menu", menuService.selectMenuById(menuId));
        return prefix + "/edit";
    }

    /**
     * 修改保存菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:menu:edit")
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody @Validated SysMenu menu)
    {
        if (UserConstants.MENU_NAME_NOT_UNIQUE.equals(menuService.checkMenuNameUnique(menu)))
        {
            return error("修改菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }
        menu.setUpdateBy(getLoginName());
        AuthorizationUtils.clearAllCachedAuthorizationInfo();
        return toAjax(menuService.updateMenu(menu));
    }

    /**
     * 选择菜单图标
     */
    @GetMapping("/icon")
    public String icon()
    {
        return prefix + "/icon";
    }

    /**
     * 校验菜单名称
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(SysMenu menu)
    {
        return menuService.checkMenuNameUnique(menu);
    }

    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/roleMenuTreeData")
    @ResponseBody
    public List<Ztree> roleMenuTreeData(SysRole role)
    {
        Long userId = ShiroUtils.getUserId();
        List<Ztree> ztrees = menuService.roleMenuTreeData(role, userId);
        return ztrees;
    }

    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Ztree> menuTreeData()
    {
        Long userId = ShiroUtils.getUserId();
        List<Ztree> ztrees = menuService.menuTreeData(userId);
        return ztrees;
    }

    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree/{menuId}")
    public String selectMenuTree(@PathVariable("menuId") Long menuId, ModelMap mmap)
    {
        mmap.put("menu", menuService.selectMenuById(menuId));
        return prefix + "/tree";
    }
}