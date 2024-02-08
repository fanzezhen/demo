package com.github.fanzezhen.demo.logbiz.model.vo;

import com.github.fanzezhen.demo.logbiz.foundation.entity.LogOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author zezhen.fan
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class LogOperationVo extends LogOperation {
    private List<LogOperationDetailVo> detailVoList;
}
