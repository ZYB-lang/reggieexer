package cn.zyb.service;

import cn.zyb.dto.DishDto;
import cn.zyb.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @ClassName DishService
 * @Description TODO
 * @Author ZYB
 * @Date 2023/3/6 22:04
 * @Version 1.0
 **/
public interface DishService extends IService<Dish> {
    //新增菜品,同时插入菜品对应的口味数据,需要操作dish dishflavor
    public void saveWithFlavor(DishDto dishDto);

    DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);
}
