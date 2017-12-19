package com.bupt.openiot.dao.communication;

import com.bupt.openiot.dao.mapper.FunDirectionMapper;
import com.bupt.openiot.dao.model.FunDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dy on 2017/5/24.
 */
@Service
public class FunctionDirectionServiceImpl implements FunctionDirectionService {

    @Autowired
    private FunDirectionMapper funDirectionMapper;

    @Override
    public List<FunDirection> getAll() {
        return funDirectionMapper.selectAll();
    }
}
