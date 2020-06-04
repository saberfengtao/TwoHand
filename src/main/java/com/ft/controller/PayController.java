package com.ft.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ft.entity.Good;
import com.ft.entity.GoodType;
import com.ft.entity.SaleOrder;
import com.ft.service.GoodService;
import com.ft.service.GoodTypeService;
import com.ft.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class PayController {

    private final String APP_ID = "2016101000655293";
    private final String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC7hOip1Wmo6ukPkfTcJwjit7Yn8SQSZYugyhbh14ppPB0RbIS+EyOD0xEwPheM+FTGTyYtGo5ODNVgCy2rJmOiYQ6n2tsgAilfiv+GATuJjQugLokWki9Fzkcd1ntwUGQ7lTCX8VPQJ1/sSJvp+SWKPWQjhvlPoiUPGyhZjY09QjEHAra0fth9NxLVbJAuC9BYqc+BaECs8+MGKc1TgNaYJsM9//lQjg5rAbaKr9iwWx3WPD57/sSdQ0HDjCJBpi19KwwVW+5LgHuKc3YkOUifhNUDps4x6//IdWRKF6qqaLUlKM+qZp6Kxz/fQOu8od1to5KlFD2YYCnVPvpueCdvAgMBAAECggEBAKWYmqqYV4WfZY+lcloUcqlcWRVuw08ns6WbsZdhc865EmZ3scX1OtDITQ6QVtXb22mBLhJ4uCC+/pOha4QQE76q/XlIMWhT4FuKcVrSrdQr5Y9gaRmwoOSBZJY5+apWpB1mA5K6wCw7CV+tQ1rc9cTdsBgbswEbDKUJc5maApeL36xtYZlyTFjedvILqzAjnzpfN7gJOYn7tCjdlhEX/W9Xa7d3OCgXMal1GXKTmeMu6jWPxOMKARrUEtuXMqnI3lqky1o+7WJg+nOD4GK4cNGDyLdbfzW0P1Uui19poDGqbzptLEBe29qMlKirzCJSsqS9c08UxYm3pNTygiisMDECgYEA62sDieYeMtP/nJ5l8NdABnYZtQ/C1+STqJcmZfqgq+KK/tjjtDnr6l9gPsqBJml2Du9pR1BabLq0d/rGYtfTOl98gTVAGZyju9jDOKlalWyByXs6rb7FwLXVsKoMNBRbSjBs91uWQTnOZJFXGPRbaJgn/xXNGBWnzlguBowvitkCgYEAy+nZ+8vlgKwjCkQN5LF3WsMiGWT8oDuMpGn9UUfWNSR/WfmDZ+PIAEsRE9sSU9pnm0T2HsBRvK86jB/k35/F4e74iA6+G0hMClptk58g8h3qFUyJ1xRGn/2Hj6ViPMNcuDtr0c6+sBsbeiP0w1uPOGH/g+GNKkARk+6W4bUqB4cCgYBb/bgnRZWdVPv4Lmk1QFdTbwjCmMMRa89LPK0TgmkQYXjg9s2bmlqWfeh1ANqQsPsiAOmJpVuAS0DD9WlaLG3szG0xbCZ9G5lbiOtYE81CwGDC43VdeUN691LmMryMCTxW9C9QRSikmjsNT0HSjYG+kF5orhMzixrEZe6uPk9BmQKBgQCoMb7ss3UdWl8Ys6OmFD+3rKauvZ6m6BeM8iPRbGiisvUcmPOruLWakFCIyTVn1wmIiCxelxGUihDHzfLyBY6qWnvDdi2WwV5/V7F0h1gcfVI8uUIlFwNeKjgr4yWRqy8Kg3DewSKGjgVvDMNydE5BGowxEtVmmSwmkjEAAXemdwKBgQDMWHeZ8JpsbIqmLbgs/o1Ns+wpGfqxOWQJuLItUhK8UqV6Seb8FZv1aPgxs1VcXIK3tJMHpj11ow5GB+74Z7Prj0np1rf+wg+B1qCETruBjCw+/AToKlwL2uRzPoSqAIj9SJzNxiLclBHKovNizCQkOfxH/Y3PmXnYH34zKe+Bkg==";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7Yyw3KS4C1IsuHIWa6SKAoyNo+RBAB1p//4l7UkRsCOUasqUZZDQK3QMqihhBmCur5SPrxij/NIWlwkZKomqPpPJXYARyFI5ykxXX6PKf6hoFtQCNQskQ6k3TARsFfkkdLYUpKzuzV19m8X6HxCRa36IuvrnkG4tRLgV1avbWhtmAaMF7TbxfGBiDx2NSnOk0Gp3xJthIL6SUJGpRv62PUfKYN0UHqHPYCMmmPPF0JzU9SJYTRTY9SdSI+G1hb706eDvrq7Vl4Gm0asQ/xLgy/ETydr/xY97wxjGH+OZAHDAJYlP4fJbRJWqhxpa/dgbH6oxq4L1Mx41Ixj9TILsEQIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://公网地址/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost//basic/toTwoHandIndex";

    @Resource
    GoodTypeService goodTypeService;

    @Resource
    GoodService goodService;

    @Resource
    SaleOrderService saleOrderService;
    SaleOrder saleOrder1=new SaleOrder();
    String userId1,goodId1,outUserId1;
    @RequestMapping("/alipay")
    public String alipay(HttpServletResponse httpResponse, String goodIntroduction, SaleOrder saleOrder, String goodName, String userId,String goodId, String outUserId, Model model) throws IOException {

        saleOrder1=saleOrder;
        userId1=userId;
        goodId1=goodId;
        outUserId1=outUserId;
        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        String priceC= String.valueOf(saleOrder.getSoPrice());
        //付款金额，必填
        //String total_amount =Integer.toString(r.nextInt(99)+10);
        //订单名称，必填
        //String subject ="奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
        String body = goodIntroduction;
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ priceC +"\","
                + "\"subject\":\""+ goodName +"\","
                + "\"body\":\""+ goodIntroduction +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();

       /* if (saleOrderService.updSoleOrderBySoIdForFinish(saleOrder,userId,goodId,outUserId)){
            model.addAttribute("msg", "购买成功快去个人中心看看吧");
            return "user/twoHandIndex";
        }*/
        return "error";
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
           // payService.updateById(Integer.valueOf(out_trade_no));
            if (saleOrderService.updSoleOrderBySoIdForFinish(saleOrder1,userId1,goodId1,outUserId1)){

                return "error";
            }
            return "success";//跳转付款成功页面
        }else{
            return "error";//跳转付款失败页面
        }

    }

}


