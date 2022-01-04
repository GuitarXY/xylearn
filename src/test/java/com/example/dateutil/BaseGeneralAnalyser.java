package com.example.dateutil;

import com.example.dateutil.base.BaseGeneralResult;
import com.example.dateutil.base.GeneralAnalyser;

import java.util.List;
import java.util.Objects;

/**
 * @author xiaoy
 * @date 2021/12/17
 */
public abstract class BaseGeneralAnalyser<E,T extends BaseGeneralResult> implements GeneralAnalyser {

    @Override
    public void doAnalyse(String val, List<BaseGeneralResult> resultList, GeneralAnalyserChain analyseChain) {
        if (val == null || val.isEmpty()) {
            analyseChain.doAnalyse(val, resultList, analyseChain);
            return;
        }

        E results = parsePatterResults(val);
        if (Objects.nonNull(results)) {
            resultList.add(transfer(results));
        }
        analyseChain.doAnalyse(val, resultList, analyseChain);

    }

    protected abstract BaseGeneralResult transfer(E results);

    protected abstract E parsePatterResults(String val);
}
