package com.lmy.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 选课信息表
 * </p>
 *
 * @author lmy
 * @since 2020-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbStucourse对象", description="选课信息表")
public class TbStucourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学号")
    private Long studentNum;

    @ApiModelProperty(value = "课程号")
    private Long courseNum;

    @ApiModelProperty(value = "教师工号")
    private Long teacherNum;

    @ApiModelProperty(value = "成绩")
    private Integer grade;


}
