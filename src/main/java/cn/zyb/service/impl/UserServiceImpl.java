package cn.zyb.service.impl;

import cn.zyb.entity.User;
import cn.zyb.mapper.UserMapper;
import cn.zyb.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
