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
//        of.set("uname","??????",70, TimeUnit.SECONDS);*/
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
//                System.out.println("??????????????????"+classify);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }*/
//    }
//
//    //????????????????????????
//    @Test
//    void getClassify() throws Exception {
//        //??????????????????
//       /* List<Classify> allClassify = classifyMapper.getAllClassify();
//        for (Classify classify : allClassify) {
//            System.out.println("?????????????????????"+classify);
//        }*/
//
//        //??????????????????????????????
//  /*      List<BrandClassifyRelation> brandIds = brandClassifyRelationMapper.getBrandIds(1l);
//        for (BrandClassifyRelation brandId : brandIds) {
//            System.out.println("??????id???1?????????id???"+brandId);
//        }
//        //??????????????????
//        List<Brand> brandList = brandMapper.getBrandList(brandIds);
//        for (Brand brand : brandList) {
//            System.out.println("??????id???1????????????"+brand);
//        }*/
//
//        //????????????id???1?????????id???1????????????
//        /*List<Model> model = modelMapper.getModel(1l, 1l);
//        for (Model model1 : model) {
//            System.out.println("????????????id???1?????????id???1????????????"+model1);
//        }*/
//
//        List<ClassifyDTO> classifyList = classifyService.selectClassifyList();
//
//        for (ClassifyDTO classify : classifyList) {
//            System.out.println("?????????"+classify);
//            List<BrandDTO> brandList = classify.getBrandList();
//            for (BrandDTO brand : brandList) {
//                System.out.println("?????????"+brand);
//                List<ModelDTO> modelList = brand.getModelList();
//                for (ModelDTO model : modelList) {
//                    System.out.println("?????????"+model);
//                }
//            }
//        }
//    }
//
//    //??????????????????
//    @Test
//    void queryModel() throws Exception {
//        /*int count = modelMapper.getCount();
//        List<ModelDTO> modelPag = modelMapper.getModelPag(new Model(), 0, 5);
//        System.out.println("????????????"+count);
//        for (ModelDTO modelDTO : modelPag) {
//            System.out.println("????????????????????????"+modelDTO);
//        }*/
//        Model model = new Model();
//        model.setModelName("???");
//        PageBean<ModelDTO> pag = modelService.getPag(model, 1, 5);
//        System.out.println("???????????????"+pag);
//
//    }
//
//    //????????????id????????????????????????
//    @Test
//    void queryModelById(){
//        Model model = modelMapper.selectByPrimaryKey(3l);
//        ModelDTO modelDTO=new ModelDTO();
//        //??????????????????????????????
//        BeanUtils.copyProperties(model,modelDTO);
//        logger.info("????????????????????????{}",modelDTO);
//    }
//
//    @Test
//    void queryModelById_() throws Exception {
//       // System.out.println(qQproperties.getLogin_url());
//        List<Malfunction> specList = evaluateService.getSpecList(1l);
//        for (Malfunction malfunction : specList) {
//            System.out.println("?????????1???????????????"+malfunction);
//            List<MalfunctionOptions> optionsList = malfunction.getOptionsList();
//            for (MalfunctionOptions options : optionsList) {
//                System.out.println("?????????1??????????????????"+options);
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
//        System.out.println("???????????????"+assess);
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
//        System.out.println("????????????"+evaluate);
//        System.out.println("???????????????"+evaluate.getModel());
//        for (EvaluateDetail detail : evaluateDetails) {
//            System.out.println("????????????"+detail);
//        }
//    }



}
