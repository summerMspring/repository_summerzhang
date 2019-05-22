package com.summer;

import com.fubt.SaasChargeModule.api.copartner.model.Copartner;
import com.fubt.SaasChargeModule.api.copartner.model.CopartnerRole;
import com.fubt.SaasChargeModule.api.copartner.service.CopartnerRoleService;
import com.fubt.SaasChargeModule.api.copartner.service.CopartnerService;
import com.fubt.SaasChargeModule.provider.SaasChargeModuleProviderApplication;
import com.github.pagehelper.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SaasChargeModuleProviderApplication.class)
public class ServiceTest {

    @Autowired
    private CopartnerService copartnerService;

    @Autowired
    private CopartnerRoleService copartnerRoleService;

    @Test
    public void test1(){
        Copartner pa = copartnerService.findById(new Long(2));
        System.out.println(pa);
    }

    @Test
    public void test2(){
        //List<Copartner> copartners = copartnerService.pageQuery(new Long(2), new Long(2));

        Map searchMap = new HashMap();
        searchMap.put("roleId","2");
        searchMap.put("startTime","2019-05-18 21:58:52");
        searchMap.put("endTime","2019-05-22 21:58:52");
        Page<Copartner> page = (Page<Copartner>) copartnerService.pageQuery(searchMap);
        System.out.println("total: "+page.getTotal()+"aaaaaaaaaaaa");
        List<Copartner> result = page.getResult();
        for (Copartner copartner : result) {
            Date startTime = copartner.getStartTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM:dd HH:mm:ss");
            String format="";
            if(startTime!=null){
                format = simpleDateFormat.format(startTime);
            }

            System.out.println(copartner.getRoleId()+"aaaaaa"+format);
        }
//        System.out.println(result+"aaaaaaa");
    }

    @Test
    public void test3(){
        List<Copartner> partnerList = copartnerService.findByInviteId(new Long(23));
        System.out.println(partnerList);
    }

    @Test
    public void test4(){
        BigDecimal b1 = new BigDecimal(1.10);
        BigDecimal b2 = new BigDecimal(1.00000);
        int i = b1.compareTo(b2);
        System.out.println(i);
    }

    @Test
    public void test5(){
        //Long id = idWorkerService.generatorId();
        copartnerRoleService.save(new CopartnerRole());
       // System.out.println(id+"aaaaaaaaaaaaaaaa");
    }


}
