package cn.t18.est.controller;

import cn.t18.est.constants.Result_CodeInfo;
import cn.t18.est.dto.Result;
import cn.t18.est.pojo.Evaluate;
import cn.t18.est.service.impl.Evaluate_detailServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 评估信息详情接口
 */
@Api("评估详细信息的接口")
@RestController
public class Evaluate_detailController {

    @Resource
    private Evaluate_detailServiceImpl detailService;

    /**
     * 评估信息详情方法
     * @param id
     * @return
     */
    @ApiOperation("评估详细信息的方法")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id",value = "评估信息id"),
            }
    )
    @GetMapping("/api/evaluate/{id}/assessInfo")
    public Result assessInfo(@PathVariable("id") Long id) throws Exception {
        Evaluate assessInfo = detailService.getAssessInfo(id);
        return Result.success(Result_CodeInfo.SUCCESS_CODE,Result_CodeInfo.SUCCESS_MSG,assessInfo);
    }
}
