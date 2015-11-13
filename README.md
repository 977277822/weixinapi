# 生成微信服务号config配置

### 获取微信票据 票据对象最好在服务器端缓存起来，每隔一个小时自动调用一次刷新票据
WeiXinUtil.getTicketBean(appId,secret);  return ticketBean;

### 根据票据计算微信js_config 配置
WeiXinUtil.getWeiXinApiBean(ticketBean,url);

## 第一个参数为appid

## 第二个参数为secret

## 第三个url为需要处理的URL，如果需要传递参数，则直接在URL中拼接参数即可。

## 如果有什么出现问题，请在wiki里留言
