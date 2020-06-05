package com.lmy.admin.service;

import com.lmy.admin.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lmy
 * @since 2020-06-05
 */
public interface TbUserService extends IService<TbUser> {

    List<TbUser> selectUserList();
}
