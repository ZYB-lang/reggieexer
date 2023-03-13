package cn.zyb.service.impl;

import cn.zyb.entity.ShoppingCart;
import cn.zyb.mapper.ShoppingCartMapper;
import cn.zyb.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
