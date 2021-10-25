package com.example.xylearn.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;

public class Demo {



    public static void main(String[] args) throws AlipayApiException {
//        //实例化客户端
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
//                APP_ID, APP_PRIVATE_KEY, "json",
//                CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
//        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.open.public.template.message.industry.modify
//        AlipayOpenPublicTemplateMessageIndustryModifyRequest request = new AlipayOpenPublicTemplateMessageIndustryModifyRequest();
//        //SDK已经封装掉了公共参数，这里只需要传入业务参数
//        //此次只是参数展示，未进行字符串转义，实际情况下请转义
//        request.setBizContent("  {" +
//                "    \"primary_industry_name\":\"IT科技/IT软件与服务\"," +
//                "    \"primary_industry_code\":\"10001/20102\"," +
//                "    \"secondary_industry_code\":\"10001/20102\"," +
//                "    \"secondary_industry_name\":\"IT科技/IT软件与服务\"" +
//                " }");
//        AlipayOpenPublicTemplateMessageIndustryModifyResponse response = alipayClient.execute(request);
//        //调用成功，则处理业务逻辑
//        if(response.isSuccess()){
//            //.....
//        }
//        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCcaP415I6t4qAJb+dcUR1u85Q6L3SyriomIazYQXvfTc1ea8HY7XAiPxUL+F2Zl5qW/ZAtTG/H0tkootPwG8uB77u/rIm0kh7jwz3+64ek5ReM4/oQJDwgz60ew8NeC5fgL9cXJGy0kSDdnBZWjfQ7yHTJLI0RTPQtNeV2Nj0ZAP4EQsmN/ZIsfCjX8uMq8+hx2YAEjCRH/AtOt2X5Qk3zP/FLSGYmVS+59X8k0+Qou5OQlVJI5ABQ3tkusyjuz4uL2wJ+np266xifaMNEW/O2VDjxC/uOWTatJ0UU0vB2j10wsXPI5+OjlQfriZP9hnaR5Sliv81ZweELRj5vxC23AgMBAAECggEAQ+QzC/OUlxe6vb3sIB85dnKWUZdNwU1mED0nyIrMGQatcSG299FAjizxlsuM3WF4Abg4f+Eg2AzGpCPheOSntlP4G9/pug5/CAA0hdV4gHPMgCRo497Glrtuet8gi07e8rnxVCNEaDBioq7g51sgu15sivIinXLYvlMZsfEjHhmpPe1g/qJ94N464LG+vS+ZAtbN8Q7+gHWF3vYPyDfX5dAIGLN0s9WddnjXDMh0cnS8U9I8wRQz6zXXmKUf2yhkFBI5k5ixUWCnd84z+1D2eFfOY2/g7ywmDiWj1atBNSGiTiWhsbTIBE2rHOQvcU6pRls2kbBcejffQhlO8/2H4QKBgQDR/2GX7wdSx02f8BcTQt9M4zy0sGE+3Td19jPJjrNWpJTug1D0Q4bo7sJ3wMCAthI7TMVkt7aYjvCdWubM10+JGiPHc3DD+gP+cJbUDkMR95mPaSaypbgLUEHtnwKBUA8MZBgEho+0OXv1TY33KjoFxkLeKl4CfTmqQIu9ALhNsQKBgQC+rHBjwVyHH+MUL9Zq766Je5cAMPabFrJ99iUBO06cndWkDtt0KP8hZr0W+x0WaBhFUQuBp6qu3Y0gCt3pozXTu/cgyR9jwWgt14yB8D7346jK0RDPgApLv5DUlQpj3KfBUW2QolWmYgvnNX/jgnU6jFRKHT22knKVrf0wa50D5wKBgB1hPnU0QvEI40paG9BdDcLDFA4vkxtpdcXyMSKk7WBU3GVWR/A0tl5GcTyx4fzf/EMBpahGr6w+a1mIizvjb8Q9vP29n+w7QW3KsL9wU1/jJT/UNU7PMqWaj+6/zWjsG37fTiDr9pT/aeFS/Wa0KLQAHgDZKpfsjzHLoAFMZXyxAoGBAINAfmkcvI3DdHP77hRUgwfejHY0Pj1J5Xpxys1LPvTubRbup0ARzHX4m+dK2p4G79YfUNViTkrq9W9+K33dvHrQ4++soq/vfcA4pV74us+25gUe3vyHPg8gghjjs3BEfzHC1LIAHQdYbKsul6dLsVipKoiOEmIv8zJ3v1bqbP43AoGBALiahznnOQuYrPWPrGBnCYG3gV4sNRpQiL9rNdbQLnnGRIjB3hplKshgh7fYJT8SFyArEA50MsVYSqwnmv14dbS7gjEV0vv7Sfs3aZdWLi2lO6hcyXMwRmqInmZ9Ix+/3q7pn41x1wKbSW48wm3EcRNIELwj8kMFeWx7oxGc6hMZ";
//        CertAlipayRequest alipayConfig = new CertAlipayRequest();
//        alipayConfig.setPrivateKey(privateKey);
//        alipayConfig.setServerUrl("https://openapi.alipaydev.com/gateway.do");
//        alipayConfig.setAppId("2021002186602780");
//        alipayConfig.setCharset("UTF8");
//        alipayConfig.setSignType("RSA2");
//        alipayConfig.setEncryptor("");
//        alipayConfig.setFormat("json");
//        alipayConfig.setCertContent("-----BEGIN CERTIFICATE-----\nMIIDmTCCAoGgAwIBAgIQICEQCYm7+s4NrFnyblQ9vzANBgkqhkiG9w0BAQsFADCBkTELMAkGA1UE\nBhMCQ04xGzAZBgNVBAoMEkFudCBGaW5hbmNpYWwgdGVzdDElMCMGA1UECwwcQ2VydGlmaWNhdGlv\nbiBBdXRob3JpdHkgdGVzdDE+MDwGA1UEAww1QW50IEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1\ndGhvcml0eSBDbGFzcyAyIFIxIHRlc3QwHhcNMjExMDA5MDMxMDAyWhcNMjMxMDA5MDMxMDAyWjBr\nMQswCQYDVQQGEwJDTjEfMB0GA1UECgwWbG5rdWFrOTI0NkBzYW5kYm94LmNvbTEPMA0GA1UECwwG\nQWxpcGF5MSowKAYDVQQDDCEyMDg4NjIxOTU2NTMzNTU4LTIwMjEwMDAxMTg2MjY5MzMwggEiMA0G\nCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCcaP415I6t4qAJb+dcUR1u85Q6L3SyriomIazYQXvf\nTc1ea8HY7XAiPxUL+F2Zl5qW/ZAtTG/H0tkootPwG8uB77u/rIm0kh7jwz3+64ek5ReM4/oQJDwg\nz60ew8NeC5fgL9cXJGy0kSDdnBZWjfQ7yHTJLI0RTPQtNeV2Nj0ZAP4EQsmN/ZIsfCjX8uMq8+hx\n2YAEjCRH/AtOt2X5Qk3zP/FLSGYmVS+59X8k0+Qou5OQlVJI5ABQ3tkusyjuz4uL2wJ+np266xif\naMNEW/O2VDjxC/uOWTatJ0UU0vB2j10wsXPI5+OjlQfriZP9hnaR5Sliv81ZweELRj5vxC23AgMB\nAAGjEjAQMA4GA1UdDwEB/wQEAwIE8DANBgkqhkiG9w0BAQsFAAOCAQEAU65zKdaulxGmWsoC+QGP\nK3AevzVX4JiD4fpnO/FPSvH4B2QaKS3D4TiGgJsJJHG01/9jGXFQO1URsHv6PG+VzxR5J375PO/U\nlLM8k0vCdlbojyOGVYjj39cXkS7h315+7pe2E5kNVS5AlRDNGOV2CRMYRY2g0wBSngc/4AqP9rql\nmZE08ZBBTLhrXXpjBxbOHLeTM7joR3S0Io2zMBVc/vPN9o+k1+ikQlo7mXaRNewsLApv8QnQnA34\nJ+kDw+Yzx8u0AJZXDCH1ue+xKtR/Wrurmln3rgJJaHE4kkeuPd6M8Z87cXgbi/1HJX9/0bLlyA+O\nqpwhffUamsN14HMHLw==\n-----END CERTIFICATE-----");
//        alipayConfig.setAlipayPublicCertContent("${alipayRequest.alipayPublicCertContent}");
//        alipayConfig.setRootCertContent("-----BEGIN CERTIFICATE-----\r\nMIIBszCCAVegAwIBAgIIaeL+wBcKxnswDAYIKoEcz1UBg3UFADAuMQswCQYDVQQG\r\nEwJDTjEOMAwGA1UECgwFTlJDQUMxDzANBgNVBAMMBlJPT1RDQTAeFw0xMjA3MTQw\r\nMzExNTlaFw00MjA3MDcwMzExNTlaMC4xCzAJBgNVBAYTAkNOMQ4wDAYDVQQKDAVO\r\nUkNBQzEPMA0GA1UEAwwGUk9PVENBMFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE\r\nMPCca6pmgcchsTf2UnBeL9rtp4nw+itk1Kzrmbnqo05lUwkwlWK+4OIrtFdAqnRT\r\nV7Q9v1htkv42TsIutzd126NdMFswHwYDVR0jBBgwFoAUTDKxl9kzG8SmBcHG5Yti\r\nW/CXdlgwDAYDVR0TBAUwAwEB/zALBgNVHQ8EBAMCAQYwHQYDVR0OBBYEFEwysZfZ\r\nMxvEpgXBxuWLYlvwl3ZYMAwGCCqBHM9VAYN1BQADSAAwRQIgG1bSLeOXp3oB8H7b\r\n53W+CKOPl2PknmWEq/lMhtn25HkCIQDaHDgWxWFtnCrBjH16/W3Ezn7/U/Vjo5xI\r\npDoiVhsLwg==\r\n-----END CERTIFICATE-----\r\n\r\n-----BEGIN CERTIFICATE-----\r\nMIIF0zCCA7ugAwIBAgIIH8+hjWpIDREwDQYJKoZIhvcNAQELBQAwejELMAkGA1UE\r\nBhMCQ04xFjAUBgNVBAoMDUFudCBGaW5hbmNpYWwxIDAeBgNVBAsMF0NlcnRpZmlj\r\nYXRpb24gQXV0aG9yaXR5MTEwLwYDVQQDDChBbnQgRmluYW5jaWFsIENlcnRpZmlj\r\nYXRpb24gQXV0aG9yaXR5IFIxMB4XDTE4MDMyMTEzNDg0MFoXDTM4MDIyODEzNDg0\r\nMFowejELMAkGA1UEBhMCQ04xFjAUBgNVBAoMDUFudCBGaW5hbmNpYWwxIDAeBgNV\r\nBAsMF0NlcnRpZmljYXRpb24gQXV0aG9yaXR5MTEwLwYDVQQDDChBbnQgRmluYW5j\r\naWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5IFIxMIICIjANBgkqhkiG9w0BAQEF\r\nAAOCAg8AMIICCgKCAgEAtytTRcBNuur5h8xuxnlKJetT65cHGemGi8oD+beHFPTk\r\nrUTlFt9Xn7fAVGo6QSsPb9uGLpUFGEdGmbsQ2q9cV4P89qkH04VzIPwT7AywJdt2\r\nxAvMs+MgHFJzOYfL1QkdOOVO7NwKxH8IvlQgFabWomWk2Ei9WfUyxFjVO1LVh0Bp\r\ndRBeWLMkdudx0tl3+21t1apnReFNQ5nfX29xeSxIhesaMHDZFViO/DXDNW2BcTs6\r\nvSWKyJ4YIIIzStumD8K1xMsoaZBMDxg4itjWFaKRgNuPiIn4kjDY3kC66Sl/6yTl\r\nYUz8AybbEsICZzssdZh7jcNb1VRfk79lgAprm/Ktl+mgrU1gaMGP1OE25JCbqli1\r\nPbw/BpPynyP9+XulE+2mxFwTYhKAwpDIDKuYsFUXuo8t261pCovI1CXFzAQM2w7H\r\nDtA2nOXSW6q0jGDJ5+WauH+K8ZSvA6x4sFo4u0KNCx0ROTBpLif6GTngqo3sj+98\r\nSZiMNLFMQoQkjkdN5Q5g9N6CFZPVZ6QpO0JcIc7S1le/g9z5iBKnifrKxy0TQjtG\r\nPsDwc8ubPnRm/F82RReCoyNyx63indpgFfhN7+KxUIQ9cOwwTvemmor0A+ZQamRe\r\n9LMuiEfEaWUDK+6O0Gl8lO571uI5onYdN1VIgOmwFbe+D8TcuzVjIZ/zvHrAGUcC\r\nAwEAAaNdMFswCwYDVR0PBAQDAgEGMAwGA1UdEwQFMAMBAf8wHQYDVR0OBBYEFF90\r\ntATATwda6uWx2yKjh0GynOEBMB8GA1UdIwQYMBaAFF90tATATwda6uWx2yKjh0Gy\r\nnOEBMA0GCSqGSIb3DQEBCwUAA4ICAQCVYaOtqOLIpsrEikE5lb+UARNSFJg6tpkf\r\ntJ2U8QF/DejemEHx5IClQu6ajxjtu0Aie4/3UnIXop8nH/Q57l+Wyt9T7N2WPiNq\r\nJSlYKYbJpPF8LXbuKYG3BTFTdOVFIeRe2NUyYh/xs6bXGr4WKTXb3qBmzR02FSy3\r\nIODQw5Q6zpXj8prYqFHYsOvGCEc1CwJaSaYwRhTkFedJUxiyhyB5GQwoFfExCVHW\r\n05ZFCAVYFldCJvUzfzrWubN6wX0DD2dwultgmldOn/W/n8at52mpPNvIdbZb2F41\r\nT0YZeoWnCJrYXjq/32oc1cmifIHqySnyMnavi75DxPCdZsCOpSAT4j4lAQRGsfgI\r\nkkLPGQieMfNNkMCKh7qjwdXAVtdqhf0RVtFILH3OyEodlk1HYXqX5iE5wlaKzDop\r\nPKwf2Q3BErq1xChYGGVS+dEvyXc/2nIBlt7uLWKp4XFjqekKbaGaLJdjYP5b2s7N\r\n1dM0MXQ/f8XoXKBkJNzEiM3hfsU6DOREgMc1DIsFKxfuMwX3EkVQM1If8ghb6x5Y\r\njXayv+NLbidOSzk4vl5QwngO/JYFMkoc6i9LNwEaEtR9PhnrdubxmrtM+RjfBm02\r\n77q3dSWFESFQ4QxYWew4pHE0DpWbWy/iMIKQ6UZ5RLvB8GEcgt8ON7BBJeMc+Dyi\r\nkT9qhqn+lw==\r\n-----END CERTIFICATE-----\r\n\r\n-----BEGIN CERTIFICATE-----\r\nMIICiDCCAgygAwIBAgIIQX76UsB/30owDAYIKoZIzj0EAwMFADB6MQswCQYDVQQG\r\nEwJDTjEWMBQGA1UECgwNQW50IEZpbmFuY2lhbDEgMB4GA1UECwwXQ2VydGlmaWNh\r\ndGlvbiBBdXRob3JpdHkxMTAvBgNVBAMMKEFudCBGaW5hbmNpYWwgQ2VydGlmaWNh\r\ndGlvbiBBdXRob3JpdHkgRTEwHhcNMTkwNDI4MTYyMDQ0WhcNNDkwNDIwMTYyMDQ0\r\nWjB6MQswCQYDVQQGEwJDTjEWMBQGA1UECgwNQW50IEZpbmFuY2lhbDEgMB4GA1UE\r\nCwwXQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkxMTAvBgNVBAMMKEFudCBGaW5hbmNp\r\nYWwgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkgRTEwdjAQBgcqhkjOPQIBBgUrgQQA\r\nIgNiAASCCRa94QI0vR5Up9Yr9HEupz6hSoyjySYqo7v837KnmjveUIUNiuC9pWAU\r\nWP3jwLX3HkzeiNdeg22a0IZPoSUCpasufiLAnfXh6NInLiWBrjLJXDSGaY7vaokt\r\nrpZvAdmjXTBbMAsGA1UdDwQEAwIBBjAMBgNVHRMEBTADAQH/MB0GA1UdDgQWBBRZ\r\n4ZTgDpksHL2qcpkFkxD2zVd16TAfBgNVHSMEGDAWgBRZ4ZTgDpksHL2qcpkFkxD2\r\nzVd16TAMBggqhkjOPQQDAwUAA2gAMGUCMQD4IoqT2hTUn0jt7oXLdMJ8q4vLp6sg\r\nwHfPiOr9gxreb+e6Oidwd2LDnC4OUqCWiF8CMAzwKs4SnDJYcMLf2vpkbuVE4dTH\r\nRglz+HGcTLWsFs4KxLsq7MuU+vJTBUeDJeDjdA==\r\n-----END CERTIFICATE-----\r\n\r\n-----BEGIN CERTIFICATE-----\r\nMIIDxTCCAq2gAwIBAgIUEMdk6dVgOEIS2cCP0Q43P90Ps5YwDQYJKoZIhvcNAQEF\r\nBQAwajELMAkGA1UEBhMCQ04xEzARBgNVBAoMCmlUcnVzQ2hpbmExHDAaBgNVBAsM\r\nE0NoaW5hIFRydXN0IE5ldHdvcmsxKDAmBgNVBAMMH2lUcnVzQ2hpbmEgQ2xhc3Mg\r\nMiBSb290IENBIC0gRzMwHhcNMTMwNDE4MDkzNjU2WhcNMzMwNDE4MDkzNjU2WjBq\r\nMQswCQYDVQQGEwJDTjETMBEGA1UECgwKaVRydXNDaGluYTEcMBoGA1UECwwTQ2hp\r\nbmEgVHJ1c3QgTmV0d29yazEoMCYGA1UEAwwfaVRydXNDaGluYSBDbGFzcyAyIFJv\r\nb3QgQ0EgLSBHMzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAOPPShpV\r\nnJbMqqCw6Bz1kehnoPst9pkr0V9idOwU2oyS47/HjJXk9Rd5a9xfwkPO88trUpz5\r\n4GmmwspDXjVFu9L0eFaRuH3KMha1Ak01citbF7cQLJlS7XI+tpkTGHEY5pt3EsQg\r\nwykfZl/A1jrnSkspMS997r2Gim54cwz+mTMgDRhZsKK/lbOeBPpWtcFizjXYCqhw\r\nWktvQfZBYi6o4sHCshnOswi4yV1p+LuFcQ2ciYdWvULh1eZhLxHbGXyznYHi0dGN\r\nz+I9H8aXxqAQfHVhbdHNzi77hCxFjOy+hHrGsyzjrd2swVQ2iUWP8BfEQqGLqM1g\r\nKgWKYfcTGdbPB1MCAwEAAaNjMGEwHQYDVR0OBBYEFG/oAMxTVe7y0+408CTAK8hA\r\nuTyRMB8GA1UdIwQYMBaAFG/oAMxTVe7y0+408CTAK8hAuTyRMA8GA1UdEwEB/wQF\r\nMAMBAf8wDgYDVR0PAQH/BAQDAgEGMA0GCSqGSIb3DQEBBQUAA4IBAQBLnUTfW7hp\r\nemMbuUGCk7RBswzOT83bDM6824EkUnf+X0iKS95SUNGeeSWK2o/3ALJo5hi7GZr3\r\nU8eLaWAcYizfO99UXMRBPw5PRR+gXGEronGUugLpxsjuynoLQu8GQAeysSXKbN1I\r\nUugDo9u8igJORYA+5ms0s5sCUySqbQ2R5z/GoceyI9LdxIVa1RjVX8pYOj8JFwtn\r\nDJN3ftSFvNMYwRuILKuqUYSHc2GPYiHVflDh5nDymCMOQFcFG3WsEuB+EYQPFgIU\r\n1DHmdZcz7Llx8UOZXX2JupWCYzK1XhJb+r4hK5ncf/w8qGtYlmyJpxk3hr1TfUJX\r\nYf4Zr0fJsGuv\r\n-----END CERTIFICATE-----");
//        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);
//        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
//        AlipayFundTransUniTransferModel model = new AlipayFundTransUniTransferModel();
//        model.setOutBizNo("201806300001");
//        model.setTransAmount("23.00");
//        model.setProductCode("TRANS_ACCOUNT_NO_PWD");
//        model.setBizScene("DIRECT_TRANSFER");
//        Participant payerInfo = new Participant();
//        payerInfo.setIdentity("2088123412341234");
//        payerInfo.setIdentityType("ALIPAY_USER_ID");
//        payerInfo.setName("xy");
//        BankcardExtInfo bankcardExtInforCUIO = new BankcardExtInfo();
//        bankcardExtInforCUIO.setInstName("招商银行");
//        bankcardExtInforCUIO.setAccountType("1");
//        payerInfo.setBankcardExtInfo(bankcardExtInforCUIO);
//        model.setPayerInfo(payerInfo);
//        Participant payeeInfo = new Participant();
//        payeeInfo.setIdentity("2088123412341234");
//        payeeInfo.setIdentityType("ALIPAY_USER_ID");
//        BankcardExtInfo bankcardExtInfoqgsHw = new BankcardExtInfo();
//        bankcardExtInfoqgsHw.setInstName("招商银行");
//        bankcardExtInfoqgsHw.setAccountType("1");
//        payeeInfo.setBankcardExtInfo(bankcardExtInfoqgsHw);
//        model.setPayeeInfo(payeeInfo);
//        request.setBizModel(model);
//        AlipayFundTransUniTransferResponse response = alipayClient.certificateExecute(request);
//        System.out.println(response.getBody());
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//        } else {
//            System.out.println("调用失败");
//        }
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016072200101XXXX","请复制第1步中生成的密钥中的商户应用私钥","json","utf-8","沙箱环境RSA2支付宝公钥","RSA2");
//        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
//        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
//        request.setBizModel(model);
//        model.setOutTradeNo("");
//        model.setTotalAmount("88.88");
//        model.setSubject("Iphone6 16G");
//        AlipayTradePrecreateResponse response = alipayClient.execute(request);
//        System.out.print(response.getBody());
//        System.out.print(response.getQrCode());
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest ();
        certAlipayRequest.setServerUrl("https://openapi.alipay.com/gateway.do");
        certAlipayRequest.setAppId("2021002187633038");
        certAlipayRequest.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJLBTsnYrSFPV6PHLmrimjeSwzZzcQKBdlfSagrb+7cHqBq4C7zIKjWYRjuv95BlbVAGUYm6jmZLUKVcQnKQ0ebVqJ+fPvCnuv+MWDIxXJ/88GdZD1ihgG7MWVSxI1AZGYZfOznyYP9n8s7R+rIQsIAwmRo8ePuu8gGHy+gmUALPIyR/Bx7JnkACCCuA1In5nhLr8Ca4PGb+1wj96rDkKi3+E0U+OnqKQHMbhrLpjWcotetYxJe50wfk1Uyc2mF17QgjL1+YusNQBvYgsxbEqaQpnn/zxhpDQUiXunryCph5a6wn7Y0+tzAX9cngClm9bPK6/qtAu9n95Hr3hgQTrnAgMBAAECggEAU1yqyrFjcBC0rjiWS4KEY4h8SDDt0a/LqC3Kj9OHtc3BZZRog7jhm4wHXOSD5XToyEGZLr9Kgdmp/EHrFzFne5pRb5CrohXo3SR+RBfKYhxIIFDKa64ks/CokvYwdm4hoVA0LnEFnKXc29yvZjyKi6/s3Ml/ueWM9SBsjwqHfvbtNKS9kUGzFDgTmZn2zlpiNAt0HUA9UEq9o1JH8ABgsVr7Yh7ctC3pH5ykf+GsdMZiRK4nEdxtZzlGwK1dNAOh7zfWLRB4jnuQlgEkNkrPnx5tvhvzDS+Ap3JwrQYhRjPqkHRZnJ6LpdU72g/1MCICwQmL2QJx6DO2KfleqAe/4QKBgQDKjH+A53NaMwL1Gbifl4v4Aef1f+4SLZrxr8s0Ni5lxoN2nOMyfDxcoRhLCyOwzymljPsE1yxlDUyU3zows3AAGVGLTXifETsOqa2bIvmJdY+8LfMb1dn/Ss2pXzr1BxR57s0q3+9PH9+Kj4oPF58gKOzcQFKfWnE0ZBzX0fPwTQKBgQCtXvasvrJMYUqpj6F0KzG1yEFCI52kgB+vlcfb1PPpmiH4tmGbhwngUL+K3J86d2p7W5yT8RdoCdojP5FtKzYt+cty/0kSC/KfdnQsPFJ5tP+1nWUamYC9RDLpc6EmLonwQ35gsVbrBbZl7psOryIakRVtWMlGeRpc4ACCkYASAwKBgAmzjwvaiiDg3pxkvf4O4Spg1P5iQUHno0s+M0pt6e0ABB3zR8KMRsvc/2/gubXnRkRiq0dBEyRH7coXow7gGVY34Dr+2+8qgRyjregHVdJqqhbGUKWdqZJbv9wD7qv7ydRJRtRt42Vzzl4xn9g3Nmzw6N9nyU1OpKtwvBzuNnPlAoGBAKPytMTBBO0z6B4W5HBt1HF6MTQxaAdC3jP2KWyaohobltqS5hTki5Nj6O6RGcZ5XOnQxW4lxKOvBWjl2UlqXq71lM5n2ZrGT6c6pjuaw8eyQUpm0FBqLxNMZfTcUt0/j1P1D5KywWY5HbahAGLPfSmwX5nrJ1OMfECt1+2hWIIvAoGAIbCVzjtQAuol7j38xhsxvcbFJR/PR0iI+BmucAc6bYU18onOSqnAIz2L2lD8tprVE7v0bi0/3fzhOP5pXSda0SCynhYx70llA+/vreNhtzhOENQd5XeGZYmXjxgV+tgzI/brYx3D0UzGfJKFtQDtP4EMiQvG7lbdxBXIfb75XQQ=");
        certAlipayRequest.setFormat("JSON");
        certAlipayRequest.setCharset("UTF-8");
        certAlipayRequest.setSignType("RSA2");
        certAlipayRequest.setCertPath("C:\\Users\\MC-701\\Downloads\\appCertPublicKey_2021002187633038.crt");
        certAlipayRequest.setAlipayPublicCertPath("C:\\Users\\MC-701\\Downloads\\alipayCertPublicKey_RSA2.crt");
        certAlipayRequest.setRootCertPath("C:\\Users\\MC-701\\Downloads\\alipayRootCert.crt" );
        DefaultAlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);

        // 提交数据至支付宝时请使用


        AlipayFundBatchDetailQueryRequest request = new AlipayFundBatchDetailQueryRequest();
        request.setBizContent("{" +
                "\"batch_no\":\"hk201703130008\"," +
                "\"biz_code\":\"BATCH_TRANS_ACC\"," +
                "\"biz_scene\":\"GLOBAL\"," +
                "\"sign_principal\":\"test@alipay.com\"," +
                "\"detail_no\":\"001\"," +
                "\"detail_status\":\"INIT\"," +
                "\"payee_account\":\"zhangsan@alipay.com\"," +
                "\"page_num\":1," +
                "\"product_code\":\"BATCH_PAY_V2\"," +
                "\"out_batch_no\":\"201801310127742502\"," +
                "\"out_biz_no\":\"2018999960760005838333\"," +
                "\"page_size\":\"1\"" +
                "  }");
        AlipayFundBatchDetailQueryResponse response = alipayClient.certificateExecute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

    }
}
