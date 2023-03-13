package cn.zyb.service.impl;

import cn.zyb.common.CustomException;
import cn.zyb.entity.Category;
import cn.zyb.entity.Dish;
import cn.zyb.entity.Setmeal;
import cn.zyb.mapper.CategoryMapper;
import cn.zyb.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CategoryServiceImpl
 * @Description TODO
 * @Author ZYB
 * @Date 2023/3/6 21:03
 * @Version 1.0
 **/
@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishServiceImpl dishService;
    @Autowired
    private SetmealServiceImpl setmealService;


    @Override
    public void myremove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        long dishcount = dishService.count(dishLambdaQueryWrapper);
        if (dishcount>0){
            throw new CustomException("已关联菜品,不能删除");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        long setmealcount = setmealService.count(setmealLambdaQueryWrapper);
        if (setmealcount>0){
            throw new CustomException("已关联套餐,不能删除");
        }
        super.removeById(id);

    }
}
