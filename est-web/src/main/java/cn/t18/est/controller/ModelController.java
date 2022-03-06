package cn.t18.est.controller;

import cn.t18.est.constants.Result_CodeInfo;
import cn.t18.est.dto.ModelDTO;
import cn.t18.est.dto.Result;
import cn.t18.est.pojo.Model;
import cn.t18.est.service.ModelService;
import cn.t18.est.utils.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 商品型号控制层
 */
@Api(tags = {"这是一个商品型号的接口"})
@RestController
public class ModelController {

    @Resource
    private ModelService modelService;

    @ApiOperation("商品型号分页查询的方法")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "model",value = "查询的条件"),
                    @ApiImplicitParam(name = "pagNo",value = "页码"),
                    @ApiImplicitParam(name = "pagSize",value = "页面大小")
            }
    )
    @GetMapping("/api/model/search")
    public Result search(Model model,Integer pagNo,Integer pagSize) throws Exception {
        PageBean<ModelDTO> pag = modelService.getPag(model, pagNo, pagSize);
        return Result.success(Result_CodeInfo.ERROR_CODE,Result_CodeInfo.SUCCESS_MSG,pag);
    }

    @ApiOperation("根据id查询型号的详细信息")
    @ApiImplicitParam(name = "id",value = "查询的id")
    @GetMapping("/api/model/{id}/detai")
    public Result queryModelById(@PathVariable("id") Integer id)throws Exception{
        ModelDTO modelDTO = modelService.queryModelById(new Long(id));
        return Result.success(Result_CodeInfo.ERROR_CODE,Result_CodeInfo.SUCCESS_MSG,modelDTO);
    }

}
