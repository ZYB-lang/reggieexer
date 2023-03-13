package cn.zyb.service;

import cn.zyb.dto.SetmealDto;
import cn.zyb.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @ClassName SemealService
 * @Description TODO
 * @Author ZYB
 * @Date 2023/3/6 22:04
 * @Version 1.0
 **/
public interface SetmealService extends IService<Setmeal> {
    void saveWithDish(SetmealDto setmealDto);
}
