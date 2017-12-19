package com.bupt.openiot.dao.communication;

import com.bupt.openiot.dao.mapper.ComProtocolMapper;
import com.bupt.openiot.dao.model.ComProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dy on 2017/5/24.
 */
@Service
public class CommunicationProtocolServiceImpl implements CommunicationProtocolService {

    @Autowired
    private ComProtocolMapper comProtocolMapper;

    @Override
    public List<ComProtocol> getAll() {
        return comProtocolMapper.selectAll();
    }
}
