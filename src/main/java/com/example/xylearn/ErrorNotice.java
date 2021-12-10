//package com.example.xylearn;
//
///**
// * @author xiaoy
// * @date 2021/12/6
// */
//public class ErrorNotice {
//    /**
//     * 发送报警
//     *
//     * @param msgType   msg类型
//     * @param throwable 异常
//     * @param isAt      是否需要@人
//     * @param isAtAll   是否@所有人
//     * @param atUsers   @用户列表 传手机号
//     */
//    public static void alarm(MsgType msgType, Throwable throwable, boolean isAt, boolean isAtAll, List<String> atUsers) {
//        DingConfig config = dingRobotUtil.dingConfig;
//        if (!config.isEnable()) {
//            return;
//        }
//        log.info("钉钉机器人 - 发送报警信息");
//        DingTalkClient client = new DefaultDingTalkClient(config.getWebhook());
//        OapiRobotSendRequest request = new OapiRobotSendRequest();
//        request.setMsgtype(msgType.getValue());
//        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
//        // 内容必须包含 "报错" 等关键字，否则发送会失败，关键字可以在钉钉机器人管理修改
//        text.setContent(buildErrMsg(throwable));
//        request.setText(text);
//        if (isAt) {
//            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
//            if (CollectionUtils.isEmpty(atUsers)) {
//                at.setAtMobiles(atUsers);
//            } else {
//                at.setAtMobiles(config.getAtMobiles());
//            }
//
//            // 是否@所有人
//            at.setIsAtAll(isAtAll);
//            // 开发者文档显示可以这样传参，其实没有这个参数 setAtMobiles 用来指定要@的用户
//            // at.setAtUserIds(Arrays.asList("109929","32099"));
//            request.setAt(at);
//        }
//        try {
//            log.info("钉钉机器人 - 报警内容：{}", JSON.toJSON(request));
//            OapiRobotSendResponse response = client.execute(request);
//            log.info("钉钉机器人 - 报警结束：{}", JSON.toJSON(response));
//        } catch (Exception e) {
//            log.error("钉钉机器人 - 报警失败：{}", e);
//        }
//    }
//    @SneakyThrows
//    private static String buildErrMsg(Throwable throwable) {
//        StringBuffer msg = new StringBuffer();
//        InetAddress inetAddress = InetAddress.getLocalHost();
//        msg.append("报错日期: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        // 注意 主机名和IP，需要在服务器的hosts文件里修改，否则拿到的就是默认的localhost和127.0.0.1
//        msg.append("\n主机名称: ").append(inetAddress.getHostName());
//        msg.append("\n主机IP: ").append(inetAddress.getHostAddress()).append("\n");
//        msg.append("\n日志路径: ").append(getLogPath()).append("\n");
//        msg.append("\n异常方法: ").append(throwable.getStackTrace()[0]).append("\n");
//        // 业务自定义的异常
//        if (throwable instanceof ServiceException) {
//            ServiceException e = (ServiceException) throwable;
//            msg.append("\n异常信息: ").append(e.getMsg()).append("\n");
//        }
//        // 代码运行未知异常
//        if (throwable instanceof Exception)
//            msg.append("\n异常信息: ").append(throwable).append("\n");
//        return msg.toString();
//    }
//
//    /**
//     * 获取日志路径
//     *
//     * @return {@link String}
//     * @throws IOException ioexception
//     */
//    public static String getLogPath() throws IOException {
//        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
//        ch.qos.logback.classic.Logger logger = context.getLogger("ROOT");
//        //输出日志文件的appender的name属性
//        FileAppender fileAppender = (FileAppender) logger.getAppender("infoLog");
//        File file = new File(fileAppender.getFile());
//
//        return file.getCanonicalPath();
//    }
//
//    @ExceptionHandler(ServiceException.class)
//    public ResultBody resolveBusinessException(ServiceException e) {
//        log.info("系统内部错误:", e);
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        ResultBody result = ResultBody.fail(e.getCode(), e.getMsg());
//        request.setAttribute(RESPONSE_DATA, result);
//        DingRobotUtil.alarm(DingRobotUtil.MsgType.TEXT, e,true, false, null);
//        return result;
//    }
//
//}
