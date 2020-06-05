package com.lmy.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmy.admin.entity.TbUser;
import com.lmy.admin.mapper.TbUserMapper;
import com.lmy.admin.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lmy
 * @since 2020-06-05
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {


    @Override
    public List<TbUser> selectUserList() {
        QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
        List<TbUser> userList = baseMapper.selectList(wrapper);
        return userList;
    }
}
