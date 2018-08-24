package org.system.service.impl.sms;

import org.springframework.stereotype.Service;
import org.system.entity.sms.SmsSendRecord;
import org.system.mapper.sms.SmsSendRecordMapper;
import org.system.service.iface.sms.ISmsSendRecordService;

import javax.annotation.Resource;

/**
 * @ClassName SmsSendRecordServiceImpl
 * @Author Zhao.Fei
 * @Date 2018/8/24 11:07
 * @Description TODO
 */
@Service
public class SmsSendRecordServiceImpl implements ISmsSendRecordService{

    @Resource
    private SmsSendRecordMapper mapper;

    @Override
    public int insertSmsSendRecord(SmsSendRecord smsSendRecord) {
        return mapper.insert(smsSendRecord);
    }
}
