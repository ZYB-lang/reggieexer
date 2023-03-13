package cn.zyb.controller;

import cn.zyb.common.R;
import cn.zyb.entity.Category;
import cn.zyb.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author ZYB
 * @Date 2023/3/6 21:05
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    private R<String> save(@RequestBody Category category){
        log.info("category:{}",category);
        categoryService.save(category);
        return R.success("保存菜品分类成功!");
    }
    @GetMapping("/page")
    private R<Page> page(int page,int pageSize){
        log.info("page = {},pageSize = {}",page,pageSize);
        Page<Category> pageinfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByAsc(Category::getSort);
        categoryService.page(pageinfo,lambdaQueryWrapper);
        return R.success(pageinfo);
    }
    @DeleteMapping
    private R<String> delete(Long ids){
        log.info("删除分类:{}",ids);
//        categoryService.removeById(id);
        categoryService.myremove(ids);
        return R.success("删除分类成功");
    }
    @PutMapping
    private  R<String> update(@RequestBody Category category){
        log.info("修改分类信息:{}",category);
        categoryService.updateById(category);
        return R.success("修改分类信息成功");
    }
    @GetMapping("/list")
    private R<List> list(Category category){
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(category.getType()!=null,Category::getType,category.getType());
        lambdaQueryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = categoryService.list(lambdaQueryWrapper);
        return R.success(list);
    }

}
