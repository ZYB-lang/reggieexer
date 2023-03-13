package cn.zyb.service;

import cn.zyb.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @ClassName Category
 * @Description TODO菜品分类Service接口
 * @Author ZYB
 * @Date 2023/3/6 20:58
 * @Version 1.0
 **/
public interface CategoryService extends IService<Category> {
    public void myremove(Long id);
}
