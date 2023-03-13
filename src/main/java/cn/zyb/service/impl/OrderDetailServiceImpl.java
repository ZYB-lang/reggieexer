package cn.zyb.service.impl;

import cn.zyb.entity.OrderDetail;
import cn.zyb.mapper.OrderDetailMapper;
import cn.zyb.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}