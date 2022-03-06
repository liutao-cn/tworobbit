package cn.t18.est.controller;

import cn.t18.est.dto.ClassifyDTO;
import cn.t18.est.dto.Result;
import cn.t18.est.pojo.Classify;
import cn.t18.est.service.impl.ClassifyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Api(tags = {"这是一个商品接口"})
@RestController
public class ClassifyController {

    @Autowired
    private ClassifyServiceImpl classifyService;

    @ApiOperation("获取商品列表的方法")
    @GetMapping("/api/home/classifyTree")
     public Result getClassifyForm() throws Exception {
        List<ClassifyDTO> classifyDTOS = classifyService.selectClassifyList();
        return Result.success("0","成功",classifyDTOS);
    }
}
