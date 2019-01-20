package com.xll.upms.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xll.upms.admin.model.entity.SysOauthClientDetails;
import com.xll.upms.admin.service.SysOauthClientDetailsService;
import com.xll.upms.common.util.Query;
import com.xll.upms.common.util.R;
import com.xll.upms.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author 徐亮亮
 * @Description：  客户认证详情信息 前端控制器
 * @Date 2019/1/18 21:35
 */
@RestController
@RequestMapping("/client")
public class OauthClientDetailsController extends BaseController {
    @Autowired
    private SysOauthClientDetailsService sysOauthClientDetailsService;

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysOauthClientDetails
     */
    @GetMapping("/{id}")
    public SysOauthClientDetails get(@PathVariable Integer id) {
        return sysOauthClientDetailsService.selectById(id);
    }


    /**
     * 分页查询信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @RequestMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        return sysOauthClientDetailsService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     *
     * @param sysOauthClientDetails 实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody SysOauthClientDetails sysOauthClientDetails) {
        return new R<>(sysOauthClientDetailsService.insert(sysOauthClientDetails));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable String id) {
        SysOauthClientDetails sysOauthClientDetails = new SysOauthClientDetails();
        sysOauthClientDetails.setClientId(id);
        return new R<>(sysOauthClientDetailsService.deleteById(sysOauthClientDetails));
    }

    /**
     * 编辑
     *
     * @param sysOauthClientDetails 实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody SysOauthClientDetails sysOauthClientDetails) {
        return new R<>(sysOauthClientDetailsService.updateById(sysOauthClientDetails));
    }
}
