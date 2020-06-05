package com.lmy.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程信息表
 * </p>
 *
 * @author lmy
 * @since 2020-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbCourse对象", description="课程信息表")
public class TbCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "学分")
    private Float coursecRedit;

    @ApiModelProperty(value = "学时")
    private Integer coursecTime;

    @ApiModelProperty(value = "课程描述")
    private String courseDesc;

    @ApiModelProperty(value = "上课地点")
    private String courseAddress;

    @ApiModelProperty(value = "容量 人数")
    private Integer courseVolume;

    @ApiModelProperty(value = "教师工号")
    private Long teacherNum;

    @ApiModelProperty(value = "访问数")
    private Integer viewCount;

    @ApiModelProperty(value = "开课时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间时间")
    private Date endTime;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
