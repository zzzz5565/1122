package com.huitong.web.controller.monitor;

import java.util.List;

import com.huitong.common.annotation.Decrypt;
import com.huitong.common.annotation.Encrypt;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.huitong.common.annotation.Log;
import com.huitong.common.core.controller.BaseController;
import com.huitong.common.core.domain.AjaxResult;
import com.huitong.common.core.page.TableDataInfo;
import com.huitong.common.core.text.Convert;
import com.huitong.common.enums.BusinessType;
import com.huitong.common.enums.OnlineStatus;
import com.huitong.common.utils.ShiroUtils;
import com.huitong.framework.shiro.session.OnlineSession;
import com.huitong.framework.shiro.session.OnlineSessionDAO;
import com.huitong.system.domain.SysUserOnline;
import com.huitong.system.service.ISysUserOnlineService;

/**
 * 在线用户监控
 * 
 *
 */
@Controller
@RequestMapping("/monitor/online")
public class SysUserOnlineController extends BaseController
{
    private String prefix = "monitor/online";

    @Autowired
    private ISysUserOnlineService userOnlineService;

    @Autowired
    private OnlineSessionDAO onlineSessionDAO;

    @RequiresPermissions("monitor:online:view")
    @GetMapping()
    public String online()
    {
        return prefix + "/online";
    }

    @RequiresPermissions("monitor:online:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody SysUserOnline userOnline)
    {
        startPage(userOnline.getPageNum(),userOnline.getPageSize());
        List<SysUserOnline> list = userOnlineService.selectUserOnlineList(userOnline);
        return getDataTable(list);
    }

    @RequiresPermissions(value = { "monitor:online:batchForceLogout", "monitor:online:forceLogout" }, logical = Logical.OR)
    @Log(title = "在线用户", businessType = BusinessType.FORCE)
    @PostMapping("/batchForceLogout")
    @ResponseBody
    public AjaxResult batchForceLogout(String ids)
    {
        for (String sessionId : Convert.toStrArray(ids))
        {
            SysUserOnline online = userOnlineService.selectOnlineById(sessionId);
            if (online == null)
            {
                return error("用户已下线");
            }
            OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
            if (onlineSession == null)
            {
                return error("用户已下线");
            }
            if (sessionId.equals(ShiroUtils.getSessionId()))
            {
                return error("当前登录用户无法强退");
            }
            onlineSessionDAO.delete(onlineSession);
            online.setStatus(OnlineStatus.off_line);
            userOnlineService.saveOnline(online);
            userOnlineService.removeUserCache(online.getLoginName(), sessionId);
        }
        return success();
    }
}
