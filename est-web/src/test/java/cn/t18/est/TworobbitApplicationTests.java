package cn.t18.est;

import cn.t18.est.config.QQproperties;
import cn.t18.est.dto.BrandDTO;
import cn.t18.est.dto.ClassifyDTO;
import cn.t18.est.dto.ModelDTO;
import cn.t18.est.mapper.*;
import cn.t18.est.pojo.*;
import cn.t18.est.service.ClassifyService;
import cn.t18.est.service.ModelService;
import cn.t18.est.service.PayOrderService;
import cn.t18.est.service.impl.EvaluateServiceImpl;
import cn.t18.est.utils.PageBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class TworobbitApplicationTests {

//    Logger logger= LoggerFactory.getLogger(TworobbitApplicationTests.class);
//
//    @Resource
//    private UsersMapper usersMapper;
//
//    @Resource
//   private StringRedisTemplate template;
//
//    @Autowired
//    private ClassifyService classifyService;
//
//    @Resource
//    private BrandClassifyRelationMapper brandClassifyRelationMapper;
//
//    @Resource
//    private BrandMapper brandMapper;
//
//    @Resource
//    private ModelMapper modelMapper;
//
//    @Resource
//    private ModelService modelService;
//
//    @Autowired
//    private QQproperties qQproperties;
//
//    @Autowired
//    private EvaluateServiceImpl evaluateService;
//
//    @Resource
//    private EvaluateMapper evaluateMapper;
//    @Resource
//    EvaluateDetailMapper evaluateDetailMapper;
//
//    @Resource
//    private PayOrderService payOrderService;
//
//    @Test
//    void payTest() throws Exception {
//        String s = payOrderService.selectByOrderNo("2022022816185584430000002101");
//        System.out.println(s);
//    }
//
//
//    @Test
//    void contextLoads() {
//       /* *//*Users users = usersMapper.selectByPrimaryKey(4l);
//        System.out.println("dfdsafd"+users);*//*
//        ValueOperations<String, String> of = template.opsForValue();
//        of.set("uname","小明",70, TimeUnit.SECONDS);*/
//
//    /*    try {
//            List<Classify> classifies = classifyMapper.selectClassifyList();
//            for (Classify classify : classifies) {
//                List<Brand> brandList = classify.getBrandList();
//                for (Brand brand : brandList) {
//                    List<Model> modelList = brand.getModelList();
//                    for (Model model : modelList) {
//                        System.out.println(model);
//                    }
//                    System.out.println(brand);
//                }
//                System.out.println("查询的结果为"+classify);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }*/
//    }
//
//    //测试获取商品列表
//    @Test
//    void getClassify() throws Exception {
//        //获取商品类型
//       /* List<Classify> allClassify = classifyMapper.getAllClassify();
//        for (Classify classify : allClassify) {
//            System.out.println("所有商品类型有"+classify);
//        }*/
//
//        //获取类型与品牌的关系
//  /*      List<BrandClassifyRelation> brandIds = brandClassifyRelationMapper.getBrandIds(1l);
//        for (BrandClassifyRelation brandId : brandIds) {
//            System.out.println("类型id为1的品牌id有"+brandId);
//        }
//        //获取品牌列表
//        List<Brand> brandList = brandMapper.getBrandList(brandIds);
//        for (Brand brand : brandList) {
//            System.out.println("类型id为1的品牌有"+brand);
//        }*/
//
//        //查询类型id为1，品牌id为1的型号有
//        /*List<Model> model = modelMapper.getModel(1l, 1l);
//        for (Model model1 : model) {
//            System.out.println("查询类型id为1，品牌id为1的型号有"+model1);
//        }*/
//
//        List<ClassifyDTO> classifyList = classifyService.selectClassifyList();
//
//        for (ClassifyDTO classify : classifyList) {
//            System.out.println("类别为"+classify);
//            List<BrandDTO> brandList = classify.getBrandList();
//            for (BrandDTO brand : brandList) {
//                System.out.println("品牌有"+brand);
//                List<ModelDTO> modelList = brand.getModelList();
//                for (ModelDTO model : modelList) {
//                    System.out.println("型号有"+model);
//                }
//            }
//        }
//    }
//
//    //测试分页查询
//    @Test
//    void queryModel() throws Exception {
//        /*int count = modelMapper.getCount();
//        List<ModelDTO> modelPag = modelMapper.getModelPag(new Model(), 0, 5);
//        System.out.println("总条数为"+count);
//        for (ModelDTO modelDTO : modelPag) {
//            System.out.println("分页获取的信息有"+modelDTO);
//        }*/
//        Model model = new Model();
//        model.setModelName("华");
//        PageBean<ModelDTO> pag = modelService.getPag(model, 1, 5);
//        System.out.println("查询结果为"+pag);
//
//    }
//
//    //根据型号id获取商品详细信息
//    @Test
//    void queryModelById(){
//        Model model = modelMapper.selectByPrimaryKey(3l);
//        ModelDTO modelDTO=new ModelDTO();
//        //赋值属性到响应的类中
//        BeanUtils.copyProperties(model,modelDTO);
//        logger.info("型号的详细信息：{}",modelDTO);
//    }
//
//    @Test
//    void queryModelById_() throws Exception {
//       // System.out.println(qQproperties.getLogin_url());
//        List<Malfunction> specList = evaluateService.getSpecList(1l);
//        for (Malfunction malfunction : specList) {
//            System.out.println("型号为1的异常信息"+malfunction);
//            List<MalfunctionOptions> optionsList = malfunction.getOptionsList();
//            for (MalfunctionOptions options : optionsList) {
//                System.out.println("型号为1的异常对象有"+options);
//            }
//        }
//    }
//
//    @Test
//    void queryModel_id() throws Exception {
//        Long[] arrays={1L,6L,11L,13L};
//        Users users=new Users();
//        users.setId(19l);
//        Evaluate assess = evaluateService.getAssess(1l, arrays, users);
//        System.out.println("查询的数据"+assess);
//    }
//
//    @Test
//    void queryAssassInfo() throws Exception {
//        Evaluate evaluate = evaluateMapper.selectById(4203l);
//        Long modelId = evaluate.getModelId();
//        Model model = modelMapper.selectModelById(modelId);
//        evaluate.setModel(model);
//        List<EvaluateDetail> evaluateDetails = evaluateDetailMapper.selectByIdEvaluateDetails(evaluate.getId());
//        evaluate.setDetailList(evaluateDetails);
//
//        System.out.println("评估信息"+evaluate);
//        System.out.println("型号信息为"+evaluate.getModel());
//        for (EvaluateDetail detail : evaluateDetails) {
//            System.out.println("详细信息"+detail);
//        }
//    }

}
