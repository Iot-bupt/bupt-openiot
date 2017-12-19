package com.bupt.openiot.dao.communication;

import com.bupt.openiot.dao.mapper.ComMethodMapper;
import com.bupt.openiot.dao.model.ComMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by dy on 2017/5/24.
 */
@Service
public class CommunicationMethodServiceImpl implements CommunicationMethodService {

    @Autowired
    private ComMethodMapper comMethodMapper;

    @Override
    public List<ComMethod> getAll() {
        return comMethodMapper.selectAll();
    }
}
