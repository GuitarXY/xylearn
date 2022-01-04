package com.example.dateutil;

import com.example.dateutil.base.BaseGeneralResult;
import com.example.dateutil.base.GeneralAnalyser;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoy
 * @date 2021/12/17
 */
public class GeneralAnalyserChain implements GeneralAnalyser {
    private final List<GeneralAnalyser> analysers = new LinkedList<>();
    private int currentPosition = 0;

    private GeneralAnalyserChain(List<GeneralAnalyser> analysers) {
        this.analysers.addAll(analysers);
    }

    @Override
    public void doAnalyse(String text, List<BaseGeneralResult> resultList, GeneralAnalyserChain analyseChain) {

        if (this.currentPosition == this.analysers.size()) {
            // analyse finish
            return;
        }

        this.currentPosition++;
        GeneralAnalyser nextFilter = this.analysers.get(this.currentPosition - 1);
        nextFilter.doAnalyse(text, resultList, this);
    }

    public static GeneralAnalyserChain newInstance(List<GeneralAnalyser> analysers){
        return new GeneralAnalyserChain(analysers);
    }

    public static GeneralAnalyserChain newInstance(GeneralAnalyser analyser){
        return new GeneralAnalyserChain(Collections.singletonList(analyser));
    }
}
