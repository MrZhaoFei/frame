package org.system.service.iface.sms;

import org.system.entity.sms.SmsSendRecord;

public interface ISmsSendRecordService {

    /**
     * @Author Zhao.Fei
     * @Param [smsSendRecord]
     * @Date 2018/8/24 11:03
     * @return int
     * @Description 新增短信记录
     **/
    public int insertSmsSendRecord(SmsSendRecord smsSendRecord);


}
