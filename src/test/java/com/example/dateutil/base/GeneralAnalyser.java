package com.example.dateutil.base;

import com.example.dateutil.GeneralAnalysedResult;
import com.example.dateutil.GeneralAnalyserChain;

import java.util.List;

/**
 * @author xiaoy
 * @date 2021/12/17
 */
public interface GeneralAnalyser {
    void doAnalyse(String val, List<BaseGeneralResult> resultList, GeneralAnalyserChain analyseChain);

}
