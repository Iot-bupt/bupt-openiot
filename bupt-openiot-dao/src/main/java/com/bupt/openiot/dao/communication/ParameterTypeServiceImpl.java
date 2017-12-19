package com.bupt.openiot.dao.communication;

import com.bupt.openiot.dao.mapper.ParameterTypeMapper;
import com.bupt.openiot.dao.model.ParameterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dy on 2017/5/24.
 */
@Service
public class ParameterTypeServiceImpl implements ParameterTypeService {

    @Autowired
    private ParameterTypeMapper parameterTypeMapper;

    @Override
    public List<ParameterType> getAll() {
        return parameterTypeMapper.selectAll();
    }
}
