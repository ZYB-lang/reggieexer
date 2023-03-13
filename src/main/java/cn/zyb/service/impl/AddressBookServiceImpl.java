package cn.zyb.service.impl;

import cn.zyb.entity.AddressBook;
import cn.zyb.mapper.AddressBookMapper;
import cn.zyb.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
