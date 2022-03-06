package cn.t18.est.service.impl;

import cn.t18.est.dto.BrandDTO;
import cn.t18.est.dto.ClassifyDTO;
import cn.t18.est.dto.ModelDTO;
import cn.t18.est.mapper.BrandClassifyRelationMapper;
import cn.t18.est.mapper.BrandMapper;
import cn.t18.est.mapper.ClassifyMapper;
import cn.t18.est.mapper.ModelMapper;
import cn.t18.est.pojo.Brand;
import cn.t18.est.pojo.BrandClassifyRelation;
import cn.t18.est.pojo.Classify;
import cn.t18.est.pojo.Model;
import cn.t18.est.service.ClassifyService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Resource
    private ClassifyMapper classifyMapper;
    @Resource
    private BrandClassifyRelationMapper brandClassifyRelationMapper;
    @Resource
    private BrandMapper brandMapper;
    @Resource
    private ModelMapper modelMapper;
    @Resource
    private RedisTemplate redisTemplate;

    //查询商品列表接口
    @Override
    public List<ClassifyDTO> selectClassifyList() throws Exception {

        //从不是第一次查询时从Redis中获取商品列表
        Object classifyTree = redisTemplate.opsForValue().get("classifyTree");
        if (classifyTree!=null){
            return (List<ClassifyDTO>) classifyTree;
        }

        List<ClassifyDTO> classifyList = getClassifyDTOS();  //调取获取商品列表的方法
        //将查询出的结果存入redis中
        redisTemplate.opsForValue().set("classifyTree",classifyList,1, TimeUnit.HOURS);
        return classifyList;
    }

    /**
     * 获取商品列表的方法
     * @return
     * @throws Exception
     */
    private List<ClassifyDTO> getClassifyDTOS() throws Exception {
        List<ClassifyDTO> classifyList=new ArrayList<>(); //需要返回的对象
        List<Classify> allClassify = classifyMapper.getAllClassify();//获取所有商品类型
        for (Classify classify : allClassify) {
            ClassifyDTO classifyDTO = new ClassifyDTO();
            BeanUtils.copyProperties(classify,classifyDTO);
            classifyList.add(classifyDTO);   //将遍历出的类型添加到集合中
            List<BrandClassifyRelation> brandIds = brandClassifyRelationMapper.getBrandIds(classify.getId());  //根据类型id获取类型与品牌的关系

            getBrand(classify, classifyDTO, brandIds);
        }
        return classifyList;
    }

    /**
     * 获取品牌的方法
     * @param classify
     * @param classifyDTO
     * @param brandIds
     * @throws Exception
     */
    private void getBrand(Classify classify, ClassifyDTO classifyDTO, List<BrandClassifyRelation> brandIds) throws Exception {
        List<Brand> brandList = brandMapper.getBrandList(brandIds);   //根据品牌与类型的关系得到品牌列表

        for (Brand brand : brandList) {   //遍历品牌列表集合
            BrandDTO brandDTO = new BrandDTO();
            BeanUtils.copyProperties(brand,brandDTO);
            classifyDTO.getBrandList().add(brandDTO);    //将品牌添加到类别的品牌列表中

            List<Model> model = modelMapper.getModel(classify.getId(), brand.getId());   //通过类别id和品牌id获取型号列表

            getModel(brandDTO, model);
        }
    }


    /**
     * 获取型号的方法
     * @param brandDTO
     * @param model
     */
    private void getModel(BrandDTO brandDTO, List<Model> model) {
        for (Model model1 : model) {     //遍历型号列表
            ModelDTO modelDTO = new ModelDTO();
            BeanUtils.copyProperties(model1,modelDTO);
            brandDTO.getModelList().add(modelDTO);     //将型号类添加到品牌的型号列表中
        }
    }
}
