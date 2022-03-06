package cn.t18.est.controller;

import cn.t18.est.dto.Result;
import cn.t18.est.pojo.Evaluate;
import cn.t18.est.pojo.Malfunction;
import cn.t18.est.pojo.Users;
import cn.t18.est.service.impl.EvaluateServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 评估异常控制层
 */
@RestController
public class EvaluateController {

    @Autowired
    private EvaluateServiceImpl evaluateService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 根据商品分类查询评估维度信息
     * @param modelId
     * @return
     * @throws Exception
     */
    @GetMapping("/api/evaluate/specList")
    public Result getSpecList(Long modelId) throws Exception {
        List<Malfunction> specList = evaluateService.getSpecList(modelId);
       return Result.success(specList);
    }

    /**
     * 根据用户选择的故障信息，对商品维修进行评估。
     * @param modelId
     * @param optionIds
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/api/evaluate/assess")
    public Result assess(Long modelId, Long[] optionIds, HttpServletRequest request) throws Exception {
        //从请求头中获取token的值，在从redis中取出token的值
        String userToken = redisTemplate.opsForValue().get(request.getHeader("token"));
        //使用ObjectMapper将userToken字符串转换成user对象
        ObjectMapper om = new ObjectMapper();
        Users users = om.readValue(userToken, Users.class);
        Evaluate assess = evaluateService.getAssess(modelId, optionIds, users);
        return Result.success(assess);
    }



}
