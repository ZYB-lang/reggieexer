package cn.zyb.dto;

import cn.zyb.entity.Setmeal;
import cn.zyb.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
