package com.mylsaber.console.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 关系
 * </p>
 *
 * @author mylsaber
 * @since 2023-11-22
 */
@TableName("SYS_RELATION")
public class SysRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 对象ID
     */
    private Integer objectId;

    /**
     * 目标ID
     */
    private Integer targetId;

    /**
     * 关系分类
     */
    private Byte category;

    /**
     * 扩展信息
     */
    private String extJson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    @Override
    public String toString() {
        return "SysRelation{" +
            "id = " + id +
            ", objectId = " + objectId +
            ", targetId = " + targetId +
            ", category = " + category +
            ", extJson = " + extJson +
        "}";
    }
}
